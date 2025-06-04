package com.backend.fastx.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.fastx.dto.BookingDetailsResponse;
import com.backend.fastx.enums.BookingStatus;
import com.backend.fastx.enums.DistanceCategory;
import com.backend.fastx.enums.SeatPosition;
import com.backend.fastx.exception.ResourceNotFoundException;
import com.backend.fastx.model.Booking;
import com.backend.fastx.model.BookingDetails;
import com.backend.fastx.model.Customer;
import com.backend.fastx.model.Schedule;
import com.backend.fastx.repository.BookingDetailsRepository;
import com.backend.fastx.repository.BookingRepository;
import com.backend.fastx.repository.CustomerRepository;
import com.backend.fastx.repository.ScheduleRepository;
import com.backend.fastx.util.FareUtil;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired 
    private BookingDetailsRepository bookingDetailsRepository;

    public Booking bookInBus(int customerId, int scheduleId, Booking booking) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer ID invalid: " + customerId));

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule ID invalid: " + scheduleId));

        int requestedSeats = booking.getTotalSeats();

        if (schedule.getAvailableSeats() < requestedSeats) {
            throw new IllegalStateException("Not enough seats available");
        }

        booking.setCustomer(customer);
        booking.setSchedule(schedule);
        booking.setDate(LocalDate.now());
        booking.setStatus(BookingStatus.PENDING);

        // Use distanceCategory and seatPosition from booking instead of null
        DistanceCategory distanceCategory = booking.getDistanceCategory();
        SeatPosition seatPosition = booking.getSeatPosition();

        // Calculate fare per seat and total fare
        double farePerSeat = FareUtil.calculateFare(schedule.getBaseFare(), booking.getSeatType(), distanceCategory, seatPosition);
        double totalFare = farePerSeat * requestedSeats;
        booking.setTotalFare(totalFare);

        // Update available seats in schedule
        schedule.setAvailableSeats(schedule.getAvailableSeats() - requestedSeats);
        scheduleRepository.save(schedule);

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));
    }

    public List<Booking> getBookingsByCustomer(int customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Booking> getBookingsBySchedule(int scheduleId) {
        return bookingRepository.findByScheduleId(scheduleId);
    }

    public Booking updateBooking(int bookingId, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));

        int newTotalSeats = updatedBooking.getTotalSeats();
        Schedule schedule = existingBooking.getSchedule();

        int seatDifference = newTotalSeats - existingBooking.getTotalSeats();

        if (seatDifference > 0 && schedule.getAvailableSeats() < seatDifference) {
            throw new IllegalStateException("Not enough seats available for update");
        }

        // Update available seats on schedule
        schedule.setAvailableSeats(schedule.getAvailableSeats() - seatDifference);
        scheduleRepository.save(schedule);

        // Update booking details
        existingBooking.setStatus(updatedBooking.getStatus());
        existingBooking.setTotalSeats(newTotalSeats);
        existingBooking.setSeatType(updatedBooking.getSeatType());

        // Also update distanceCategory and seatPosition if provided
        existingBooking.setDistanceCategory(updatedBooking.getDistanceCategory());
        existingBooking.setSeatPosition(updatedBooking.getSeatPosition());

        // Recalculate total fare with updated fields
        double totalFare = FareUtil.calculateFare(schedule.getBaseFare(),
                updatedBooking.getSeatType(),
                updatedBooking.getDistanceCategory(),
                updatedBooking.getSeatPosition()) * newTotalSeats;
        existingBooking.setTotalFare(totalFare);

        return bookingRepository.save(existingBooking);
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));

        Schedule schedule = booking.getSchedule();
        schedule.setAvailableSeats(schedule.getAvailableSeats() + booking.getTotalSeats());
        scheduleRepository.save(schedule);

        bookingRepository.delete(booking);
    }
    public BookingDetailsResponse getFullBookingDetails(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));

        List<BookingDetails> bookingDetailsList = bookingDetailsRepository.findByBookingId(bookingId);

        BookingDetailsResponse response = new BookingDetailsResponse();
        response.setBookingId(booking.getId());
        response.setDate(booking.getDate());
        response.setTotalSeats(booking.getTotalSeats());
        response.setStatus(booking.getStatus());
        response.setTotalFare(booking.getTotalFare());
        response.setSeatType(booking.getSeatType());
        
        response.setCustomer(booking.getCustomer());
        response.setSchedule(booking.getSchedule());
        response.setBookingDetails(bookingDetailsList);

        return response;
    }

}






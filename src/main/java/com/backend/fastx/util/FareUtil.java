package com.backend.fastx.util;

import com.backend.fastx.enums.SeatType;
import com.backend.fastx.enums.DistanceCategory;
import com.backend.fastx.enums.SeatPosition;

public class FareUtil {

    public static double calculateFare(double baseFare, SeatType seatType, DistanceCategory distanceCategory, SeatPosition seatPosition) {
        double fare = baseFare;

        if (seatType != null) {
            switch (seatType) {
                case SLEEPER:
                    fare += 300;
                    break;
                case SEMI_SLEEPER:
                    fare += 200;
                    break;
                case SEATER:
                    fare += 100;
                    break;
            }
        }

        if (distanceCategory != null) {
            switch (distanceCategory) {
                case SHORT:
                    fare += 50;
                    break;
                case MEDIUM:
                    fare += 150;
                    break;
                case LONG:
                    fare += 300;
                    break;
            }
        }

        if (seatPosition != null) {
            switch (seatPosition) {
                case WINDOW:
                    fare += 50;
                    break;
                case MIDDLE:
                    fare += 20;
                    break;
                case AISLE:
                    fare += 30;
                    break;
            }
        }

        return fare;
    }
}


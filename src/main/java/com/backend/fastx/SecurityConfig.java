package com.backend.fastx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //<- This ensures that this class gets called during every API call
public class SecurityConfig {
	@Autowired
	private JwtFilter jwtFilter;
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrf) -> csrf.disable()) 
			.authorizeHttpRequests(authorize -> authorize
					// Public endpoints
	                .requestMatchers("/api/get/allcustomer").permitAll()
	                .requestMatchers("/api/user/signup").permitAll()
	                .requestMatchers("/api/busoperators/create").permitAll()

	                // Authenticated user token endpoint
	                .requestMatchers("/api/user/token").authenticated()

	                // CUSTOMER and EXECUTIVE roles
	                .requestMatchers("/api/add/customer").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/customer/get-one").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/update/customer/{id}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/get/customer/byname/{name}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/delete/customer/{id}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")

	                .requestMatchers("/api/booking/create/{customerId}/{scheduleId}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/booking/customer/{customerId}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/booking/schedule/{scheduleId}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/booking/update/{bookingId}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/booking/cancel/{bookingId}").hasAnyAuthority("CUSTOMER", "EXECUTIVE")
	                .requestMatchers("/api/payment/create/{bookingId}").hasAuthority("CUSTOMER")
	                .requestMatchers("/api/payment/get/{id}").hasAuthority("CUSTOMER")

	                // BUSOPERATOR and EXECUTIVE roles
	                .requestMatchers("/api/buses/add").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/buses/getall").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/buses/getall/{id}").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/busesupdate/{id}").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")

	                .requestMatchers("/api/busoperators/get").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")

	                .requestMatchers("/api/busroutes/add").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/busroutes/get").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/busroutes/get-one/{id}").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")

	                .requestMatchers("/api/schedules/create").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")

	                .requestMatchers("/api/seat/create").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/seat/getall").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/seat/add/seat").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/seat/update/{id}").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/seat/delete/{id}").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")
	                .requestMatchers("/api/seat/get/{id}/fare").hasAnyAuthority("BUSOPERATOR", "EXECUTIVE")

	                .requestMatchers("/api/bookings/create/{customerId}/{scheduleId}").hasAnyAuthority("CUSTOMER", "BUSOPERATOR")

	                // All other endpoints require authentication
	                .anyRequest().authenticated()
	            			)
			.httpBasic(Customizer.withDefaults())
		 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) ;
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {  //<- Bean saves this object in spring's context
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager getAuthManager(AuthenticationConfiguration auth) 
			throws Exception {
		  return auth.getAuthenticationManager();
	 }
}
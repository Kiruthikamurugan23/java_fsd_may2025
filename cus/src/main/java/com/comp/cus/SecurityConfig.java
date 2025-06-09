package com.comp.cus;

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
					
	                .requestMatchers("/api/user/signup").permitAll()
					.requestMatchers("/api/user/token").authenticated()
					.requestMatchers("/api/patient/add").authenticated()
					.requestMatchers("/api/doctor/add").authenticated()
					.requestMatchers("/api/medicalhistory/all").authenticated()
					.requestMatchers("/api/patientdoctor/appointment/{doctorId}").permitAll()
					.requestMatchers("/api/patientdoctor/patient/medicalhistory/userdetails/{patientId}").hasAuthority("Patient")
					.requestMatchers("/api/patientdoctor/doctor/{doctorId}/patients").hasAuthority("Doctor")
					.requestMatchers("/api/patientdoctor/medical-history/{patientId}").permitAll()
					
					
			
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
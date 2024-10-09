package com.miapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityService {
	 	
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    	http
            // Permitir el acceso sin autenticación a la H2 Console
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()  // Excluir H2 console de la autenticación
                    .anyRequest().authenticated()  // Otras rutas requieren autenticación
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))  // Deshabilitar CSRF para H2 Console
            )
            .headers(headers -> headers
                .frameOptions().sameOrigin()  // Permitir que la consola H2 se renderice en un frame
            )
            .httpBasic();  // Utiliza autenticación básica
        return http.build();
	    }
}

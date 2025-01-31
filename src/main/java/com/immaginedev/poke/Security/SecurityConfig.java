package com.immaginedev.poke.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //TODO: Cambiar security, ahora es uno de chatGPT para que funcione actualmente las requests API.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilitar CSRF solo si no es necesario (por ejemplo, para APIs públicas)
                .csrf(AbstractHttpConfigurer::disable)

                // Configurar las autorizaciones de las solicitudes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/pokemon/**").permitAll() // Permitir acceso público
                        .anyRequest().authenticated() // Requerir autenticación para otros endpoints
                )

                // Opcional: puedes configurar la autenticación si la necesitas
                .formLogin(AbstractHttpConfigurer::disable) // Deshabilitar el formulario de login
                .httpBasic(AbstractHttpConfigurer::disable); // Deshabilitar autenticación básica
        return http.build();
    }
}
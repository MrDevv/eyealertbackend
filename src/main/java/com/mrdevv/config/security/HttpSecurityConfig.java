package com.mrdevv.config.security;

import com.mrdevv.config.security.filter.JwtAuthenticationFilter;
import com.mrdevv.config.security.handler.CustomAccessDeniedHandler;
import com.mrdevv.config.security.handler.CustomAuthenticationEntryPoint;
import com.mrdevv.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    private AuthenticationProvider authenticationProvider;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private CustomAccessDeniedHandler customAccessDeniedHandler;
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    public HttpSecurityConfig(AuthenticationProvider authenticationProvider, JwtAuthenticationFilter jwtAuthenticationFilter, CustomAccessDeniedHandler customAccessDeniedHandler, CustomAuthenticationEntryPoint customAuthenticationEntryPoint){
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessMagConfig -> sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(excepHandler ->{
                    excepHandler.accessDeniedHandler(customAccessDeniedHandler);
                    excepHandler.authenticationEntryPoint(customAuthenticationEntryPoint);
                })
                .authorizeHttpRequests(getManagerRequestMatcherRegistryCustomizer())
                .build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> getManagerRequestMatcherRegistryCustomizer() {
        return authHttpRequests -> {
            authHttpRequests.requestMatchers(HttpMethod.GET, "/evaluaciones/tiempo-promedio-prediccion").hasRole(Roles.ADMINISTRADOR.getRol());
            authHttpRequests.requestMatchers(HttpMethod.GET, "/evaluaciones/tasa-acierto").hasRole(Roles.ADMINISTRADOR.getRol());
            authHttpRequests.requestMatchers(HttpMethod.PATCH, "/evaluaciones/{id}").hasRole(Roles.ADMINISTRADOR.getRol());
            authHttpRequests.requestMatchers(HttpMethod.GET, "/evaluaciones").hasRole(Roles.ADMINISTRADOR.getRol());

            authHttpRequests.requestMatchers(HttpMethod.GET, "/cuestionarioConocimientos").hasRole(Roles.ADMINISTRADOR.name());
            authHttpRequests.requestMatchers(HttpMethod.GET, "/cuestionarioConocimientos/indice-conocimiento").hasRole(Roles.ADMINISTRADOR.name());

            authHttpRequests.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
            authHttpRequests.requestMatchers(HttpMethod.POST, "/auth/create-usuario").permitAll();

            authHttpRequests.anyRequest().authenticated();
        };
    }
}

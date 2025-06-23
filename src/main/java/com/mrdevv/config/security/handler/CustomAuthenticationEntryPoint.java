package com.mrdevv.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mrdevv.payload.ResponseError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        int httpStatus = HttpStatus.UNAUTHORIZED.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "No está logeado o su token no es válido, por favor inicie sesión.",
                "No se encontró un token de autenticación o este a expirado.",
                localDateTime,
                null
        );

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(httpStatus);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String apiErrorAsJson = objectMapper.writeValueAsString(responseError);
        response.getWriter().write(apiErrorAsJson);
    }
}

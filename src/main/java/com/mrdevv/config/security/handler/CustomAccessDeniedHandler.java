package com.mrdevv.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mrdevv.payload.ResponseError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        int httpStatus = HttpStatus.FORBIDDEN.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "No tiene el rol para acceder a este recurso, comuniquese con un administrador.",
                "Acceso denegado para acceder al recurso solicitado por rol sin permisos.",
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

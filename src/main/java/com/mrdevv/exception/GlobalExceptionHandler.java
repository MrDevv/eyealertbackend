package com.mrdevv.exception;

import com.mrdevv.payload.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            Exception.class,
            ObjectDuplicateException.class,
            ObjectNotFoundException.class,
            ObjectNotPermissions.class
    })
    public ResponseEntity<ResponseError> handlerAllException(Exception exception, HttpServletRequest request, HttpServletResponse response){
        ZoneId zoneId = ZoneId.of("America/Lima");
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);

        if (exception instanceof ObjectDuplicateException objectDuplicateExcepction){
            return handlerDataIntegrityViolationException(objectDuplicateExcepction, request, response, localDateTime);
        }else if (exception instanceof ObjectNotFoundException objectNotFoundException){
            return handlerObjectNotFoundException(objectNotFoundException, request, response, localDateTime);
        }else if (exception instanceof PasswordNotMatchesException passwordNotMatchesException){
            return handlerPasswordNotMatchesException(passwordNotMatchesException, request, response, localDateTime);
        }else if (exception instanceof ObjectNotPermissions objectNotPermissions){
            return handlerObjectNotPermissions(objectNotPermissions, request, response, localDateTime);
        }

        return handlerException(exception, request, response, localDateTime);
    }

    private ResponseEntity<ResponseError> handlerObjectNotPermissions(ObjectNotPermissions objectNotPermissions, HttpServletRequest request, HttpServletResponse response, LocalDateTime localDateTime) {
        int httpStatus = HttpStatus.FORBIDDEN.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                objectNotPermissions.getMessageFront(),
                objectNotPermissions.getMessage(),
                localDateTime,
                null
        );

        return ResponseEntity.status(httpStatus).body(responseError);
    }

    private ResponseEntity<ResponseError> handlerPasswordNotMatchesException(PasswordNotMatchesException passwordNotMatchesException, HttpServletRequest request, HttpServletResponse response, LocalDateTime localDateTime) {
        int httpStatus = HttpStatus.BAD_REQUEST.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                passwordNotMatchesException.getMessageFront(),
                passwordNotMatchesException.getMessage(),
                localDateTime,
                null
        );

        return ResponseEntity.status(httpStatus).body(responseError);
    }

    public ResponseEntity<ResponseError> handlerObjectNotFoundException(ObjectNotFoundException objectNotFoundException, HttpServletRequest request, HttpServletResponse response, LocalDateTime localDateTime){
        int httpStatus = HttpStatus.NOT_FOUND.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                objectNotFoundException.getMessageFront(),
                objectNotFoundException.getMessage(),
                localDateTime,
                null
        );

        return ResponseEntity.status(httpStatus).body(responseError);
    }

    private ResponseEntity<ResponseError> handlerDataIntegrityViolationException(ObjectDuplicateException objectDuplicateExcepction, HttpServletRequest request, HttpServletResponse response, LocalDateTime localDateTime) {
        int  httpStatus = HttpStatus.CONFLICT.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httpStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                objectDuplicateExcepction.getMessageFront(),
                objectDuplicateExcepction.getMessage(),
                localDateTime,
                null
        );

        return ResponseEntity.status(httpStatus).body(responseError);
    }

    private ResponseEntity<ResponseError> handlerException(Exception exception, HttpServletRequest request, HttpServletResponse response, LocalDateTime localDateTime) {
        int httStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ResponseError responseError = new ResponseError(
                "Failed",
                httStatus,
                request.getRequestURL().toString(),
                request.getMethod(),
                "Lo sentimos ocurrió un error en nuestro servidor. Por favor intentelo mas tarde",
                exception.getMessage(),
                localDateTime,
                null
        );

        return ResponseEntity.status(httStatus).body(responseError);
    }


}

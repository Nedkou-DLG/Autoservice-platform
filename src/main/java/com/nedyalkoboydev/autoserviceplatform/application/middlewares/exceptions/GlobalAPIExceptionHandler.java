package com.nedyalkoboydev.autoserviceplatform.application.middlewares.exceptions;

import com.nedyalkoboydev.autoserviceplatform.application.middlewares.exceptions.models.ExceptionResponse;
import com.nedyalkoboydev.autoserviceplatform.domain.constants.ExceptionConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalAPIExceptionHandler {
    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleUserNotFound(
            AuthenticationException exception,
            final HttpServletRequest request
            ){
        return ExceptionResponse.builder()
                .errorMessage(ExceptionConstants.BAD_CREDS)
                .requestedURI(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleAllExeptions(Exception ex, final HttpServletRequest request){
        return ExceptionResponse.builder()
                .errorMessage(ExceptionConstants.BAD_REQUEST)
                .requestedURI(request.getRequestURI())
                .build();
    }
}

package com.covid.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNameAlreadyExistsException.class)
    public void springHandleUsernameAlreadyExistsException(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value(),"USER_ALREADY_EXISTS");
    }

    @ExceptionHandler(InvalidUsernameOrPasswordException.class)
    public void springHandleInvalidUsernameOrPasswordException(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value(),"INVALID_CREDENTIALS");
    }



}

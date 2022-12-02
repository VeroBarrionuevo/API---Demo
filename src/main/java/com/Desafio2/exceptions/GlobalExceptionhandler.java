package com.Desafio2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> defaultErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(),req.getRequestURI(),"Código interno"+" "+123), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersonaNotFound.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> notFoundException(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(), req.getRequestURI(),"Código interno"+" "+123),HttpStatus.NOT_FOUND);
    }

}

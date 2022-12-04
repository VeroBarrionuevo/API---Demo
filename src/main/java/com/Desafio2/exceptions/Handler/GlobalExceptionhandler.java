package com.Desafio2.exceptions.Handler;

import com.Desafio2.exceptions.DTOexeption.ErrorMensajeDTO;
import com.Desafio2.exceptions.Kinds.NumeroNotFound;
import com.Desafio2.exceptions.Kinds.PersonaNotFound;
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
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(),req.getRequestURI(),"Codigo interno"+" "+123), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersonaNotFound.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> notFoundException(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(), req.getRequestURI(),"Codigo interno"+" "+123),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumeroNotFound.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> notNumeroFoundException(HttpServletRequest req, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(), req.getRequestURI(),"Codigo interno"+" "+123),HttpStatus.BAD_REQUEST);
    }

}

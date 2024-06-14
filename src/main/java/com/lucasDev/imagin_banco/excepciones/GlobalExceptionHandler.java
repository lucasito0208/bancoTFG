package com.lucasDev.imagin_banco.excepciones;


import com.lucasDev.imagin_banco.model.ModeloRespuesta;
import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<ModeloRespuesta> handleEntityExistsException(EntityExistsException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        ModeloRespuesta
                                .builder()
                                .status(HttpStatus.CONFLICT)
                                .success(false)
                                .errors(ex.getMessage())
                                .build()
                );
    }



}

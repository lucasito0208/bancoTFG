package com.lucasDev.imagin_banco.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloRespuesta {

    private HttpStatus status;
    private boolean success;
    private Object data;
    private Object errors;

}

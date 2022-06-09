package com.pragma.microserviciocliente.infrastructure.exception;

public class NoSuchElementFoundException extends RuntimeException {

    public NoSuchElementFoundException(String message){
        super(message);
    }


}

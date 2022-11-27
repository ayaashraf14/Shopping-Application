package com.example.demo.errors;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {

        super(s);
    }

}

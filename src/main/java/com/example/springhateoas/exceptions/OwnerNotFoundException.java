package com.example.springhateoas.exceptions;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(Long id) {
        super("OwnerNotFoundException with id: " + id);
    }
}

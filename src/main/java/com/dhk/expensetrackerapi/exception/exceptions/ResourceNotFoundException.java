package com.dhk.expensetrackerapi.exception.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String key;

    public ResourceNotFoundException(String resource, Object key) {
        super(resource + "is not found. key=" + key);
    }
}

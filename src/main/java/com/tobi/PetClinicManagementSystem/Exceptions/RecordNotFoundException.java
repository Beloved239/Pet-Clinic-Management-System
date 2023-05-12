package com.tobi.PetClinicManagementSystem.Exceptions;

public class RecordNotFoundException extends Exception{

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

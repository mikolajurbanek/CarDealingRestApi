package com.codecool.exceptions;

import java.io.IOException;

public class ObjectNotFoundException extends IOException {
    public ObjectNotFoundException(String className) {
        super("Object " + className + " not found in DB");
    }
}

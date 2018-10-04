package com.thenopebox.pinet.generic;

import lombok.Getter;

public abstract class NotFoundException extends Exception {
    @Getter
    private Long id;

    public NotFoundException(Long id) {
        super("Cannot retrieve value by identifier: " + id);
    }

    public NotFoundException() {
        super("Cannot retrieve value by identifier.");
    }
}

package com.neoris.turnosrotativos.exceptions;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {

        super(message);
    }
}

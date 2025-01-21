package com.drinkmachine.raffle.exception;

public class RaffleException extends RuntimeException {

    private String message;

    public RaffleException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }
}

package com.drinkmachine.global;

import com.drinkmachine.raffle.exception.RaffleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RaffleException.class)
    @ResponseBody
    public String raffleException(RaffleException e) {
        return e.getMessage();
    }
}

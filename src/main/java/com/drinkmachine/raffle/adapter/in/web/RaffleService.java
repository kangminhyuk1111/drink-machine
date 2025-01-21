package com.drinkmachine.raffle.adapter.in.web;

import com.drinkmachine.raffle.application.port.in.EnterRaffleUsecase;
import com.drinkmachine.raffle.application.port.out.RafflePort;
import com.drinkmachine.raffle.domain.RaffleResult;
import com.drinkmachine.raffle.exception.RaffleException;
import org.springframework.stereotype.Service;

@Service
public class RaffleService implements EnterRaffleUsecase {

    private final RafflePort rafflePort;

    public RaffleService(final RafflePort rafflePort) {
        this.rafflePort = rafflePort;
    }

    @Override
    public RaffleResult enter(final String phoneNumber) {
        if (rafflePort.isEnteredToday(phoneNumber)) {
            throw new RaffleException("you already raffled today.");
        }

        return new RaffleResult(phoneNumber);
    }
}

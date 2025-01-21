package com.drinkmachine.raffle.application.port.in;

import com.drinkmachine.raffle.domain.RaffleResult;

public interface EnterRaffleUsecase {

    RaffleResult enter(String phoneNumber);
}

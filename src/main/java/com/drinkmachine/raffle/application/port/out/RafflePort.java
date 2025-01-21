package com.drinkmachine.raffle.application.port.out;

import com.drinkmachine.raffle.domain.Raffle;

public interface RafflePort {

    boolean isEnteredToday(String phoneNumber);

    void save(Raffle entry);
}

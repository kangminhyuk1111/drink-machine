package com.drinkmachine.raffle.adapter.out;

import com.drinkmachine.raffle.application.port.out.RafflePort;
import com.drinkmachine.raffle.data.RaffleRepository;
import com.drinkmachine.raffle.domain.Raffle;
import org.springframework.stereotype.Repository;

@Repository
public class RaffleDbAdapter implements RafflePort {

    private final RaffleRepository raffleRepository;

    public RaffleDbAdapter(final RaffleRepository raffleRepository) {
        this.raffleRepository = raffleRepository;
    }

    @Override
    public boolean isEnteredToday(final String phoneNumber) {
        return raffleRepository.isRaffledToday(phoneNumber);
    }

    @Override
    public void save(final Raffle raffle) {
        raffleRepository.save(raffle);
    }
}

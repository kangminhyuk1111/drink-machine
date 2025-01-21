package com.drinkmachine.raffle.data;

import com.drinkmachine.raffle.domain.Raffle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InmemoryRaffleRepository implements RaffleRepository {

    private final List<Raffle> raffles = new ArrayList<>();

    @Override
    public List<Raffle> findAll() {
        return raffles;
    }

    @Override
    public void save(final Raffle raffle) {
        raffles.add(raffle);
    }

    @Override
    public Boolean isRaffledToday(final String phoneNumber) {
        return raffles.stream()
                .filter(Raffle::isRaffledToday)
                .anyMatch(raffle -> raffle.getPhoneNumber().equals(phoneNumber));
    }
}

package com.drinkmachine.raffle.data;

import com.drinkmachine.raffle.domain.Raffle;

import java.util.List;

public interface RaffleRepository {

    // 래플 응모 내역 전체 검색
    List<Raffle> findAll();

    // 래플 응모 내역 저장
    void save(Raffle raffle);

    // 당일 래플 내역 검색
    Boolean isRaffledToday(String phoneNumber);
}

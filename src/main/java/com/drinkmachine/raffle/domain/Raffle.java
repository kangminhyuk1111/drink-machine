package com.drinkmachine.raffle.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Raffle {

    private Long id;
    private String itemName;
    private String phoneNumber;
    private LocalDateTime raffledTime;

    public Raffle() {
    }

    public Raffle(final Long id, final String itemName, final String phoneNumber, final LocalDateTime raffledTime) {
        this.id = id;
        this.itemName = itemName;
        this.phoneNumber = phoneNumber;
        this.raffledTime = raffledTime;
    }

    public boolean isRaffledToday() {
        return raffledTime.toLocalDate().equals(LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getRaffledTime() {
        return raffledTime;
    }
}

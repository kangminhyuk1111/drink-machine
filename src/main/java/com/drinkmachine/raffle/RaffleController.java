package com.drinkmachine.raffle;

import com.drinkmachine.raffle.application.port.in.EnterRaffleUsecase;
import com.drinkmachine.raffle.domain.RaffleResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raffle")
public class RaffleController {

    private final EnterRaffleUsecase enterRaffleUsecase;

    public RaffleController(final EnterRaffleUsecase enterRaffleUsecase) {
        this.enterRaffleUsecase = enterRaffleUsecase;
    }

    @PostMapping
    public RaffleResult enterRaffle(@RequestBody String phoneNumber) {
        return enterRaffleUsecase.enter(phoneNumber);
    }
}

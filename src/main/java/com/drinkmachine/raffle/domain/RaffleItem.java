package com.drinkmachine.raffle.domain;

public class RaffleItem {
    
    private String itemName; // 아이템 이름
    private Integer stock; // 아이템 재고 수량

    public RaffleItem(final String itemName, final Integer stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getStock() {
        return stock;
    }
}

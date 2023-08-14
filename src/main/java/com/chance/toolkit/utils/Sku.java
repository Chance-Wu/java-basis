package com.chance.toolkit.utils;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: Sku
 * @author: chance
 * @date: 2022/10/17 15:33
 * @since: 1.0
 */
@Data
public class Sku {

    private String name;
    private BigDecimal price;

    public Sku(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

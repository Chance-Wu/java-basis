package com.chance.designpatterns.patterns.strategy;

public enum PrizeTypeEnum {

    //奖品类型
    POINT("point", "积分"),
    VIRTUAL_CURRENCY("virtual currency", "虚拟币"),
    CASH("cash","发放现金");

    private String value;
    private String name;

    PrizeTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

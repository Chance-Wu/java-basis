package com.chance.basis.entity;

/**
 * @Description: Car
 * @Author: chance
 * @Date: 12/5/20 2:45 PM
 * @Version 1.0
 */
public class Car {

    private String brand = null;

    private int doors = 0;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", doors=" + doors +
                '}';
    }
}
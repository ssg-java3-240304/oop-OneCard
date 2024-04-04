package com.sh.objectType.card;

public class Clover extends Card{
    public Clover() {
    }

    public Clover(int number) {
        super(number);
    }

    @Override
    public String toString() {
        return "Clover " + this.getNumber() +
                "입니다.";
    }

}

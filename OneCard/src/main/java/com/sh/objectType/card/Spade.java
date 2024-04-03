package com.sh.objectType.card;

public class Spade extends Card{
    public Spade() {
    }

    public Spade(int number) {
        super(number);
    }

    @Override
    public String toString() {
        return "Spade " + this.getNumber() +
                "입니다.";
    }
}

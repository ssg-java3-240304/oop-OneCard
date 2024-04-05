package com.sh.objectType.card;

public class Heart extends Card{
    public Heart() {
    }

    public Heart(int number) {
        super(number);
    }

    @Override
    public String toString() {
        return "Heart♥️ " + this.getNumber();
    }
}

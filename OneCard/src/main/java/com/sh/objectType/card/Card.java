package com.sh.objectType.card;

public abstract class Card {
    private int number;
    private String shape;
    public Card() {
    }

    public Card(int number, String shape) {
        this.number = number;
        this.shape = shape;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", shape='" + shape + '\'' +
                '}';
    }

    public boolean compare(card1, card2) { //카드 비교
        //숫자가 같거나, 모양이 같을 때 ->
        for (int i = 0; i < 14; i ++) {

        }

    }
}

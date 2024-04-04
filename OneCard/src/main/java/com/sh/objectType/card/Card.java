package com.sh.objectType.card;

public class Card {
    private int number;

    public Card() {
    }

    public Card(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void compare(Card card) {
        if(card.number == this.number || this.equals(card)){
            System.out.println("낼 수 있습니다.");
        }else {
            System.out.println("낼 수 없는 카드입니다. 다른 카드를 골라주세요!");
        }
    }


}

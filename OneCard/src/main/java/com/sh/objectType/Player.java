package com.sh.objectType;

import com.sh.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private CardDeck cardDeck;

    // 생성자
    public Player() {
    }

    public Player(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    // 메소드
    public Card getCard(int index) {
        return cardDeck.getCard(index);
    }

    public void insertCard(Card card) {
        cardDeck.addCard(card);
    }

    public Card removeCard(int index) {
        Card pickCard = cardDeck.getCard(index);
        return cardDeck.removeCard(pickCard);
    }

    public void alarmOneCard() {
        if (cardDeck.size() == 1) {
            System.out.println("원카드!");
        }
    }

    public boolean checkWin() {
        if (cardDeck.size() == 0) {
            System.out.println("승리하셨습니다!");
            return true;
        }
        return false;
    }


}

package com.sh.objectType;

import com.sh.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // 필드
    private CardDeck cardDeck;
    private int id;

    // getter/setter
    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 생성자
    public Player() {
    }

    public Player(int id) {
        this.id = id;
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
            System.out.println("🃏 원카드!");
        }
    }

    public void checkWin() {
        if (cardDeck.size() == 0) {
            System.out.println("🎊 승리하셨습니다!!! 🎊");
            throw new GameOver();
        }
    }


}

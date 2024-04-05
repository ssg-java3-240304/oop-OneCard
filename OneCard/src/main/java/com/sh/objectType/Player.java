package com.sh.objectType;


import com.sh.CardDeck;
import com.sh.exception.GameOver;
import com.sh.objectType.card.Card;
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
        cardDeck = new CardDeck();
        this.id = id;
    }

    // 메소드
    public Card getCard(int index) {
        return cardDeck.getCard(index);
    }

    public void insertCard(Card card) {
        cardDeck.addCard(card);
    }

    public Card removeCard(int index) throws Exception {
        Card pickCard = cardDeck.getCard(index);

        if(!cardDeck.removeCard(pickCard)) {
            throw new Exception("잘못된 인덱스");
        }
        return pickCard;
    }

    public void alarmOneCard() {
        if (cardDeck.getLength() == 1) {
            System.out.println("🃏 원카드!");
        }
    }

    public void checkWin() throws GameOver {
        if (cardDeck.getLength() == 0) {
            System.out.println("🎊 승리하셨습니다!!! 🎊");
            throw new GameOver(String.valueOf(this.id));
        }
    }

    public void printDeck() {
        this.cardDeck.printDeque();
    }


}

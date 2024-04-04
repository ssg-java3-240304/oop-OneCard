package com.sh;

import com.sh.objectType.card.Card;

import java.util.*;

public class CardDeck {
    List<Card> cardDeck =  new ArrayList<>();
    public int length;

    public CardDeck() {
    }

    public CardDeck(List<Card> cardDeck, Random rand, int length) {
        this.cardDeck = cardDeck;
        this.length = length;
    }

    public void addCard(Card card) {
        cardDeck.add(card);
    }
    public Card removeCard(int index) {
        return cardDeck.remove(index);
    }
    public Card getCard(int index) {
        return cardDeck.get(index);
    }
    public List<Card> mergeDeck(List<Card> cardDeck) {
        this.cardDeck.addAll(cardDeck);
        this.shuffle();
        return this.cardDeck;
    }
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }
    public Card getTopCard() {
        return cardDeck.get(cardDeck.size() - 1);
    }
    public void printDeque() {
        System.out.println(this.cardDeck);
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}

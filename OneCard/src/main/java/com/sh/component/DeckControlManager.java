package com.sh.component;

import com.sh.CardDeck;
import com.sh.objectType.card.Card;

import java.util.List;
import java.util.stream.IntStream;

public class DeckControlManager {

    private static DeckControlManager instance;
    private CardDeck openDeck;
    private CardDeck garbageDeck;

    public DeckControlManager() {
    }

    public static DeckControlManager getInstance() {
        if (instance == null) {
            instance = new DeckControlManager();
        }

        return instance;
    }

    public void deckInit() {
        openDeck = new CardDeck();
        garbageDeck = new CardDeck();

        for(CardFactory.CardKind kind: CardFactory.CardKind.values()) {

            IntStream.rangeClosed(1, 13).forEach((i)
                    -> openDeck.addCard(CardFactory.createCard(kind, i))
            );
        }

    }

    public void deckShuffle() {
        openDeck.shuffle();
    }

    public Card drawCard() {
        Card card = openDeck.getTopCard();
        openDeck.removeCard(card);
        garbageDeck.addCard(card);
        return card;
    }

    public void mergeGarbageDeckAndOpenDeck() {
        openDeck.mergeDeck(garbageDeck);
    }

    public Card popTopOpenDeck() {
        Card card = openDeck.getTopCard();
        openDeck.removeCard(card);
        return card;
    }

    public void addCardGarbage(Card card) {
        garbageDeck.addCard(card);

    }

}

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
        deckShuffle();

    }

    public void deckShuffle() {
        openDeck.shuffle();
    }

    public Card drawCard() {
        Card card = openDeck.getTopCard();
        openDeck.removeCard(card);
        return card;
    }

    public void mergeGarbageDeckAndOpenDeck() {
        openDeck.mergeDeck(garbageDeck);
    }

    public Card popTopOpenDeck() {
        Card card = openDeck.getTopCard();
        if(card != null) {
            openDeck.removeCard(card);
            return card;
        }
        else{//오픈덱 없을 때
            if(garbageDeck.getLength() > 0) {
                garbageDeck.shuffle();
                while (openDeck.getLength() > 0)
                    openDeck.addCard(garbageDeck.getTopCard());
                card = openDeck.getTopCard();
            }
            else {
                card = null;

                System.out.println("뽑을 카드가 없습니다.");
            }
        }
        return card;
    }

    public void addCardGarbage(Card card) {
        garbageDeck.addCard(card);

    }

}

package com.sh.component;

import com.sh.objectType.card.Card;

import java.util.function.Function;
import java.util.function.Supplier;

import com.sh.objectType.card.*;


public class CardFactory {


    public enum CardKind {
        SPADE((i) -> new Spade(i)),

        CLOVER((i) -> new Clover(i)),

        DIAMOND((i) -> new Diamond(i)),

        HEART((i) -> new Heart(i));


        CardKind(Function<Integer, Card> supplier) {
            card = supplier;
        }
        private Function<Integer, Card> card;
        public Function<Integer, Card> getCard() {
            return card;
        }
    }
    public static Card createCard(CardKind kind, int index) {
        return kind.getCard().apply(index);
    }


}

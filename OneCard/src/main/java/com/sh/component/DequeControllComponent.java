package com.sh.component;

import com.sh.objectType.card.Card;
import com.sh.objectType.card.Deck;

import java.util.Deque;
import java.util.Random;

import static com.sh.Main.TOTAL_CARDS;

//덱 클래스 내부에 둘것..?
public class DequeControllComponent {
    Random randNum;
    public DequeControllComponent() {
        randNum = new Random();
    }

    //덱 클레스에서 할것 (지민)
    public void mainDeckShuffle(){
        deck.suffle();
    }
}

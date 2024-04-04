package com.sh.component;

import java.util.Deque;
import java.util.Random;

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

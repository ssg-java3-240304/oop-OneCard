package com.sh.component;

import java.util.Deque;
import java.util.Scanner;

public class GameInitComponent {
    PlayerOrderManager playerOrderManager = PlayerOrderManager.getInstance();
    public Deque<Card> init(Deque<Card> dealerDeck){
        //카드 생성 노가다 코드? 1 ~ 54까지 셔플 된 덱으로 만들기
        return dealerDeck;
    }
    //유저 숫자 입력받기
    public int inputPlayerNumber(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    // 덱 나눈후에 [플레이어수][7카드갯수]로 된 이차원배열로 반환
    public void dealerDeckDistribution(int n){
        playerOrderManager.
    }

    //


}

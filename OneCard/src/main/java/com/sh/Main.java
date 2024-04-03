package com.sh;

import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    private Deque openDeque = null;
    private Deque  garbageDeque  = null;
    private CyclicPlayerLinkedList<Player> players = null;
    private int numPlayers;

     */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        System.out.println("게임을 시작 하시겠습니까");


        while(true) {


            numPlayers = intput....

            startGameInit(numPlayers);


            //순서 정하기
            playerOrdering();
            //오픈 덱에서 카드 한장 공개
            openCard();
            // Game start
            while(true) {

                Player currPlayer = Players

                while() {
                    // 해당 순서 플레이어 카드덱 프린트

                    player


                    // 한장이라도 냈는지 안냈는지
                    boolean flag = false
                    // 선수로 부터 입력값 받기 (낼지 말지)
                    input;
                    if (input == false) {
                        if(flag == false) {
                            insertCard(card);
                        }

                        break;

                    }

                    // 카드 인데스 인풋 받기

                    Card recievedCard = sendCard();
                    // 카드 검사
                    valid = isValid(recievedCard);
                    if valid == true
                        removeCard(i);

                        garbage.insertCard(card);

                        // j, k, q 효과카드 처리


                        flag = true;

                    eles {
                        print("wrong card!!!")
                    }

                } // turn loop

                // 플레이어 카드 수 확인 (한명이라도 카드가 0 장이면 게임 끝)

                //
                rotation();


            } // game loop

            regame()?




        } // main loop
    }

    void startGameInit() {
        openDequeInit();

        playerInit(numPlayers);

    }

    void palyerInit(int numPlayers) {
        // numPlayers 의 플레이어 생성
        createPlayers();
        // 각 자에게 카드 분배
        cardSeperation();

    }
}
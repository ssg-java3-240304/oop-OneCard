package com.sh;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


import com.sh.component.DeckControlManager;
import com.sh.component.PlayerOrderManager;
import com.sh.exception.GameOver;
import com.sh.objectType.Player;
import com.sh.objectType.card.Card;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlayerOrderManager playerOrderManager = PlayerOrderManager.getInstance();

        DeckControlManager deckControlManager = DeckControlManager.getInstance();

        String response = null;
        while(true) {

            System.out.println("게임을 시작 하시겠습니까");

            response = Main.inputYesOrNo(scanner);

            if (response == "N" || response == "no") {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            System.out.println("플레이어 수를 입력해주세요");

            int numPlayers = 0;

            while(scanner.hasNext()) {
                System.out.print("2 - 5명");

                numPlayers = scanner.nextInt();

                if (!(numPlayers >= 2 && numPlayers <= 5)) {
                    System.err.println("잘못된 입력 입니다.");

                } else {
                    break;
                }
            }

            playerOrderManager.initPlayers(numPlayers);

            for(int i = 0; i < numPlayers; ++i) {
                Player currPlayer = playerOrderManager.getCurrentPlayer();
                for(int t = 0; t < 7; ++t) {
                    currPlayer.insertCard(deckControlManager.popTopOpenDeck());
                }
            }


            //순서 정하기
            playerOrderManager.decidePlayerOrder();
            //오픈 덱에서 카드 한장 공개
            Card topCard = deckControlManager.drawCard();

            try {

                // Game start
                while (true) {

                    Player currPlayer = playerOrderManager.getCurrentPlayer();

                    while (true) {
                        // 해당 순서 플레이어 카드덱 프린트
                        currPlayer.printDeck();

                        // 한장이라도 냈는지 안냈는지
                        boolean flag = false;


                        // 선수로 부터 입력값 받기 (낼지 말지)
                        System.out.println("카드를 제출 하시겠습니까?");


                        response = inputYesOrNo(response);

                        if (response == "N" || response == "no") {
                            if (!flag) {
                                Card tempCard = deckControlManager.popTopOpenDeck();
                                currPlayer.insertCard(tempCard);
                            }
                            break;
                        }

                        while (true) {

                            // 카드 인데스 인풋 받기
                            System.out.println("카드를 선택해 주세요.");

                            int cardIndex = scanner.nextInt();

                            Card recievedCard = currPlayer.getCard(cardIndex);

                            // 카드 검사
                            boolean valid = recievedCard.compare(topCard);

                            if (valid) {
                                currPlayer.removeCard(cardIndex);

                                deckControlManager.addCardGarbage(recievedCard);

                                topCard = recievedCard;

                                // j, q, k 효과카드 처리 11 12 13
                                if (topCard.getNumber() == 11) {

                                } else if top

                                flag = true;

                                // 현재 플레이어가 이겼다라는 예외처리경우 게임이 종료
                                currPlayer.checkWin();

                            } else {
                                System.err.println("잘못된 입력 입니다.");
                            }
                        }

                    } // turn loop

                    // 다음 차례 플레이어
                    playerOrderManager.nextTurnChange();


                } // game loop
            } catch (GameOver over) {
                System.out.println(over.getMessage() + "플레이어가 승리하였습니다.");
                deckControlManager.m


            }


        } // main loop


    } // main method

    public static String inputYesOrNo(Scanner scanner){
        while(true) {
            System.out.print("Y/N, yes/no");

            String response = scanner.next();

            switch (response) {
                case "N", "no", "Y", "yes" -> {
                    return response;
                }
                default -> System.err.println("잘못된 입력 입니다.");
            }
        }
    }


}
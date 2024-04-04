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

    public static int cardNums = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlayerOrderManager playerOrderManager = PlayerOrderManager.getInstance();

        DeckControlManager deckControlManager = DeckControlManager.getInstance();

        deckControlManager.deckInit();
        String response = null;
        while(true) {

            System.out.println("게임을 시작 하시겠습니까");

            response = Main.inputYesOrNo(scanner);

            if (response.equals("N") || response.equals("no"))  {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            System.out.println("플레이어 수를 입력해주세요");
            System.out.print("2 - 5명");

            int numPlayers = 0;

            while(scanner.hasNext()) {

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
                for(int t = 0; t < cardNums; ++t) {
                    currPlayer.insertCard(deckControlManager.popTopOpenDeck());
                }
                playerOrderManager.nextTurnChange();
            }


            //순서 정하기
            playerOrderManager.decidePlayerOrder();
            //오픈 덱에서 카드 한장 공개
            Card topCard = deckControlManager.drawCard();

            try {

                // Game start
                while (true) {

                    Player currPlayer = playerOrderManager.getCurrentPlayer();

                    // 한장이라도 냈는지 안냈는지
                    boolean flag = false;

                    while (true) {
                        System.out.println((currPlayer.getId() + 1) + " 번째 플레이어 입니다");

                        // 해당 순서 플레이어 카드덱 프린트
                        currPlayer.printDeck();

                        //맨 위 카드 보여주기
                        System.out.println(topCard);

                        // 선수로 부터 입력값 받기 (낼지 말지)
                        System.out.println("카드를 제출 하시겠습니까?");


                        response = inputYesOrNo(scanner);

                        if (response.equals("N") || response.equals("no")) {
                            if (!flag) {
                                Card tempCard = deckControlManager.popTopOpenDeck();
                                currPlayer.insertCard(tempCard);
                                System.out.println("카드 한장을 가져갑니다.");
                                currPlayer.printDeck();
                            }
                            System.out.println("NO");
                            break;
                        }

                        while (true) {

                            // 카드 인데스 인풋 받기
                            System.out.println("카드를 선택해 주세요.");
                            System.out.println("1 부터 " + currPlayer.getCardDeck().length + "사이에서 고르세요");

                            int cardIndex = scanner.nextInt();

                            cardIndex -= 1;

                            Card recievedCard = currPlayer.getCard(cardIndex);

                            // 카드 검사
                            boolean valid = recievedCard.compare(topCard);

                            if (valid) {
                                currPlayer.removeCard(cardIndex);

                                deckControlManager.addCardGarbage(recievedCard);

                                topCard = recievedCard;

                                // j, q, k 효과카드 처리 11 12 13
                                if (topCard.getNumber() == 11) {
                                    playerOrderManager.useJCard();
                                    System.out.println("J 카드가 발동됩니다 플레이어 한명 건너뜁니다");
                                    break;

                                } else if (topCard.getNumber() == 12) {
                                    playerOrderManager.useQCard();
                                    System.out.println("Q 카드가 발동됩니다 순서가 반대로 바뀝니다");
                                    break;

                                } else if(topCard.getNumber() == 13) {
                                    playerOrderManager.useKCard();
                                    System.out.println("K 카드가 발동됩니다 한번더 제출 가능합니다.");
                                    break;
                                }
                                System.out.println(recievedCard);

                                flag = true;

                                // 현재 플레이어가 이겼다라는 예외처리경우 게임이 종료
                                currPlayer.checkWin();

                                break;

                            } else {
                                System.out.println("잘못된 카드 입니다.");
                                break;
                            }
                        }

                    } // turn loop

                    // 다음 차례 플레이어
                    playerOrderManager.nextTurnChange();


                } // game loop
            } catch (GameOver over) {
                System.out.println(over.getMessage() + "플레이어가 승리하였습니다.");
                break;

            } catch (Exception e) {
                throw new RuntimeException(e);
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
package com.sh.component;

import com.sh.objectType.CircularPlayLinkedList;
import com.sh.objectType.Player;

import java.util.Random;

//싱글톤 컴포넌트
public class PlayerOrderManagerComponent {
    private static PlayerOrderManagerComponent instance;
    private CircularPlayLinkedList<Player> playerList;
    private boolean direction_flag = true;
    // 생성자를 private로 선언하여 외부에서의 직접적인 인스턴스화를 방지
    private PlayerOrderManagerComponent() {
        playerList = new CircularPlayLinkedList<Player>();
    }

    // 인스턴스에 대한 전역 접근 지점을 제공
    public static PlayerOrderManagerComponent getInstance() {
        if (instance == null) {
            // 인스턴스가 null일 경우에만 인스턴스 생성
            instance = new PlayerOrderManagerComponent();
        }
        return instance;
    }
    public boolean playerAdd(Player player) {
        playerList.add(player);
        return true;
    }
    //유저 순서 랜덤하게 정하기, -> 플레이어 전부 삽입 이후에 실행.
    public void decidePlayerOrder(){
        Random rand = new Random(playerList.getSize());
        for(int i = 0; i < rand.nextInt(); ++i){
            nextTurnChange();
        }
    }
    //순서 다음 유저에게 넘기기
    public void nextTurnChange(){
        if(direction_flag)
            playerList.moveFront();
        else if(!direction_flag)
            playerList.moveBack();
    }
    // 현재 차례 유저 얻어오기
    public Player getCurrentPlayer(){
        return playerList.getfirstPlayer();
    }

    //Q카드 사용 메서드
    public void useJCard(){
        playerList.rotation();
        playerList.rotation();
    }

    //순서 역순으로 변경  ... Q카드 사용 메서드
    public void useQCard(){
        direction_flag = !direction_flag;
    }

    //리스트 해더 한칸 뒤로 이동시키고, 순서 진행시켜서 헤더 앞으로 한칸 이동시키면 다시 기존해 했던 유저를 가르켜서 한번 더 할 수 있게 한다.
    public void userKCard(){
        playerList.moveBack();
    }


    // 필요한 메서드들 추가...
}

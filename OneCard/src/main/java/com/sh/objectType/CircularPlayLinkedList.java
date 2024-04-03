package com.sh.objectType;

public class CircularPlayLinkedList<Player> {
    private Node<Player> head; // 노드의 첫 부분을 가리키는 레퍼런스
    private Node<Player> tail; // 노드의 끝 부분을 가리키는 레퍼런스
    private int size; // 리스트 요소 갯수

    // 생성자
    public CircularPlayLinkedList<Player>() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 노드 클래스
    private static class Node<Player> {
        private Player player; // Node에 담을 데이터
        private Node<Player> next; // 다음 Node 객체를 가르키는 래퍼런스
        private Node<Player> prev; // 이전 Node 객체를 가르키는 래퍼런스

        // 생성자 (이전 노드 포인트 | 데이터 | 다음 노드 포인트)
        Node(Node<Player> prev, Player player, Node<Player> next) {
            this.player = player;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addFirst(Player value) {

        // 1. head와 tail을 임시 백업함
        Node<Player> first = head;
        Node<Player> last = tail;

        // 2. 새 노드를 추가 (이때 첫번째 노드니까 prev는 null이 되고 next는 head가 가리키는 노드가 되게 된다)
        Node<Player> new_node = new Node<>(null, value, first);

        // 3. 노드를 추가하였으니 리스트 크기 증가
        size++;

        // 4. 첫번째 기준이 변경되었으니 head를 삽입된 새 노드로 참조하도록 업데이트
        head = new_node;

        if (first == null) {
            // 5. 만일 빈 리스트에서 최초의 요소 추가였을 경우,
            tail = new_node; // tail도 첫째 노드를 바라보도록 업데이트

            // circular 처리
            new_node.next = new_node; // 추가 노드는 서로 자기 자신을 참조하게 됨
            new_node.prev = new_node;
        } else {
            // 6. 만일 빈 리스트가 아닐경우,
            first.prev = new_node; // 추가되기 이전 첫번째이었던 노드에서 prev를 새 노드로 참조하도록 업데이트

            // circular 처리
            last.next = new_node; // 마지막 노드의 next를 추가 노드를 바라보도록 참조
            new_node.prev = last; // 추가 노드(첫번째)의 prev를 마지막 노드를 바라보도록 참조
        }
    }
    public int getSize(){
        return size;
    }
    public void addLast(Player value) {

        // 1. head와 tail을 임시 백업함
        Node<Player> first = head;
        Node<Player> last = tail;

        // 2. 새 노드를 추가 (이때 마지막 노드니까 next는 null이 되고 prev는 tail이 가리키는 노드가 되게 된다)
        Node<Player> new_node = new Node<>(last, value, null);

        // 3. 노드를 추가하였으니 리스트 크기 증가
        size++;

        // 4. 마지막 노드 기준이 변경되었으니 tail을 삽입된 새 노드로 참조하도록 업데이트
        tail = new_node;

        if (last == null) {
            // 5. 만일 빈 리스트에서 최초의 요소 추가였을 경우,
            head = new_node; // tail도 첫째 노드를 바라보도록 업데이트

            // circular 처리
            new_node.next = new_node; // 추가 노드는 서로 자기 자신을 참조하게 됨
            new_node.prev = new_node;
        } else {
            // 6. 만일 빈 리스트가 아닐경우,
            last.next = new_node; // 추가되기 이전 마지막이었던 노드에서 next를 새 노드로 참조하도록 업데이트

            // circular 처리
            new_node.next = first; // 추가 노드(마지막)의 next를 첫번째 노드를 바라보도록 참조
            first.prev = new_node; // 첫번째 노드의 prev를 추가 노드를 바라보도록 참조
        }
    }

    public boolean add(Player player) {
        addLast(player);
        return true;
    }

   public Player remove() {

        // 1. 만약 삭제할 요소가 아무것도 없으면 에러
        if (head == null) {
            throw new RuntimeException();
        }

        // 2. 삭제될 첫번째 요소의 데이터를 백업
        Player returnValue = head.player;

        // 3. 두번째 노드를 임시 저장
        Node<Player> first = head.next;

        // 4. 첫번째 노드의 내부 요소를 모두 삭제
        head.next = null;
        head.player = null;

        // 5. head가 다음 노드를 가리키도록 업데이트
        head = first;

        // 6. 요소가 삭제 되었으니 크기 감소
        size--;

        // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
        if (head == null) {
            tail = null;
        }

        // 8. 마지막으로 삭제된 요소를 반환
        return returnValue;
    }


    public void moveBack(){
        head = head.prev;
        tail = tail.prev;
    }

    public void moveFront(){
        tail = head;
        head = head.next;
    }

    public void rotation() {
        // head를 다음 노드로 이동시키고 tail도 업데이트

    }
    public Player getfirstPlayer(){
        if (head == null || head.next == head) {
            return head.player;
        }
        return head.player;
    }
}


//        CircularPlayLinkedList<Player> 사용 예제 코드
//
//        CircularPlayLinkedList<Player> playerList = new CircularPlayLinkedList<Player>();
//        Player p0 = new Player();
//        playerList.add(p0);
//        Player p1 = new Player();
//        playerList.add(p1);
//        //현재 차례 유저 얻기
//        Player currentPlayer = playerList.currentPlayer();
//        // 순서 변경
//        playerList.rotation();
//        //현재 차례 유저 얻기
//        Player currentPlayer2 = playerList.currentPlayer();

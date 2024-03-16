package Algorithms;


import java.util.ArrayList;

public class LinkedList {

    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;


    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        Node curr = head.next;
        int i = 0;
        while(curr!=null){
            if(i == index){
                return curr.value;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node curr = new Node(val);  //make a new node
        curr.next = head.next;
        head.next = curr;
        if(curr.next == null){
            tail = curr;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        this.tail.next = newNode;
        this.tail = this.tail.next;

    }

    public boolean remove(int index) {
        Node prev = head;
        Node curr = head.next;
        int i = 0;
        while(curr != null){
            if(i == index){
                prev.next = curr.next;
                if(prev.next == null){
                    tail = prev;
                }
                return true;
            }
            prev = prev.next;
            curr = curr.next;
            i++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> a = new ArrayList<>();
        Node curr = head.next;
        while(curr!= null){
            a.add(curr.value);
            curr = curr.next;
        }
        return a;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.insertTail(1);
        a.insertTail(2);
        System.out.println(a.get(1));
        a.remove(1);
        a.insertTail(2);
        System.out.println(a.get(1));
        System.out.println(a.get(0));
    }
}


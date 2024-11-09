// Nth node from last is equal to (Size - n+1)node from first.
import java.util.*;
public class RemoveN_End {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void remove(Node head, int n){
        int size = 0;
        Node temp = head;
        if(head == null){
           return ;
        }
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n == size){
            head = head.next;
            return;
        }
        int i = 1;
        int idxToFind = size - n;
        Node prev = head;
        while(i<idxToFind){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    public static void print(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        int n = 4;
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        print(head);
        remove(head, n);
        System.out.println();
        print(head);
        System.out.println();
    }
}

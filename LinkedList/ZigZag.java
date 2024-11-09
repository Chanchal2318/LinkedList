import java.util.*;
public class ZigZag {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next =null;
        }
    }
    public static Node head;
    public static Node tail;


    // Reverse a linked list starting from 'head'
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    // To get mid node
    public static Node getMid(Node head){
        if(head == null){
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node zig_zag(Node head){
        if(head == null || head.next == null){
           return head;
        }
        // Step 1:- Find the mid node
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        // Step 2:- Reverse the second half
        right = reverse(right);
        // Step 3:-  Alternate merging left and right lists
        Node left = head;
        Node nextL, nextR;
        while(left != null && right != null){
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = left;
            left = nextL;
            right = nextR;
        }
        return head;
    }
    public static void print(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[]args){
        Node head = new Node(13);
        head.next = new Node(24);
        head.next.next = new Node(43);
        head.next.next.next = new Node(54);
        head.next.next.next.next = new Node(35);
        head.next.next.next.next.next = new Node(25);
        print(head);
        System.out.println();
        head = zig_zag(head);
        System.out.println();
        print(head);
    }
}

import java.util.*;
public class MergeSort {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node next;
    // Get the mid node
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
    public static Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }
    public static Node mergeSort(Node head){
        // Base case: if list is empty or contains a single node
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
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
    public static void main(String[] args) {
        Node head = new Node(13);
        head.next = new Node(24);
        head.next.next = new Node(43);
        head.next.next.next = new Node(54);
        head.next.next.next.next = new Node(35);
        head.next.next.next.next.next = new Node(25);
        print(head);
        head = mergeSort(head);
        System.out.println();
        print(head);
        System.out.println();
    }
}

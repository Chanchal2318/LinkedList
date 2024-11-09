import java.util.*;
public class RemoveLoop {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void remove(Node head){
        boolean cycle = false;
        if(head == null){
          return ;
        }
        Node slow = head;
        Node fast = head;
        while((fast != null) && (fast.next != null)){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle){
            slow = head;
            Node prev = null;
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }
     
    public static void print(Node head) {
        if (head == null) {
            return;
        }
        
        Node temp = head;
        Set<Node> visited = new HashSet<>();
        while (temp != null) {
            // Break the loop if we detect a cycle during printing
            if (visited.contains(temp)) {
                System.out.print("(cycle detected) ");
                break;
            }
            System.out.print(temp.data + " -> ");
            visited.add(temp);
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; 
        print(head);
        System.out.println();
        remove(head);
        print(head);
    }
}
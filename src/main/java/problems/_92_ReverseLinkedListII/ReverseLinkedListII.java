package problems._92_ReverseLinkedListII;

import Helper.ListNode;

public class ReverseLinkedListII {
    ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        successor = null;
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode node = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedListII solution = new ReverseLinkedListII();
        
        // Test Case 1: head = [1,2,3,4,5], left = 2, right = 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("Test Case 1:");
        System.out.println("Input: head = [1,2,3,4,5], left = 2, right = 4");
        ListNode.printLinkedList(solution.reverseBetween(head1, 2, 4));
        // Expected Output: [1,4,3,2,5]
        
        // Test Case 2: head = [5], left = 1, right = 1
        ListNode head2 = new ListNode(5);
        System.out.println("\nTest Case 2:");
        System.out.println("Input: head = [5], left = 1, right = 1");
        ListNode.printLinkedList(solution.reverseBetween(head2, 1, 1));
        // Expected Output: [5]
    }
} 
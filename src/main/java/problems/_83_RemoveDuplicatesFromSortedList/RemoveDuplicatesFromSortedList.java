package problems._83_RemoveDuplicatesFromSortedList;

import Helper.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            if(slow.val != fast.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        // Test Case 1: List with duplicates
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        System.out.println("Input: head = [1,1,2]");
        ListNode.printLinkedList(solution.deleteDuplicates(head1));
        System.out.println("Expected: [1,2]");
        System.out.println();

        // Test Case 2: List with multiple duplicates
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println("Input: head = [1,1,2,3,3]");
        ListNode.printLinkedList(solution.deleteDuplicates(head2));
        System.out.println("Expected: [1,2,3]");
        System.out.println();
    }
} 
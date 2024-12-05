package problems._82_RemoveDuplicatesFromSortedListII;

import Helper.ListNode;

public class RemoveDuplicatesFromSortedListII {
public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, cur = head;
        pre.next = cur;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                if (cur == null) {
                    pre.next = null;
                }
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        // Test Case 1: List with duplicates in middle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next = new ListNode(5);
        System.out.println("Input: head = [1,2,3,3,4,4,5]");
        ListNode.printLinkedList(solution.deleteDuplicates(head1));
        System.out.println("Expected: [1,2,5]");
        System.out.println();

        // Test Case 2: List with duplicates at start
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        System.out.println("Input: head = [1,1,1,2,3]");
        ListNode.printLinkedList(solution.deleteDuplicates(head2));
        System.out.println("Expected: [2,3]");
        System.out.println();
    }
} 
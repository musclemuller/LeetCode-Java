package problems._86_PartitionList;

import Helper.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }

            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        
        // Test Case 1: [1,4,3,2,5,2], x = 3
        // Expected: [1,2,2,4,3,5]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        
        // Test Case 2: [2,1], x = 2
        // Expected: [1,2]
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        
        System.out.println("Test Case 1:");
        ListNode result1 = solution.partition(head1, 3);
        ListNode.printLinkedList(result1);  // Should print: 1->2->2->4->3->5
        
        System.out.println("\nTest Case 2:");
        ListNode result2 = solution.partition(head2, 2);
        ListNode.printLinkedList(result2);  // Should print: 1->2
    }
} 
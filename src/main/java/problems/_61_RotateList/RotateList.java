package problems._61_RotateList;

import Helper.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        // Test Case 1: [1,2,3,4,5] with k=2
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Input: [1,2,3,4,5], k=2");
        ListNode result1 = rotateList.rotateRight(head1, 2);
        System.out.println("Output: " + result1);

        // Test Case 2: [0,1,2] with k=4 
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println("\nInput: [0,1,2], k=4");
        ListNode result2 = rotateList.rotateRight(head2, 4);
        System.out.println("Output: " + result2);
    }
}

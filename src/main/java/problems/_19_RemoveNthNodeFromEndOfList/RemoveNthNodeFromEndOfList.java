package problems._19_RemoveNthNodeFromEndOfList;

import Helper.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findNthFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    ListNode findNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList s = new RemoveNthNodeFromEndOfList();
        int[] list = new int[]{1, 2, 3, 4, 5};
        ListNode.printLinkedList(s.removeNthFromEnd(ListNode.createLinkedList(list), 2));
    }
}

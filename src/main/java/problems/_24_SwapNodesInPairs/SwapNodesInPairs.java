package problems._24_SwapNodesInPairs;

import Helper.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        ListNode next = q.next;
        q.next = p;
        p.next = swapPairs(next);
        return q;
    }

    public static void main(String[] args) {
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode.printLinkedList(s.swapPairs(ListNode.createLinkedList(new int[]{1, 2, 3, 4})));
    }
}

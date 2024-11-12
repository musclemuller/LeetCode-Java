package problems._25_ReverseNodesInKGroup;

import Helper.ListNode;

public class ReverseNodesInKGroup {
    ListNode successor = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newhead = reverseN(a, k);
        successor = null;
        a.next = reverseKGroup(b, k);
        return newhead;
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
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        ListNode head1 = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode head2 = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode.printLinkedList(s.reverseKGroup(head1, 2));
        ListNode.printLinkedList(s.reverseKGroup(head2, 3));
    }
}

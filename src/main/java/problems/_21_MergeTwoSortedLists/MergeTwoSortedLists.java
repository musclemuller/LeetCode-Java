package problems._21_MergeTwoSortedLists;

import Helper.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode list1 = ListNode.createLinkedList(new int[]{1, 2, 4});
        ListNode list2 = ListNode.createLinkedList(new int[]{1, 3, 4});
        ListNode list = s.mergeTwoLists(list1, list2);
        ListNode.printLinkedList(list);
    }
}

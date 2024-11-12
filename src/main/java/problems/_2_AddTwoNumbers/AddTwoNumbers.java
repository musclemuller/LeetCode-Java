package problems._2_AddTwoNumbers;

import Helper.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            carry = val / 10;
            val %= 10;
            p.next = new ListNode(val);
            p = p.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        // Test case 1
        ListNode l1 = ListNode.createLinkedList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createLinkedList(new int[]{5, 6, 4});
        ListNode expected = ListNode.createLinkedList(new int[]{7, 0, 8});
        if (ListNode.compareLinkedLists(s.addTwoNumbers(l1, l2), expected)) {
            System.out.println("Test case 1 passed.");
        } else {
            System.out.println("Test case 1 failed.");
        }

        // Test case 2
        l1 = ListNode.createLinkedList(new int[]{0});
        l2 = ListNode.createLinkedList(new int[]{0});
        expected = ListNode.createLinkedList(new int[]{0});
        if (ListNode.compareLinkedLists(s.addTwoNumbers(l1, l2), expected)) {
            System.out.println("Test case 2 passed.");
        } else {
            System.out.println("Test case 2 failed.");
        }

        // Test case 3
        l1 = ListNode.createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = ListNode.createLinkedList(new int[]{9, 9, 9, 9});
        expected = ListNode.createLinkedList(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        if (ListNode.compareLinkedLists(s.addTwoNumbers(l1, l2), expected)) {
            System.out.println("Test case 3 passed.");
        } else {
            System.out.println("Test case 3 failed.");
        }
    }
}

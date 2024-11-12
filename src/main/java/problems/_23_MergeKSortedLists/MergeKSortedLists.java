package problems._23_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

import Helper.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode p1, ListNode p2) {
                return p1.val - p2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        MergeKSortedLists s = new MergeKSortedLists();
        ListNode l1 = ListNode.createLinkedList(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createLinkedList(new int[]{1, 3, 4});
        ListNode l3 = ListNode.createLinkedList(new int[]{2, 6});
        ListNode l = s.mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode.printLinkedList(l);
    }
}

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/*
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode               (ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode tail = head;
        // 找该组k个节点的尾节点
        for (int i = 1; i < k && tail != null; ++i) {
            tail = tail.next;
        }
        // 如果为空，说明长度不够，原顺序返回
        if (tail == null) {
            return head;
        }
        // 记录一下下一组的头结点
        ListNode next = tail.next;
        // 反转该组链表，注意此处反转后，tail成了head，head成了tail
        reverse(head, tail);
        // 连接上下一组的头结点
        head.next = reverseKGroup(next, k);
        return tail;
    }

    ListNode reverse(ListNode head, ListNode tail) {
        ListNode newHead=tail;
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return newHead;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

package leetcode;

public class S_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode quick = head, slow = head;
            if (quick == null) {
                return false;
            }
            slow = quick.next;
            while (quick != null && slow != null) {
                if (quick == slow) {
                    return true;
                }
                quick = quick.next;
                slow = slow.next;
                if (slow != null) {
                    slow = slow.next;
                }
            }
            return false;
        }
    }
}

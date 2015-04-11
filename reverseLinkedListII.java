/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        int temp = m;
        while(temp>1) {
            pre = pre.next;
            temp--;
        }
        ListNode M = pre.next;
        ListNode mid = M;
        ListNode preMid = M;
        int temp2 = n - m;
        while(temp2 > 0) {
            ListNode temp3 = new ListNode(mid.next.val);
            temp3.next = preMid;
            mid = mid.next;
            preMid = temp3;
            temp2--;
        }
        M.next = mid.next;
        pre.next = preMid;
        return res.next;
    }
}
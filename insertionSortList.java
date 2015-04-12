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
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode res = new ListNode(head.val);
        ListNode cur = head.next;
        while(cur!=null) {
            ListNode cur1 = res;
            ListNode temp2 = cur.next;
            if(cur.val < cur1.val) {
            	ListNode temp = cur.next;
                cur.next = cur1;
                res = cur;
                cur = temp;
            } else {
                while(cur1!=null) {
                    if(cur1.next!=null) {
                        if(cur.val >= cur1.val && cur.val <= cur1.next.val) {
                            cur.next = cur1.next;
                            cur1.next = cur;
                            break;
                        }
                        cur1 = cur1.next;
                    } else {
                        cur1.next = new ListNode(cur.val);
                        break;
                    }
                }
                cur = temp2;
            }
            
        }
        return res;
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode res = new ListNode(0);
        ListNode pre = res;
        int left = 0;
        while(l1!=null||l2!=null) {
            if(l1!=null&&l2!=null) {
                ListNode temp = new ListNode((l1.val + l2.val + left)%10);
                left = (l1.val + l2.val + left) >= 10 ? 1:0;
                pre.next = temp;
                l1 = l1.next;
                l2 = l2.next;
                pre =  temp;
            }
            if(l1!=null&&l2==null) {
                ListNode temp = new ListNode((l1.val + left)%10);
                left = (l1.val + left) >= 10 ? 1:0;
                pre.next = temp;
                l1 = l1.next;
                pre =  temp;
            }
            if(l1==null&&l2!=null) {
                ListNode temp = new ListNode((l2.val + left)%10);
                left = (l2.val + left) >= 10 ? 1:0;
                pre.next = temp;
                l2 = l2.next;
                pre =  temp;
            }
        }
        
        if(left == 1)
            pre.next = new ListNode(1);
        
        return res.next;
    }
}
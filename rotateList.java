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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0||head==null)
            return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode res = new ListNode(1);
        res.next = head;
        int len = 0;
        while(res.next!=null) {
            res = res.next;
            stack.push(res);
            len++;
        }
        k = k%len;
        if(k==0)
        	return head;
        int left = len - k - 1;
        ListNode last = stack.pop();
        ListNode pre = last;
        ListNode temp = last;
        while(k - 1 > 0) {
            temp = stack.pop();
            temp.next = pre;
            pre = temp;
            k--;
        }
        
        ListNode temp2 = stack.pop();
        temp2.next = null;
        
        while(left > 0) {
            temp2 = stack.pop();
            left--;
        }
        last.next = temp2;
        
        return temp;
        
    }
}
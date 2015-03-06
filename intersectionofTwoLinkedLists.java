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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = getLen(headA);
        int lb = getLen(headB);
        int start = 0;
        if(la>=lb) {
            start = la - lb;
            while(start>0) {
                headA = headA.next;
                start--;
            }
        }
        else {
            start = lb - la;
            while(start>0) {
                headB = headB.next;
                start--;
            }
        }
        
        while(headA!=null) {
            if(headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int getLen(ListNode root) {
        int i = 0;
        while(root!=null) {
            root = root.next;
            i++;
        }
        return i;
    }
}
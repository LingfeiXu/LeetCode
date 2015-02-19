/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null)
            return;
        ListNode slow = head, fast = head;
        while (fast.next!=null) {
            fast = fast.next;
            if(fast.next!=null) {
                fast = fast.next;
            } else {
                break;
            }
            slow =slow.next;
        }
        
        ListNode pre = slow.next;
        slow.next =null;
        ListNode current = pre.next, temp = head;
        pre.next = null;
        while (current!=null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        
        ListNode list1 = head;
        ListNode list2 = pre;
        while (list2!=null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;
            
        }
    }
}
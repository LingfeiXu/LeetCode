/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode list1 = head, list2 = head.next;
        while(list1!=null) {
            list1.next = new RandomListNode(list1.label);
            list1.next.next = list2;
            list1 = list2;
            if(list2!=null)
                list2 = list2.next;
        }
        list1 = head; list2 = head.next;
        while(list1!=null) {
            if(list1.random!=null)
                list2.random = list1.random.next;
            else
                list2.random = null;
            list1 = list1.next.next;
            if(list2.next!=null)
                list2 = list2.next.next;
        }
        RandomListNode res = head.next;
        list1 = head; list2 = head.next;
        while(list2.next!=null) {
            list1.next = list2.next;
            list1 = list2;
            if(list2.next!=null)
                list2 = list2.next;
        }
        list1.next = null;
        list2.next = null;
        return res;
    }
}
package Accepted;

import Utils.ListNode;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        
        if (n <= 0)
            return head;
        
        ListNode first = head;
        ListNode second = head;
        ListNode secondPrev = null;
        
        int i = 1;
        while (first.next != null) {
            first = first.next;
            
            if (i >= n) {
                secondPrev = second;
                second = second.next;
            }
                
            i ++;
        }
        
        if (second == head)
            return head.next;
            
        if (second == first) {
            secondPrev.next = null;
        }
        else {
            secondPrev.next = second.next;
        }
        
        return head;
    }
}

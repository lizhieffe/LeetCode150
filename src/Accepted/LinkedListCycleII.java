package Accepted;

import Utils.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;
            
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        
        while (p2 != null) {
            p1 = p1.next;
            
            p2 = p2.next;
            if (p2 == null)
                return null;
            else
                p2 = p2.next;
                
            if (p1 == p2)
                break;
        }
        
        if (p2 == null)
            return null;
            
        p1 = head;
        
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}

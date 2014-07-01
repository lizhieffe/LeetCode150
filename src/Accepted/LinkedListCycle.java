package Accepted;

import Utils.ListNode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        
        while (p2 != null) {
            p1 = p1.next;
            
            p2 = p2.next;
            if (p2 == null)
                return false;
            else 
                p2 = p2.next;
                
            if (p1 == p2)
                return true;
        }
        
        return false;
    }
}

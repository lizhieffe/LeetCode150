package Accepted;

import Utils.ListNode;

public class RemoveDuplicatFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
        ListNode last;
        ListNode current;
        
        if (head == null || head.next == null)
            return head;
        
        
        last = findFirst(head);
        if (last == null)
            return null;
        
        head = last;
        
        current = findFirst(last.next);
        
        while (current != null) {
            last.next = current;
            last = current;
            current = findFirst(last.next);
        }
        last.next = null;
        
        return head;
    }
    
    private ListNode findFirst(ListNode cNode) {
        if (cNode == null)
            return null;
        
        if (cNode.next == null)
            return cNode;
            
        if (cNode.next.val != cNode.val)
            return cNode;
        
        int tmp = cNode.val;
        
        while (cNode != null) {
            if (cNode.val != tmp)
                return findFirst(cNode);
                
            cNode = cNode.next;
        }
        
        return null;
    }
}

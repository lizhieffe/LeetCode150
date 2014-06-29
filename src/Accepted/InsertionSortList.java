package Accepted;

import Utils.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        
        if (head == null)
            return null;
            
        ListNode last = head;
        
        while (last.next != null) {
            if (last.next.val >= last.val)
                last = last.next;
            else {
                ListNode tmp = last.next;
                last.next = last.next.next;
                
                ListNode cNode = head;
                if (tmp.val < head.val) {
                    tmp.next = head;
                    head = tmp;
                } else {
                    while (tmp.val > cNode.next.val) {
                        cNode = cNode.next;
                    }
                    tmp.next = cNode.next;
                    cNode.next = tmp;
                }
            }
        }
        
        return head;
    }
}

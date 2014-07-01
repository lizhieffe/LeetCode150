package Accepted;

import Utils.ListNode;

public class RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode cNode = head;
        while (cNode.next != null) {
            if (cNode.val == cNode.next.val)
                cNode.next = cNode.next.next;
            else
                cNode = cNode.next;
        }
        
        return head;
    }
}

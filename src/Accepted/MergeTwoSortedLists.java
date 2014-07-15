package Accepted;

import Utils.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
        	return null;
        if (l1 == null)
        	return l2;
        if (l2 == null)
        	return l1;
        
        ListNode head;
        ListNode c1, c2, last1, last2;

        if (l1.val > l2.val) {
        	head = l2;
        	c2 = l2.next;
        	l2.next = l1;
        	last1 = l2;
        	c1 = l1;
        } else {
        	c2 = l2;
        	c1 = l1.next;
        	head = l1;
        	last1 = l1;
        }
        	
//        last2 = null;
        
        while (c1 != null && c2 != null) {

        	
        	if (c1.val < c2.val) {
        		last1 = c1;
        		c1 = c1.next;
        	}
        	else {
        		last1.next = c2;
        		c2 = c2.next;
        		last1.next.next = c1;
        		last1 = last1.next;
        	}

        }
        
        if (c1 == null)
        	last1.next = c2;
        
        return head;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);
		
		MergeTwoSortedLists service = new MergeTwoSortedLists();
		ListNode result = service.mergeTwoLists(l1, l2);
		
		System.out.println();

	}
}

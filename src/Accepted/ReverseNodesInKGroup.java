package Accepted;

import Utils.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
        	return head;
        
        ListNode start, lastEnd = null;
        
        int i = 0;
        
        Group group = reverse(head, k);
        
        while (group != null) {
        	if (i == 0) {
        		head = group.start;
        	}
        	else {
        		lastEnd.next = group.start;
        	}
    		lastEnd = group.end;
    		start = lastEnd.next;
    		
    		i ++;
    		group = reverse(start, k);
        }
        
        return head;
    }
	
	private Group reverse(ListNode start, int k) {
		if (start == null)
			return null;
		
		ListNode end;
		end = start;
		
		for (int i = 0; i < k - 1; i ++) {
			end = end.next;
			if (end == null)
				return null;
		}
		
		ListNode oldStart = start;
		ListNode oldEnd = end;
		
		while (start != oldEnd) {
			ListNode tmp = oldEnd.next;
			oldEnd.next = start;
			start = start.next;
			oldEnd.next.next = tmp;
		}
		
		return new Group(start, oldStart);
	}
	
	class Group {
		ListNode start;
		ListNode end;
		Group (ListNode start, ListNode end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode tmp = head;
		tmp.next = new ListNode(2);
		tmp = tmp.next;
		tmp.next = new ListNode(3);
		tmp = tmp.next;
		tmp.next = new ListNode(4);
		tmp = tmp.next;
//		tmp.next = new ListNode(5);
//		tmp = tmp.next;
//		tmp.next = new ListNode(6);
//		tmp = tmp.next;
//		tmp.next = new ListNode(7);
//		tmp = tmp.next;
		
		int k = 4;
		
		ListNode newHead = new ReverseNodesInKGroup().reverseKGroup(head, k);
		System.out.println(newHead);

	}
}

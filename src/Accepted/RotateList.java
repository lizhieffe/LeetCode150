package Accepted;

import Utils.ListNode;

public class RotateList {

	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        
        ListNode oldEnd = fast;
        int i = 0;
        while (oldEnd != slow.next) {
        	ListNode tmp = fast.next;
        	ListNode tmp2 = slow.next.next;
        	fast.next = slow.next;
            if (i == 0)
            	fast.next.next = null;
            else
            	fast.next.next = tmp;
//            fast = fast.next;
            slow.next = tmp2;
//            fast.next = null;
            i ++;
        }
        
        ListNode cNode = head;
        while (cNode.next != null && slow.next != null && cNode != slow) {
            ListNode tmpNext = cNode.next;
            ListNode tmpSlowNextNext = slow.next.next;
            cNode.next = slow.next;
            cNode.next.next = tmpNext;
            slow.next = tmpSlowNextNext;
            cNode = tmpNext;
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
		tmp.next = new ListNode(5);
		tmp = tmp.next;
		tmp.next = new ListNode(6);
		tmp = tmp.next;
		tmp.next = new ListNode(7);
		tmp = tmp.next;
		
		RotateList service = new RotateList();
		service.reorderList(head);
		
		System.out.println();
	}
}

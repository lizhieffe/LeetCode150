package Accepted;

import Utils.ListNode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;
        
        if (head.next == null || n == 0)
            return head;
            
        int length = 1;
        
        ListNode cNode = head;
        while (cNode.next != null) {
            cNode = cNode.next;
            length ++;
        }
        cNode.next = head;
        
        cNode = head;
        
        int step = length - n % length;
        
        for (int i = 0; i < step - 1; i ++) {
            cNode = cNode.next;
        }
        
        ListNode result = cNode.next;
        cNode.next = null;
        return result;
    }
	
}

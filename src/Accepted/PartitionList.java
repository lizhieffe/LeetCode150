package Accepted;

import Utils.ListNode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
        
        if (head == null)
            return null;
            
        ListNode newHead = null, lastNode = null;
        ListNode cNode = head;
        ListNode newNode = null;
        
        while (cNode != null) {
            if (cNode.val < x) {
                if (newHead == null) {
                    newHead = cNode;
                    newNode = newHead;
                } else {
                    newNode.next = cNode;
                    newNode = newNode.next;
                }
                
                if (cNode == head) {
                    head = cNode.next;
                    cNode.next = null;
                    cNode = head;
                } else {
                    lastNode.next = cNode.next;
                    cNode.next = null;
                    cNode = lastNode.next;
                }
            }
            else {
                lastNode = cNode;
                cNode = cNode.next; 
            }
        }
        
        if (newHead == null)
            return head;
        
        newNode.next = head;
        
        return newHead;
    }
}

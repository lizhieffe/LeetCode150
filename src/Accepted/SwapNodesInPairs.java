package Accepted;

import Utils.ListNode;

public class SwapNodesInPairs {
	private ListNode head;
    private ListNode tail;
    private ListNode newHead;
    int count = 0;

    public ListNode swapPairs(ListNode inputHead) {
        if (inputHead == null)
            return null;
        
        if (inputHead.next == null)
            return inputHead;
        
        if (inputHead.next.next == null) {
            ListNode tmpHead = inputHead.next;
            inputHead.next.next = inputHead;
            inputHead.next = null;
            
            return tmpHead;
        }
        
        this.head = inputHead;
        this.newHead = head.next;
        this.tail = head;
        
        while (tail.next != null)
            tail = tail.next;
            
        while (!this.head.equals(newHead))
            rotate();
            
        return newHead;
    }
    
    private void rotate() {
        if (head.next.equals(newHead) && count != 0) {
            tail.next = head;
            tail = tail.next;
            tail.next = null;
            head = newHead;
        } else {
            if (head.next.equals(newHead))
                count ++;
            
            ListNode tmpHead = head.next.next;
            
            tail.next = head.next;
            tail = tail.next;
            tail.next = head;
            tail = tail.next;
            tail.next = null;
            
            head = tmpHead;
        }
    }
    
    public static void main(String[] args) {
    	int[] list = {1, 2, 3};
    	ListNode head = ListNode.asList(list);
    	
    	SwapNodesInPairs service = new SwapNodesInPairs();
    	ListNode newHead = service.swapPairs(head);
    	ListNode cNode = newHead;
    	
    	do {
    		System.out.println(" " + cNode.val);
    		cNode = cNode.next;
    	} while (cNode != null);
    }
}

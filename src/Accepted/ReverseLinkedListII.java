package Accepted;

import Utils.ListNode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        
        if (head.next == null)
            return head;
        
        if (n - m <= 0)
            return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        int i = 0;

        ListNode start = fakeHead;
        ListNode end = fakeHead;
        ListNode lastStart = fakeHead;
        
        while (i < n) {
            lastStart = start;
            
            end = end.next;
            if (i >= n - m)
                start = start.next;
            i ++;
        }
        
        ListNode endNext = end.next;
        
        ListNode cNode = start.next;
        ListNode firstToConnect = start;

        boolean shouldEnd = false;
        while (shouldEnd == false) {
            if (cNode == end)
                shouldEnd = true;
            
            lastStart.next = cNode;
            start.next = cNode.next;
            lastStart.next.next = firstToConnect;
            firstToConnect = lastStart.next;
            cNode = start.next;
        }
        
        start.next = endNext;
        
        return fakeHead.next;
    }
}

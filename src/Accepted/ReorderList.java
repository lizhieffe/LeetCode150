package Accepted;

import Utils.ListNode;

public class ReorderList {

	public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode cNode = head;
        
        while (cNode != null && cNode.next != null) {
            ListNode nextNode = cNode.next;
            ListNode[] lastTwoNodes = getLastTwoNode(nextNode);
            ListNode secondLastNode = lastTwoNodes[0];
            ListNode lastNode = lastTwoNodes[1];
            
            if (nextNode == lastNode)
                break;
            
            cNode.next = lastNode;
            secondLastNode.next = null;
            lastNode.next = nextNode;
            cNode = nextNode;
        }
    }
    
    private ListNode[] getLastTwoNode(ListNode startNode) {
        ListNode cNode = startNode;
        ListNode lastNode = startNode;
        
    	while (cNode.next !=null) {
        	if (cNode.next.next != null)
        		cNode = cNode.next;
        	else
        		break;
        }
        
    	if (cNode.next != null)
    		lastNode = cNode.next;

    	ListNode[] result = {cNode, lastNode};
        return result;
    }
    
    public static void main(String[] args) {
    	ListNode start = new ListNode(1);
    	ListNode tmp = start;
    	
    	tmp.next = new ListNode(2);
    	tmp = tmp.next;
    	tmp.next = new ListNode(3);
    	tmp = tmp.next;
    	tmp.next = new ListNode(4);
    	tmp = tmp.next;
    	tmp.next = new ListNode(5);
    	tmp = tmp.next;
    	
    	ReorderList service = new ReorderList();
    	service.reorderList(start);
    	
    	System.out.println();
    }
}

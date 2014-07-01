package Accepted;

import Utils.ListNode;

/*
 * see explanation: http://fisherlei.blogspot.com/2013/12/leetcode-sort-list-solution.html
 */

public class SortList {
	public ListNode sortList(ListNode head) {
        
		if (head == null)
			return null;
		
		int length = 1;
		ListNode node = head;
		
		while (node.next != null) {
			node = node.next;
			length ++;
		}
			
		ListNode result = sort(head, length);
		return result;
			
    }
	
	private ListNode sort(ListNode node, int size) {
		if (size == 1) {
			node.next = null;
			return node;
		}
		
		int mid = size / 2;
		
		ListNode node1 = node;
		
		ListNode node2 = node;
		for (int i = 0; i < mid; i ++) 
			node2 = node2.next;

		node1 = sort(node1, mid);
		node2 = sort(node2, size - mid);
		
		ListNode head;
		if (node1.val > node2.val) {
			ListNode tmp = node1.next;
			head = node2;
			node2 = node2.next;
			head.next = node1;
//			node1.next = node2;
		} else {
			head = node1;
			node1 = node1.next;
		}
			
		ListNode last1 = head;
		
		while (node2 != null) {
			if (node1 == null) {
				last1.next = node2;
				break;
			}
			
			if (node1.val < node2.val && (node1.next == null || node1.next.val > node2.val) || node1.val == node2.val) {
				ListNode tmp = node1.next;
				ListNode tmp2 = node2.next;
				node1.next = node2;
				node2.next = tmp;
				node2 = tmp2;
				node1 = node1.next;
			} else if (node1.val < node2.val)
				node1 = node1.next;
			else {
				ListNode tmp = last1.next;
				last1.next = node2;
				node2 = node2.next;
				last1.next.next = tmp;
				node1 = last1.next;

				
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		ListNode cNode = head;
		cNode.next = new ListNode(4);
		cNode = cNode.next;
		cNode.next = new ListNode(3);
		cNode = cNode.next;
		cNode.next = new ListNode(2);
		
		System.out.println(new SortList().sortList(head));
	}
}

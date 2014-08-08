package Accepted;

import java.util.List;

import Utils.ListNode;

/*
 * good one
 * can also use the heap
 * http://blog.csdn.net/linhuanmars/article/details/19899259
 */

public class MergeKSortedList {
	List<ListNode> lists;
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
            
        this.lists = lists;
        return merge(0, lists.size() - 1);
    }
    
    private ListNode merge(int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return lists.get(start);
        if (start == end - 1)
            return mergeTwo(lists.get(start), lists.get(end));
        
        int mid = (end - start) / 2 + start;
        return mergeTwo(merge(start, mid), merge(mid + 1, end));
    }
    
    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
            
        ListNode head;
        ListNode cNode1, cNode2;
        if (list1.val < list2.val) {
            head = list1;
            cNode1 = head.next;
            cNode2 = list2;
        } else {
            head = list2;
            cNode1 = list1;
            cNode2 = head.next;
        }
        
        ListNode cNode = head;
        
        while (cNode1 != null && cNode2 != null) {
            if (cNode1.val < cNode2.val) {
                cNode.next = cNode1;
                cNode = cNode.next;
                cNode1 = cNode1.next;
            } else {
                cNode.next = cNode2;
                cNode = cNode.next;
                cNode2 = cNode2.next;
            }
        }
        
        if (cNode1 == null)
            cNode.next = cNode2;
        else
            cNode.next = cNode1;
            
        return head;
    }
	
}

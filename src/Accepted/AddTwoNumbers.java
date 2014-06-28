package Accepted;

import Utils.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;
        
        if (l1 == null)
            return l2;
            
        if (l2 == null)
            return l1;
            
        boolean digitExist1 = l1.next != null;
        boolean digitExist2 = l2.next != null;
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode tmpResult = result;
        int modifier = (l1.val + l2.val) >= 10 ? 1 : 0;

        while (digitExist1 == true || digitExist2 == true) {
            int tmp = modifier;
            if (digitExist1 == true) {
                tmp = tmp + l1.next.val;
                l1 = l1.next;
                digitExist1 = l1.next != null;
            }
            if (digitExist2 == true) {
                tmp = tmp + l2.next.val;
                l2 = l2.next;
                digitExist2 = l2.next != null;
            }
            
            tmpResult.next = new ListNode(tmp % 10);
            tmpResult = tmpResult.next;
            modifier = tmp >= 10 ? 1 : 0;
        }
        
        if (modifier > 0) 
            tmpResult.next = new ListNode(modifier);
            
        return result;
    }
}

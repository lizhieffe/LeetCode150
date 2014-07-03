package Accepted;

import java.util.HashMap;

import Utils.RandomListNode;

public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		 
        if (head == null)       
            return null;
            
        HashMap<RandomListNode, RandomListNode> relations = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode cNode = head;
        while (cNode != null) {
            RandomListNode cNode1, nNode1, rNode1;
            
            cNode1 = getCorrespondingNode(relations, cNode);
            nNode1 = getCorrespondingNode(relations, cNode.next);
            rNode1 = getCorrespondingNode(relations, cNode.random);

            cNode1.next = nNode1;
            cNode1.random = rNode1;
            
            cNode = cNode.next;
        }
        
        return getCorrespondingNode(relations, head);
    }
    
    private RandomListNode getCorrespondingNode(HashMap<RandomListNode, RandomListNode> relations, RandomListNode key) {
        if (key == null)
            return null;
        
        if (relations.containsKey(key) == false) {
            RandomListNode cNode1 = new RandomListNode(key.label);
            relations.put(key, cNode1);
        }
        return relations.get(key);
    }
}

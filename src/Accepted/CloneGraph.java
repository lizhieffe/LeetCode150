package Accepted;

import java.util.HashMap;
import java.util.LinkedList;

import Utils.UndirectedGraphNode;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
		if (node == null)
			return null;
		
		LinkedList<UndirectedGraphNode> list = new LinkedList<UndirectedGraphNode>();
		list.add(node);
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> relation = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		relation.put(list.getFirst(), new UndirectedGraphNode(list.getFirst().label));
		
		HashMap<UndirectedGraphNode, Integer> color = new HashMap<UndirectedGraphNode, Integer>();
		
		while (list.size() > 0) {
			
			UndirectedGraphNode old = list.getFirst();
			UndirectedGraphNode clone = relation.get(old);

			color.put(old, 2);
			
			for (UndirectedGraphNode neighbor : old.neighbors) {
				if (color.get(neighbor) == null || color.get(neighbor) == 0) {
					color.put(neighbor, 1);
					UndirectedGraphNode tmpClone = new UndirectedGraphNode(neighbor.label);
					relation.put(neighbor, tmpClone);
					clone.neighbors.add(tmpClone);
					list.add(neighbor);
				} else {
					UndirectedGraphNode tmpClone = relation.get(neighbor);
					clone.neighbors.add(tmpClone);
				}
			}
			
			list.removeFirst();
		}
		
		return relation.get(node);
    }
	
	public static void main(String[] args) {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		
		n0.neighbors.add(n1);
		n1.neighbors.add(n2);
		n2.neighbors.add(n2);

		
		System.out.println(new CloneGraph().cloneGraph(n0));
	}
}

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Hashtable<UndirectedGraphNode,UndirectedGraphNode> ht = new Hashtable<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        ht.put(node,res);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode current = queue.remove();
            UndirectedGraphNode currentClone = ht.get(current);
            ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>(current.neighbors);
            
            for(int i = 0; i <list.size(); i++) {
                UndirectedGraphNode temp = list.get(i);
                if(ht.containsKey(temp)) {
                    UndirectedGraphNode temp2 = ht.get(temp);
                    currentClone.neighbors.add(temp2);
                    
                } else {
                    UndirectedGraphNode temp3 = new UndirectedGraphNode(temp.label);
                    currentClone.neighbors.add(temp3);
                    ht.put(temp,temp3);
                    queue.add(temp);
                }
            }
            
        }
        return res;
    }
}
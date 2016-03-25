import java.util.*;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        //bfs
//        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
//        queue.offer(node);
//        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
//        map.put(node.label, node1);
//        while(!queue.isEmpty()) {
//            UndirectedGraphNode n = queue.poll();
//            UndirectedGraphNode n2 = map.get(n.label);
//            for(UndirectedGraphNode neighbor : n.neighbors) {
//                UndirectedGraphNode neighbor2 = map.get(neighbor.label);
//                if (neighbor2 == null) {
//                    neighbor2 = new UndirectedGraphNode(neighbor.label);
//                    map.put(neighbor.label, neighbor2);
//                    queue.offer(neighbor);
//                }
//                n2.neighbors.add(neighbor2);
//            }
//        }
        //dfs
        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
        map.put(node.label, node1);
        dfs(node, node1, map);
        return node1;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode copy, Map<Integer, UndirectedGraphNode> map) {
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode neighbor2 = map.get(neighbor.label);
            if (neighbor2 == null) {
                neighbor2 = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor.label, neighbor2);
                dfs(neighbor, neighbor2, map);
            }
            copy.neighbors.add(neighbor2);
        }
    }
}

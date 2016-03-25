import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/25/16.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

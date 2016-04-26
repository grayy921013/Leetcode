/**
 * Created by Zhehui Zhou on 4/26/16.
 */
public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int nodeCount = 0;
        int nullCount = 0;
        for(int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (node.equals("#")) nullCount++;
            else nodeCount++;
            if (nullCount > nodeCount) return i == nodes.length - 1;
        }
        return nullCount == nodeCount + 1;
    }
}

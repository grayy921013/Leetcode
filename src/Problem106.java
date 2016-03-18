/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postIndex) {
        //Similar to problem105
        if (postIndex < 0 || inEnd < inStart) return null;
        TreeNode treeNode = new TreeNode(postorder[postIndex]);
        int i;
        for(i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postIndex]) break;
        }
        treeNode.left = buildTree(inorder, postorder, inStart, i - 1, postIndex - inEnd + i);
        treeNode.right = buildTree(inorder, postorder, i + 1, inEnd, postIndex - 1);
        return treeNode;
    }

}

/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preoder, int[] inorder, int preIndex, int inStart, int inEnd) {
        //The value at preorder[preIndex] must be the root
        //Find the index of root node in inorder, such that inorder[i] == preorder[preIndex]
        //Then values to the left of i is on the left subtree, to the right of i is on the right subtree
        //Do it recursively
        if (preIndex > preoder.length - 1 || inEnd < inStart) return null;
        TreeNode treeNode = new TreeNode(preoder[preIndex]);
        int i;
        for(i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preoder[preIndex]) break;
        }
        treeNode.left = buildTree(preoder, inorder, preIndex + 1, inStart, i - 1);
        treeNode.right = buildTree(preoder, inorder, preIndex + i - inStart + 1, i + 1, inEnd);
        return treeNode;
    }

    public static void main(String[] args) {
        new Problem105().buildTree(new int[]{1,2,3},new int[]{1,2,3});
    }
}

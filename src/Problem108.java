/**
 * Created by Zhehui Zhou on 3/18/16.
 */
public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToNode(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToNode(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToNode(nums, start, mid - 1);
        node.right = sortedArrayToNode(nums, mid + 1, end);
        return node;
    }
}

/**
 * Created by Zhehui Zhou on 4/17/16.
 */
public class Problem307 {
    private static class SegmentTreeNode {
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) node.sum = nums[start];
        else {
            int mid = (start + end) >>> 1;
            node.left = buildTree(start, mid, nums);
            node.right = buildTree(mid + 1, end, nums);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    SegmentTreeNode root;

    public Problem307(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }

    private void update(SegmentTreeNode node, int pos, int val) {
        if (node.start == node.end) node.sum = val;
        else {
            int mid = (node.start + node.end) >>> 1;
            if (pos <= mid) update(node.left, pos, val);
            else update(node.right, pos, val);
            node.sum = node.left.sum + node.right.sum;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (node == null || start > node.end || end < node.start) return 0;
        if (start <= node.start && end >= node.end) return node.sum;
        int left = sumRange(node.left, start, end);
        int right = sumRange(node.right, start, end);
        return left + right;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public static void main(String[] args) {
        Problem307 problem307 = new Problem307(new int[]{0, 9, 5, 7, 3});
        problem307.sumRange(4, 4);
        problem307.sumRange(2, 4);
        problem307.sumRange(3, 3);
        problem307.update(4, 5);
        problem307.update(1, 7);
        problem307.update(0, 8);
        problem307.sumRange(1, 2);
        problem307.update(1, 9);
        problem307.sumRange(4, 4);
        problem307.update(3, 4);
    }
}

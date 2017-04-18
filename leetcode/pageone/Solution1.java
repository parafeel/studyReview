package parafeel.pageone;

/**
 * 
 * @author wh-pc
 * @date 2017年4月17日
 * @keywords Given a binary tree, find its minimum depth. The minimum depth is
 *           the number of nodes along the shortest path from the root node down
 *           to the nearest leaf node. 给一个二叉树，找到它的最小深度。它的最小深度是从根节点到
 *           最近的叶子节点的路径的节点数目。
 * 
 */

public class Solution1 {
	public int run(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return run(root.right) + 1;
		if (root.right == null)
			return run(root.left) + 1;

		return Math.min(run(root.left), run(root.right)) + 1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

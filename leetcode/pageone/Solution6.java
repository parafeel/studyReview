package parafeel.pageone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author wh-pc
 * @date 2017年4月19日
 * @keywords Given a binary tree, return the postorder traversal of its nodes' values.
 * For example Given binary tree{1,#,2,3},
 * 二叉树的后序遍历
 */

public class Solution6 {
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		if(root != null) {
			if(root.left != null) postorderTraversal(root.left);
	        if(root.right != null) postorderTraversal(root.right);
	        list.add(root.val);
		}
		
		
		return list;
    }
}

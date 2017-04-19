package parafeel.pageone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

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

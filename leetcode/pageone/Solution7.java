package parafeel.pageone;
/**
 * 
 * @author wh-pc
 * @date 2017年4月19日
 * @keywords Given a binary tree, return the preorder 
 * traversal of its nodes' values.
 * For example:Given binary tree{1,#,2,3},
 * 这个是二叉树的前序遍历
 */
import java.util.ArrayList;

public class Solution7 {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}

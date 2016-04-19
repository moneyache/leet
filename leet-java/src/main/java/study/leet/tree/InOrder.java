package study.leet.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
			return list;
		}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.left == null && cur.right == null) {
				list.add(cur.val);
				continue;
			}
			if (cur.right != null) {
				stack.add(cur.right);
				cur.right = null;
			}
			stack.add(cur);
			if (cur.left != null) {
				stack.add(cur.left);
				cur.left = null;
			}
		}
        return list;
    }
}

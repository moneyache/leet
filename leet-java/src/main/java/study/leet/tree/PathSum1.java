package study.leet.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class PathSum1 {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Map<TreeNode, Integer> record = new HashMap<TreeNode, Integer>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		record.put(root, 0);
		while (!stack.isEmpty()) {
			TreeNode curNode = stack.pop();
			int curRecord = record.get(curNode);
			if (curNode.left == null && curNode.right == null) {
				if (curRecord + curNode.val == sum) {
					return true;
				}
				continue;
			}
			if (curNode.left != null) {
				stack.push(curNode.left);
				record.put(curNode.left, curRecord + curNode.val);
			}
			if (curNode.right != null) {
				stack.push(curNode.right);
				record.put(curNode.right, curRecord + curNode.val);
			}
		}
		return false;
	}
}

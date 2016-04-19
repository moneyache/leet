package study.leet.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> traversalList = new ArrayList<Integer>();
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (cur.right == null && cur.left == null) {
				traversalList.add(stack.pop().val);
				continue;
			}
			if (cur.right != null) {
				stack.push(cur.right);
				cur.right = null;
			}
			if (cur.left != null) {
				stack.push(cur.left);
				cur.left = null;
			}
		}
        return traversalList;
    }
	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node.left = node1;
		node.right = node2;
		node1.left = new TreeNode(3);
		node1.right = new TreeNode(4);
		node2.right = new TreeNode(5);
		PostTraversal traversal = new PostTraversal();
		List<Integer> list = traversal.postorderTraversal(node);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}

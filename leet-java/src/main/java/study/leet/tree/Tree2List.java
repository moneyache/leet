package study.leet.tree;

import java.util.Stack;

public class Tree2List {
    public void flatten(TreeNode root) {
        if (root == null) {
			return;
		}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        if (root.right != null) {
			stack.push(root.right);
		}
		if (root.left != null) {
			stack.push(root.left);
		}
        while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
			iter.right = cur;
			iter.left = null;
			iter = iter.right;
		}
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
		Tree2List tree2List = new Tree2List();
		tree2List.flatten(node);
		while (node != null) {
			System.out.println(node.val);
			node = node.right;
		}
    }
}

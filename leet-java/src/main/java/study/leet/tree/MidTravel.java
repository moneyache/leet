package study.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MidTravel {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}
	public List<TreeNode> levelTraver(TreeNode root) {

		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<TreeNode> path = new ArrayList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			path.add(cur);
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return path;
	}
	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node.left = node1;
		node.right = node2;
		node1.right = node3;
		node1.left = node4;
		node3.left = node5;
		node2.right = node6;
		MidTravel travel = new MidTravel();
		List<TreeNode> list = travel.levelTraver(node);
		for (TreeNode treeNode : list) {
			System.out.println(treeNode.val);
		}
	}
}

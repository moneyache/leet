package study.leet.tree;


public class RecoverTreePost {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0) {
			return null;
		}
		return recover(inorder, postorder, 0, inorder.length, 0, inorder.length);
	}
	public TreeNode recover(int[] inorder, int[] postorder, int in1, int in2, int post1, int post2) {
		if (in1 == in2 - 1 && post1 == post2 - 1) {
			return new TreeNode(inorder[in1]);
		}
		if (in1 == in2 && post1 == post2) {
			return null;
		}
		int rootVal = postorder[post2 - 1];
		TreeNode root = new TreeNode(rootVal);
		int num = 0;
		for (int i = in1; i < in2; i++) {
			if (inorder[i] == rootVal) {
				num = i - in1;
			}
		}
		root.left = recover(inorder, postorder, in1, in1 + num, post1, post1 + num);
		root.right = recover(inorder, postorder, in1 + num + 1, in2, post1 + num, post2 - 1);
		return root;
	}
}

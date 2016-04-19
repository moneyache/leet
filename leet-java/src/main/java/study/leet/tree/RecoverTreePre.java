package study.leet.tree;


public class RecoverTreePre {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		return recover(inorder, preorder, 0, inorder.length, 0, inorder.length);
	}
	public TreeNode recover(int[] inorder, int[] preorder, int in1, int in2, int pre1, int pre2) {
		if (in1 == in2 - 1 && pre1 == pre2 - 1) {
			return new TreeNode(inorder[in1]);
		}
		if (in1 == in2 && pre1 == pre2) {
			return null;
		}
		int rootVal = preorder[pre1];
		TreeNode root = new TreeNode(rootVal);
		int num = 0;
		for (int i = in1; i < in2; i++) {
			if (inorder[i] == rootVal) {
				num = i - in1;
			}
		}
		root.left = recover(inorder, preorder, in1, in1 + num, pre1 + 1, pre1 + num + 1);
		root.right = recover(inorder, preorder, in1 + num + 1, in2, pre1 + num + 1, pre2);
		return root;
	}
}

package study.leet.tree;


public class Arr2BST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		int length = num.length;
		return recurse(0, length - 1, num);
		
	}
	private TreeNode recurse(int start, int end, int[] num) {
		if (start == end) {
			return new TreeNode(num[end]);
		}
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = recurse(start, mid - 1, num);
		root.right = recurse(mid + 1, end, num);
		return root;
	}
}

package study.leet.tree;


public class IsBst {
    public boolean isValidBST(TreeNode root) {
    	if (root == null) {
			return true;
		}
        return recurse(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean recurse(TreeNode head, int max, int min) {
		if (head == null) {
			return true;
		}
		if (head.val >= max || head.val <= min) {
			return false;
		}
		return recurse(head.left, head.val, min) && recurse(head.right, max, head.val);
	}
    public static void main(String[] args) {
		
	}
}

package study.leet.tree;

public class GetLeafNum {
	public static boolean isAVL(TreeNode<Integer> root) {
		if (root==null) {
			return true;
		}
		if (Math.abs(root.getTreeDepth(root.leftChild)-root.getTreeDepth(root.rightChild))>2) {
			return false;
		}
		return isAVL(root.leftChild)&isAVL(root.rightChild);
	}

	public static boolean isSameBTree(TreeNode<Integer> tree1,TreeNode<Integer> tree2) {
		if ((tree1==null)&&(tree2==null)) {
			return true;
		}
		if ((tree1==null)^(tree2==null)) {
			return false;
		}
		if (tree1.data==tree2.data) {
			return isSameBTree(tree1.leftChild, tree2.leftChild)
					& isSameBTree(tree1.rightChild, tree2.rightChild);
		}
		return false;
	}
	public static int getLeafNum(TreeNode<Integer> root) {
		if (root==null) {
			return 0;
		}
		if ((root.leftChild==null)&&(root.rightChild==null)) {
			return 1;
		}
		return getLeafNum(root.leftChild)+getLeafNum(root.rightChild);
	}
	public static void main(String[] args) {
		TreeNode<Integer> r1 = new TreeNode<>(4);  
		TreeNode<Integer> r2 = new TreeNode<>(2); 
		TreeNode<Integer> r3 = new TreeNode<>(5);
		TreeNode<Integer> r4 = new TreeNode<>(1);
		TreeNode<Integer> r5 = new TreeNode<>(3);
		TreeNode<Integer> r6 = new TreeNode<>(6);

		r1.leftChild = r2;  
		r5.rightChild = r3;  
		r2.leftChild = r4;  
		r2.rightChild = r5;  
		r4.rightChild= r6;  
		System.out.println(isAVL(r1));
	}
}

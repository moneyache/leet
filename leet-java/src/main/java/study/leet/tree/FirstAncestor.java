package study.leet.tree;

public class FirstAncestor {

	public static TreeNode<Integer> ancestorNode;
	public static boolean isFather(TreeNode<Integer> possibleFather,TreeNode<Integer> possibleChil) {
		if (possibleFather==null) {
			return false;
		}
		if (possibleChil==possibleFather) {
			return true;
		}
		else {
			return isFather(possibleFather.leftChild, possibleChil)||isFather(possibleFather.rightChild, possibleChil);
		}
	}
	public static TreeNode<Integer> findFirstAncestor(TreeNode<Integer> root,TreeNode<Integer> node1,TreeNode<Integer> node2) {
		if (root==null||node1==null||node2==null) {
			return null;
		}
		else if (isFather(root.leftChild, node1)&&isFather(root.leftChild, node2)) {
			return findFirstAncestor(root.leftChild, node1, node2);
		}
		else if (isFather(root.rightChild, node1)&&isFather(root.rightChild, node2)) {
			return findFirstAncestor(root.rightChild, node1, node2);
		}
		else {
			return root;
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> root=new TreeNode<Integer>(0);
		TreeNode<Integer> node1=new TreeNode<Integer>(1);
		TreeNode<Integer> node2=new TreeNode<Integer>(2);
		TreeNode<Integer> node3=new TreeNode<Integer>(3);
		TreeNode<Integer> node4=new TreeNode<Integer>(4);
		TreeNode<Integer> node5=new TreeNode<Integer>(5);
		TreeNode<Integer> node6=new TreeNode<Integer>(6);
		TreeNode<Integer> node7=new TreeNode<Integer>(7);
		root.leftChild=node1;
		root.rightChild=node2;
		node1.leftChild=node3;
		node1.rightChild=node4;
		node3.leftChild=node5;
		node5.leftChild=node6;
		node5.rightChild=node7;
		TreeNode<Integer> res=findFirstAncestor(root, node4, node7);
		System.out.println(res.data);
	}
}

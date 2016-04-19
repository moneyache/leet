package study.leet.tree;

import java.util.Stack;

public class TreeToSortedLink {

	public static Stack<TreeNode<Integer>> stack=new Stack<>();
	public static void treeToSortedLink(TreeNode<Integer> current) {
		
		if (current!=null) {
			treeToSortedLink(current.leftChild);
			stack.push(current);
			treeToSortedLink(current.rightChild);
		}
		return;
	}
	public static void main(String[] args) {
		TreeNode<Integer> r1 = new TreeNode<>(4);  
		TreeNode<Integer> r2 = new TreeNode<>(2); 
		TreeNode<Integer> r3 = new TreeNode<>(5);
		TreeNode<Integer> r4 = new TreeNode<>(1);
		TreeNode<Integer> r5 = new TreeNode<>(3);
		TreeNode<Integer> r6 = new TreeNode<>(6);

		r1.leftChild = r2;  
		r1.rightChild = r3;  
		r2.leftChild = r4;  
		r2.rightChild = r5;  
		r3.rightChild= r6;  
		/*r1.preTraver(r1);
		System.out.println("\nthis is pre");
		r1.postTraver(r1);
		System.out.println("\nthis is post");
		r1.midTraver(r1);
		System.out.println("\nthis is mid");*/
		treeToSortedLink(r1);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}
		System.out.println(stack);
	}
}

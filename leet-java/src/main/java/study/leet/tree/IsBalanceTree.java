package study.leet.tree;

import java.util.LinkedList;

public class IsBalanceTree {

	private LinkedList<Integer> leafNodeDepth;
	public IsBalanceTree() {
		// TODO Auto-generated constructor stub
		leafNodeDepth=new LinkedList<>();
	}
	public  Boolean isBalanceTree(TreeNode<String> treeNode) {
		
		getLeafDepth(treeNode, 0);
		if (leafNodeDepth.isEmpty()) {
			return false;
		}
		int max=0,min=Integer.MAX_VALUE;
		for (int leafDepth : leafNodeDepth) {
		    max=leafDepth>max?leafDepth:max;
		    min=leafDepth<min?leafDepth:min;
		}
		if ((max-min)>=2) {
			return false;
		}
		return true;
	}
	private  void getLeafDepth(TreeNode<String> treeNode,int level) {
		if (treeNode==null) {
			return;
		}
			level++;
			if (treeNode.leftChild!=null) {
				getLeafDepth(treeNode.leftChild,level);
			}
			if (treeNode.rightChild!=null) {
				getLeafDepth(treeNode.rightChild,level);
			}
			if ((treeNode.leftChild==null)&&(treeNode.rightChild==null)) {
				leafNodeDepth.add(level);
			} 
	}
	public void levelTraver(TreeNode<String> treeNode) {
		LinkedList<TreeNode<String>> nodeQueue=new LinkedList<>();
		if (treeNode==null) {
			return;
		}
		nodeQueue.add(treeNode);
		while (!nodeQueue.isEmpty()) {
			TreeNode<String> current=nodeQueue.remove();
			if (current.leftChild!=null) {
				nodeQueue.add(treeNode.leftChild);
			}
			if (current.rightChild!=null) {
				nodeQueue.add(treeNode.rightChild);
			}
		}
		
	}
	public static void main(String[] args) {
		TreeNode<String> r1 = new TreeNode<>("1");  
		TreeNode<String> r2 = new TreeNode<>("2"); 
		TreeNode<String> r3 = new TreeNode<>("3");
		TreeNode<String> r4 = new TreeNode<>("4");
		TreeNode<String> r5 = new TreeNode<>("5");
		TreeNode<String> r6 = new TreeNode<>("6");
		TreeNode<String> r7 = new TreeNode<>("6");

		r1.leftChild = r2;  
		r1.rightChild = r7;  
		r6.rightChild = r3;  
		r2.leftChild = r4;  
		r2.rightChild = r5;  
		r5.rightChild= r6; 
		IsBalanceTree isBalanceTree=new IsBalanceTree();
		//System.out.println(getMinDepth(r1)+"test:"+Math.min(0, 0));
		System.out.println(isBalanceTree.isBalanceTree(r2));
	}
}

package study.leet.tree;

import java.util.LinkedList;
import java.util.List;

public class Tree2NLinks<E> {

	private List<List<TreeNode<E>>> listArrayList;
	private TreeNode<E>rooTreeNode;
	public Tree2NLinks(TreeNode<E>root) {
		// TODO Auto-generated constructor stub
		listArrayList=new LinkedList<>();
		this.rooTreeNode=root;
	}
	private  void tree2NLinks(List<TreeNode<E>>list) {
		
		if (list.isEmpty()) {
			return;
		}
		List<TreeNode<E>> tempList=new LinkedList<>();
		for (TreeNode<E> treeNode : list) {
			if (treeNode.leftChild!=null) {
				tempList.add(treeNode.leftChild);
			}
			if (treeNode.rightChild!=null) {
				tempList.add(treeNode.rightChild);
			}
		}
		if (tempList.isEmpty()) {
			return;
		}
		listArrayList.add(tempList);
		tree2NLinks(listArrayList.get(listArrayList.size()-1));
	}
	public List<List<TreeNode<E>>> getLists() {
		List<TreeNode<E>> list1=new LinkedList<>();
		list1.add(rooTreeNode);
		listArrayList.add(list1);
		tree2NLinks(list1);
		return this.listArrayList;
	}
	public static void main(String[] args) {

		TreeNode<String> r1 = new TreeNode<>("1");  
		TreeNode<String> r2 = new TreeNode<>("2"); 
		TreeNode<String> r3 = new TreeNode<>("3");
		TreeNode<String> r4 = new TreeNode<>("4");
		TreeNode<String> r5 = new TreeNode<>("5");
		TreeNode<String> r6 = new TreeNode<>("6");

		r1.leftChild = r2;  
		r1.rightChild = r3;  
		r2.leftChild = r4;  
		r2.rightChild = r5;  
		r3.rightChild= r6;  
		GetNumKLevel<String> getNumKLevel=new GetNumKLevel<>();
		System.out.println(getNumKLevel.getNum(r1, 3));
		/*Tree2NLinks<String> tree2nLinks=new Tree2NLinks<>(r1);
		List<List<TreeNode<String>>>list=tree2nLinks.getLists();
		for (List<TreeNode<String>> list2 : list) {
			System.out.println(list2.size()+"/");
			for (TreeNode<String> treeNode : list2) {
				System.out.println(treeNode.data);
			}
		}*/
	}
}

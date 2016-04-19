package study.leet.tree;

import java.util.ArrayList;
import java.util.List;

public class EnsureTreeWithPreMid<E> {

    public static class TreeNode<E>{
        TreeNode<E> leftChild;
        TreeNode<E> rightChild;
        E data;
        TreeNode(E data){
            this.data = data;
        }
    }
	public  TreeNode<E> ensureTree(List<TreeNode<E>> preList,List<TreeNode<E>> midList) {
		if (preList.isEmpty()||midList.isEmpty()) {
			return null;
		}
		List<TreeNode<E>> preRight;
		List<TreeNode<E>> preLeft;
		List<TreeNode<E>> midRight;
		List<TreeNode<E>> midLeft;
		int index=midList.indexOf(preList.get(0));
		midRight=midList.subList(index+1, midList.size());
		midLeft=midList.subList(0, index);
		preLeft=preList.subList(1, index+1);
		preRight=preList.subList(index+1, preList.size());
		TreeNode<E> root = new TreeNode<E>(preList.get(0).data);
		root.leftChild = ensureTree(preLeft, midLeft);
		root.rightChild = ensureTree(preRight, midRight);
		return root;
	}
	public static void main(String[] args) {
		TreeNode<String> r1 = new TreeNode<>("1");  
		TreeNode<String> r2 = new TreeNode<>("2"); 
		TreeNode<String> r3 = new TreeNode<>("3");
		TreeNode<String> r4 = new TreeNode<>("4");
		TreeNode<String> r5 = new TreeNode<>("5");
		TreeNode<String> r6 = new TreeNode<>("6");
		List<TreeNode<String>> preList=new ArrayList<TreeNode<String>>();
		List<TreeNode<String>> midList=new ArrayList<TreeNode<String>>();
		preList.add(r1);
		preList.add(r2);
		preList.add(r4);
		preList.add(r6);
		preList.add(r5);
		preList.add(r3);
		midList.add(r6);
		midList.add(r4);
		midList.add(r2);
		midList.add(r5);
		midList.add(r1);
		midList.add(r3);
		EnsureTreeWithPreMid<String> e=new EnsureTreeWithPreMid<>();
		TreeNode<String> root=e.ensureTree(preList, midList);
		System.out.println(root.leftChild.rightChild.leftChild.data);
	}
	}

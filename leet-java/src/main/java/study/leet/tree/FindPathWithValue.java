package study.leet.tree;

import java.util.List;

public class FindPathWithValue {

	public static void findSum(TreeNode<Integer> startNode,int sum,List<Integer> temp) {
		if (startNode==null) {
			return ;
		}
		temp.add(startNode.data);
		int cutValue=sum;
		int size=temp.size();
		for (int i = 0; i < size; i++) {
			cutValue -=temp.get(i);
		}
	}
}

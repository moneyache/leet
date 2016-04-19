package study.leet.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MiniDepth {
    public int minDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	Queue<Integer> count = new LinkedList<>();
    	queue.add(root);
    	count.add(1);
    	while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			int curpath = count.remove();
			if (cur.left == null && cur.right == null) {
				return curpath;
			}
			if (cur.left != null) {
				queue.add(cur.left);
				count.add(curpath + 1);
			}
			if (cur.right != null) {
				queue.add(cur.right);
				count.add(curpath + 1);
			}
		}
    	return 0;
        //return dfs(root, 1);
    }
    //dfs实现的遍历
    private int dfs(TreeNode cur, int sum) {
		if (cur.right == null && cur.left == null) {
			return sum;
		}
		int depth = Integer.MAX_VALUE;
		if (cur.left != null) {
			depth = Math.min(dfs(cur.left, sum + 1), depth);
		}
		if (cur.right != null) {
			depth = Math.min(dfs(cur.right, sum + 1), depth);
		}
		return depth;
	}
}

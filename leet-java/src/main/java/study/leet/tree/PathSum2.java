package study.leet.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
			return res;
		}
        List<Integer> initList = new ArrayList<>();
        initList.add(root.val);
        dfs(root, root.val, res, initList , sum);
        return res;
    }
    private void dfs(TreeNode cur, int tmpSum, List<List<Integer>> res, List<Integer> tmpList, int sum) {
    	if (cur.left == null && cur.right == null) {
			if (tmpSum == sum) {
				res.add(tmpList);
			}
			return;
		}
    	if (cur.left != null) {
    		List<Integer> leftList = new ArrayList<>(tmpList);
    		leftList.add(cur.left.val);
			dfs(cur.left, tmpSum + cur.left.val, res, leftList, sum);
		}
    	if (cur.right != null) {
			List<Integer> rightList = new ArrayList<>(tmpList);
			rightList.add(cur.right.val);
			dfs(cur.right, tmpSum + cur.right.val, res, rightList, sum);
		}
	}
}

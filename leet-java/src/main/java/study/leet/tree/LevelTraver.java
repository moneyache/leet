package study.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelTraver {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	LinkedList<List<Integer>> path = new LinkedList<List<Integer>>();
    	if (root == null) {
			return path;
		}
    	queue.offer(root);
    	int count = 1;
    	while (!queue.isEmpty()) {
    		List<Integer> levelList = new ArrayList<>();
			while (count != 0) {
				TreeNode cur = queue.poll();
				levelList.add(cur.val);
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
				count --;
			}
			path.addFirst(levelList);
			count = queue.size();
		}
        return path;
    }
    public static double pow(double x, int n) {
    	if(x == 1){
            return 1;
        }
    	if (x == -1) {
			if ((Math.abs(n) & 1) != 0) {
				return -1;
			}
			return 1;
		}
        if(n < 0){
            return 1/postivepow(x, -n);
        }
        return postivepow(x, n);
    }
   public static double postivepow(double x, int n) {
        double temp = x;
    	double res = 1;
    	while (n != 0) {
			if ((n & 1) != 0) {
				res *= temp;
			}
			temp *= temp;
			n = n >> 1;
		}
        return res;
    } 
    public static void main(String[] args) {
    	System.out.println(pow(2.5, 0));
    	double a = 1.000000;
    	System.out.println(a == 1);
    	/*TreeNode r1 = new TreeNode(1);  
		TreeNode r2 = new TreeNode(2); 
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		r1.left = r2;  
		r1.right = r7;  
		r6.right = r3;  
		r2.left = r4;  
		r2.right = r5;  
		r5.right= r6; 
		LevelTraver levelTraver = new LevelTraver();
		List<List<Integer>> path = levelTraver.levelOrderBottom(r1);
		for (List<Integer> list : path) {
			System.out.println("new line");
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
		}*/
	}
}

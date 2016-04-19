package study.leet.other;

import java.util.Stack;

public class Robot {


	public static int[][] blockMatrix;
		
	public static int getSteps(int m,int n) {
		if (m==0||n==0) {
			return 1;
		}
		return getSteps(m-1,n)+getSteps(m, n-1);
	}
	public static int getStepsWithBlock(int m,int n,Stack<Point> pathStack) {
		if (m==0&&n==0) {
			for (Point point : pathStack) {
				System.out.println("x"+point.x+"y:"+point.y+"\n");
			}
			return 1;
		}
		if (n>=1&&(blockMatrix[m][n-1]==1)) {
			Point point1=new Point(m, n-1);
			@SuppressWarnings("unchecked")
			Stack<Point> stack1=(Stack<Point>) pathStack.clone();
			stack1.push(point1);
			getStepsWithBlock(m, n-1, stack1);
		}
		if (m>=1&&(blockMatrix[m-1][n]==1)) {
			Point point2=new Point(m-1, n);
			@SuppressWarnings("unchecked")
			Stack<Point> stack2=(Stack<Point>) pathStack.clone();
			stack2.push(point2);
			getStepsWithBlock(m-1, n, stack2);
		}
		
		return 0;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		//System.out.println(getSteps(1, 2));
		blockMatrix=new int[][]{
				{1,1,1,1},
				{1,0,1,0},
				{1,0,1,0},
				{1,0,1,0},
		};
		Stack<Point> stack=new Stack<>();
		getStepsWithBlock(3, 3,stack);
	}
}

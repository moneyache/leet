package study.leet.other;

public class Paint {

	private int[][] matrix;
	public Paint(int[][] matrix) {
		// TODO Auto-generated constructor stub
		this.matrix=matrix;
	}
	class Point{
		int x,y;
		public Point(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	}
	public void paint(int x,int y,int color) {
		int xSize=matrix.length;
		int ySize=matrix[0].length;
		if (x<0||y<0||x>=xSize||y>=ySize) {
			return;
		}
		int value=matrix[x][y];
		if (value==color) {
			return;
		}
			matrix[x][y]=color;
			paint(x-1, y, color);
			paint(x+1, y, color);
			paint(x, y-1, color);
			paint(x, y+1, color);
	}
	public static void main(String[] args) {
		int[][] matrix=new int[][]{
				{0,0,0,0},
				{0,0,0,1},
				{0,0,0,1},
				{1,1,1,1},
		};
		Paint paint=new Paint(matrix);
		paint.paint(0, 0, 1);
		for (int[] is : matrix) {
			System.out.println("new line");
			for (int i : is) {
				System.out.println(i);
			}
		}
	}
}

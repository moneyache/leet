package study.leet.sort.crack;

public class SearchInSortedMatrix {

	public static class Coordinate{
		public int x,y;
		public Coordinate(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	public static int  midSearch(int[] array,int start,int end,int key) {
		while (start <= end) {
			int mid = (start+end)/2;
			int midValue = array[mid];
			if (midValue<key) {
				start = mid+1;
			}
			else if (midValue>key) {
				end = mid-1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	public static Coordinate getCoordinate(int[][] matrix,int key) {
		int Xcoord = -1;
		int Ycoord = -1;
		if (matrix == null||(matrix.length == 0)) {
			return null;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			if (key<matrix[i][0]) {
				return new Coordinate(Xcoord, Ycoord);
			}
			else {
				if (key>matrix[i][columns-1]) {
					Xcoord ++;
					continue;
				}
				int midSearchRes = midSearch(matrix[i], 0, columns-1, key);
				if (midSearchRes != -1) {
					return new Coordinate(i, midSearchRes);
				}
			}
		}
		return new Coordinate(-1, -1);
	}
	public static void main(String[] args) {
		int[][] matrix = {
				{1,3,5},
				{2,4,6},
				{8,8,12}
		};
		Coordinate coordinate = getCoordinate(matrix, 11);
		System.out.println(coordinate.x+"...."+coordinate.y);
	}
}

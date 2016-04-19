package study.leet.other;

public class Solution {

	public int[] searchRange(int[] A, int target) {
        int len = A.length;
        int index = midFind(A, 0, len - 1, target);
        int first = index, last = index;
        if (index == -1) {
			return new int[]{ -1, -1};
		}
        while (first >= 0 && A[first] == target) {
        	first -- ;
		}
        while (last < len && A[last] == target) {
			last ++ ;
		}
        int[] res = { first + 1, last - 1};
        return res;
    }
	private int midFind(int[] A, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		int midVal = A[mid];
		if (target > midVal) {
			return midFind(A, mid + 1, end, target);
		}
		else if (target < midVal) {
			return midFind(A, start, mid - 1, target);
		}
		else {
			return mid;
		}
	}
	public static void main(String[] args) {
		int[] A = {1};
		int tar = 3;
		Solution solution = new Solution();
		
		int[] res = solution.searchRange(A, tar);
		System.out.println(res[0] + ">>>>>>>>>>" + res[1]);
	}
}

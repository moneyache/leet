package study.leet.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen2 {
	public int totalNQueens(int n) {
		List<int[]> list = new ArrayList<>();
		list = recursion(n, 0, list);
		return list.size();
	}
	private List<int[]> recursion(int n, int index, List<int[]> list) {
		if (index == n) {
			return list;
		}
		if (index == 0) {
			for (int i = 0; i < n; i++) {
				int[] arr = new int[n];
				arr[0] = i;
				list.add(arr);
			}
			return recursion(n, 1, list);
		}
		List<int[]> newList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int[] is : list) {
				if(isValid(index, i, is)){
					int[] temp = Arrays.copyOf(is, n);
					temp[index] = i;
					newList.add(temp);
				}
			}
		}
		return recursion(n, index + 1, newList);
	}
	private boolean isValid(int index, int y, int[] arr) {
		for (int i = 0; i < index; i++) {
			if (!isValid(index, y, i, arr[i])) {
				return false;
			}
		}
		return true;
	}
	private boolean isValid(int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2) {
			return false;
		}
		else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return false;
		}
		return true;
	}
	public static int nnn(int root, int n) {
		int res = 1;
		int temp = root;
		do {
			if (n % 2 != 0) {
				res *= temp;
			}
			n = n / 2;
			if (n != 0) {
				temp *= temp;
			}
			
		} while (n != 0);
		return res;
	}
	public static void main(String[] args) {
		System.out.println(nnn(2, 5));
	}
}

package study.leet.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
	public List<String[]> solveNQueens(int n) {
		List<int[]> list = new ArrayList<>();
		list = recursion(n, 0, list);
		List<String[]> res = new ArrayList<>();
		for (int[] arr : list) {
			String[] temp = new String[n];
			for (int i = 0; i < n ; i++) {
				int indexQ = arr[i];
				for (int j = 0; j < n; j++) {
					if (temp[i] == null) {
						temp[i] = "";
					}
					if (j == indexQ) {
						temp[i] += 'Q';
					}
					else {
						temp[i] += '.';
					}
				}
			}
			res.add(temp);
		}
        return res;
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
	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		List<String[]> list = nQueen.solveNQueens(1);
		System.out.println(list.size());
		for (String[] strings : list) {
			System.out.println();
			for (String string : strings) {
				System.out.print(string + ";");
			}
		}
	}
}

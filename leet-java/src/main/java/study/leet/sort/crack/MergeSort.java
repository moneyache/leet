package study.leet.sort.crack;

import java.util.Arrays;

public class MergeSort {

	private final int[] unsortArr;
	private int[] tempArr;
	public MergeSort(int[] unsort) {
		// TODO Auto-generated constructor stub
		this.unsortArr = unsort;
		
	}
	public int[] sort() {
		int length = unsortArr.length;
		divArr(0, length - 1);
		return unsortArr;
	}
	private void divArr(int low, int high) {
		if (low < high) {
			int mid = low + (high - low)/2;
			divArr(low, mid);
			divArr(mid + 1, high);
			merge(low, mid, high);
		}
		return;
	}
	private void merge(int low, int mid, int high) {
		this.tempArr = Arrays.copyOf(unsortArr, unsortArr.length);
		int i = low;
		int j = mid + 1;
		int pos = low;
		while ((i <= mid) && (j <= high)) {
			if (tempArr[i] <= tempArr[j]) {
				unsortArr[pos++] = tempArr[i++];
			}
			if (tempArr[i] > tempArr[j]) {
				unsortArr[pos++] = tempArr[j++];
			}
		}
		while (i <= mid) {
			unsortArr[pos++] = tempArr[i++];
		}
	}
	public static void main(String[] args) {
		int[] test = {2,7,8,9,5,12,4,2,3};
		MergeSort mSort2 = new MergeSort(test);
		mSort2.sort();
		for (int i= 0; i< test.length;i++) {
			System.out.println(test[i]);
		}
	}
}

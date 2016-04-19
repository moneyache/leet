package study.leet.sort;

import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		divArr(0, arr.length - 1, arr);
	}
	private void divArr(int start, int end, int[] arr) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		divArr(start, mid, arr);
		divArr(mid + 1, end, arr);
		merge(start, end, arr);
	}
	private void merge(int start, int end, int[] arr) {
		if (start == end) {
			return;
		}
		int mid = start + (end - start) / 2;
		int i = start;
		int j = mid + 1;
		int k = start;
		int[] tmp = Arrays.copyOfRange(arr, start, end + 1);
		while (i <= mid && j <= end) {
			if (tmp[i - start] < tmp[j - start]) {
				arr[k] = tmp[i - start];
				k ++;
				i ++;
			}
			else {
				arr[k] = tmp[j - start];
				k ++;
				j ++;
			}
		}
		while (i <= mid) {
			arr[k] = tmp[i - start];
			k ++;
			i ++;
		}
	}
	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int[] arr = {1, 4, 5, 9, 7, 5, 2, 3, 6, 8};
		sort.mergeSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

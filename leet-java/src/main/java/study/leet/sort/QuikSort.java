package study.leet.sort;

public class QuikSort {

	public void quikSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return ;
		}
		int length = arr.length;
		sort(arr, 0, length - 1);
	}
	private void sort(int[] arr, int start, int end) {
		if (start == end) {
			return;
		}
		 int mid = start + (end - start) / 2;
		 int pivot = arr[mid];
		 int i = start;
		 int j = end;
		 while (i <= j) {
			while (arr[i] < pivot) {
				i ++;
			}
			while (arr[j] > pivot) {
				j --;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			i ++;
			j --;
		}
		 if (i <= end) {
			sort(arr, i, end);
		}
		 if (j >= start) {
			sort(arr, start, j);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,4};
		QuikSort sort = new QuikSort();
		sort.quikSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

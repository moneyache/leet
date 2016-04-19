package study.leet.sort.crack;

import java.util.Random;

public class QuikSort {

	private int[] unsortedArr;
	private int lenght;
	public QuikSort(int[] unsorted) {
		// TODO Auto-generated constructor stub
		this.unsortedArr = unsorted;
		this.lenght = unsorted.length;
	}
	public void sort() {
		quikSort(0, lenght - 1);
	}
	private void quikSort(int low, int high) {
			int i = low;
			int j = high;
			int mid = low + (high - low)/2;
			int pivot = unsortedArr[mid];
			while (i <= j) {
			while (unsortedArr[i] < pivot) {
				i ++;
			}	
			while (unsortedArr[j] > pivot) {
				j --;
			}
			if (i <= j) {
				exchange(i, j);
				i ++;
				j --;
			}
		}
			if (i < high) {
				quikSort(i, high);
			}
			if (j > low) {
				quikSort(low, j);
			}
	}
	private void exchange(int i, int j) {
		int temp = unsortedArr[i];
		unsortedArr[i] = unsortedArr[j];
		unsortedArr[j] = temp;
	}
	public static void main(String[] args) {
		int num = 1000;
		Random random = new Random();
		int[] unsorted = new int[num];
		for (int i = 0; i < num; i++) {
			unsorted[i] = new Random().nextInt(10000);
		}
		//int[] test = {2,3,9,7,6,12,11,15,8,4,2};
		QuikSort qSort2 = new QuikSort(unsorted);
		qSort2.sort();
		for (int i : unsorted) {
			System.out.println(i);
		}
	}
}

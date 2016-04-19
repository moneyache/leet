package study.leet.sort.crack;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;


public class QuickSort {

	private int[] unsorted;
	public QuickSort(int[] unsorted) {
		// TODO Auto-generated constructor stub
		this.unsorted = unsorted;
	}
	public int[] getSorted() {
		sort(0, unsorted.length-1);
		return this.unsorted;
	}
	private void sort(int start, int end) {
		if ((start>end-1)||(start==end)) {
			return;
		}
		int current = unsorted[start];
		int hole=start;
		for (int i = start+1; i <= end; i++) {
			if (current > unsorted[i]) {
				unsorted[hole++]=unsorted[i];
					for (int j = i; j > hole; j--) {
						unsorted[j] = unsorted[j-1];
				}
					continue;
			}
		}
		unsorted[hole]=current;
		sort(start, hole-1);
		sort(hole+1, end);
	}
	public static void main(String[] args) {
		//int[] test={2,7,9,5,4,3,6,1,3,0,19,13,18,20,3,31,33,35,48,21,90,89,50,23,28,67,65,35,42,22,90,67,45,33};
		int[] test = new int[100000];
		for (int i = 0; i < 1000; i++) {
			test[i] = new Random(1000).nextInt();
		}
		QuickSort sort=new QuickSort(test);
		long time1 = System.currentTimeMillis();
		int[] arr = sort.getSorted();
		long time2 = System.currentTimeMillis();
		DecimalFormat format = new DecimalFormat("0.00000");
		System.out.println(format.format(time2-time1));
		long time3 = System.currentTimeMillis();
		Arrays.sort(test);
		long time4 = System.currentTimeMillis();
		System.out.println(format.format(time4 - time3));
		/*for (int i : arr) {
			System.out.println(i);
		}*/
	}
}

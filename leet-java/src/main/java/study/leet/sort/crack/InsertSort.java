package study.leet.sort.crack;

import java.util.Random;

public class InsertSort {
	private int[] unsorted;
	private int length;
	public InsertSort(int[] unsorted) {
		// TODO Auto-generated constructor stub
		this.unsorted = unsorted;
		this.length = unsorted.length;
	}
	public void sort() {
		insert(1);
	}
	private void insert(int cur) {
		while (cur < length) {
			int curValue = unsorted[cur];
			int index = binInsert(curValue, 0, cur - 1);
			int pos = cur - 1;
			while (pos >= index) {
				unsorted[pos + 1] = unsorted[pos];
				pos --;
			}
			unsorted[index] = curValue;
			cur ++;
		}
	}
	private int binInsert(int curValue, int start, int end) {
		if(end <= start + 1){
			if (curValue > unsorted[end]) {
				return end + 1;
			}
			else if (curValue < unsorted[start]) {
				return start;
			}
			else {
				return end;
			}
		}
		int midIndex = start + (end - start)/2;
		int midValue = unsorted[midIndex];
		if (curValue < midValue) {
			return binInsert(curValue, start, midIndex);
		}
		else {
			return binInsert(curValue, midIndex, end);
		}
	}
	public static void main(String[] args) {
		int num = 10000;
		Random random = new Random();
		int[] unsorted = new int[num];
		for (int i = 0; i < num; i++) {
			unsorted[i] = random.nextInt(100000);
		}
		//int[] unsorted = {1,3,6,9,4,2,5};
		InsertSort sort=new InsertSort(unsorted);
		sort.sort();
		for (int i : unsorted) {
			System.out.println(i);
		}
	}
}

package study.leet.other;

import java.util.ArrayList;

public class LISDemo<T extends Comparable<T>> {
/*
 * 最长递增子序列,求一个
 */
	private T[] array;
	private ArrayList<T>[] lenArr;
	@SuppressWarnings("unchecked")
	public LISDemo(T[] arr) {
		// TODO Auto-generated constructor stub
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		this.array = arr;
		this.lenArr = new ArrayList[arr.length];
		for (int i = 0; i < arr.length; i++) {
			lenArr[i] = new ArrayList<T>();
			lenArr[i].add(array[i]);
		}
		
	}
	public ArrayList<T>[] getLenArr() {
		updateArr();
		return this.lenArr;
	}
	public void updateArr() {
		int i = 1;
		while (i < array.length) {
			int imax = 1;
			int maxj = 0;
			for (int j = 0; j < i; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					int temp = lenArr[j].size() +1;
					if (temp > imax) {
						imax = temp;
						maxj = j;
					}
				}
			}
			lenArr[i].addAll(lenArr[maxj]);
			i++;
		}
	}
	public static void main(String[] args) {
		Integer[] test = {1,3,2,4,7,8,9,6};
		LISDemo<Integer> demo = new LISDemo<>(test);
		ArrayList<Integer>[] arr = demo.getLenArr();
		arr[6].forEach((x)->System.out.println(x));
		//System.out.println(arr[6].size());
	}
}

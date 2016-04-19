package study.leet.sort.crack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSort {

	public static int[] heapSort(int[] unsorted) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for (int i = 0; i < unsorted.length; i++) {
			queue.offer(unsorted[i]);
		}
		for (int i = 0; i < unsorted.length; i++) {
			unsorted[i] = queue.poll();
		}
		return unsorted;
	}
	public static void main(String[] args) {
		int[] test = {2,2,3,6,4,1,8,15,12,0,33,-2};
		int[] arr=heapSort(test);
		for (int i : arr) {
			System.out.println(i);
		}
		Map<String, String> tableMap=new HashMap<>();
		tableMap.put(null, "");
	}
}

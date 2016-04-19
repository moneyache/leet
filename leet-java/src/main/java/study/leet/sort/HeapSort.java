package study.leet.sort;

public class HeapSort {

	public void heapSort(int[] arr) {
		Heap heap = new Heap(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = heap.delete();
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 3, 4, 8, 7, 6, 9};
		HeapSort sort = new HeapSort();
		sort.heapSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

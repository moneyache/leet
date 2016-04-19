package study.leet.sort;

import java.util.Arrays;

public class Heap{
	private int size;
	private int[] value;
	public Heap(int[] value) {
		this.size = value.length;
		this.value = Arrays.copyOf(value, size);
		initHeap();
	}
	public int delete() {
		int rootVal = value[0];
		value[0] = value[size - 1];
		value = Arrays.copyOf(value, size - 1);
		size --;
		fixDown(0);
		return rootVal;
	}
	public void insert(int val) {
		value = Arrays.copyOf(value, size + 1);
		value[size] = val;
		size ++;
		fixUp(size - 1);
	}
	private void initHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			fixDown(i);
		}
	}
	private void fixUp(int index) {
		int root = (index - 1) / 2 ;
		if (root < 0) {
			return;
		}
		int rootVal = value[root];
		if (rootVal <= value[index]) {
			return;
		}
		value[root] = value[index];
		value[index] = rootVal;
		fixUp(root);
	}
	private void fixDown(int rootIndex) {
		if (rootIndex >= size) {
			return;
		}
		int rootVal = value[rootIndex];
		int leftIndex = rootIndex * 2 + 1;
		if (leftIndex >= size) {
			return;
		}
		int leftVal = value[leftIndex];
		int rightIndex = leftIndex + 1;
		int minIndex;
		if (rightIndex >= size) {
			minIndex = leftIndex;
		}
		else {
			int rigthVal = value[rightIndex];
			minIndex = leftVal > rigthVal ? rightIndex : leftIndex;
		}
		if (rootVal <= value[minIndex]) {
			return;
		}
		value[rootIndex] = value[minIndex];
		value[minIndex] = rootVal;
		fixDown(minIndex);
	}
}

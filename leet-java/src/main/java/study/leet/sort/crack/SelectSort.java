package study.leet.sort.crack;

public class SelectSort {

	public int[] selectSort(int[] unsorted) {
		int length=unsorted.length;
		for (int i = 0; i < length; i++) {
			int min=getMinIndex(unsorted, i);
			swapIndexs(min, i, unsorted);
		}
		return unsorted;
	}
	private int getMinIndex(int[] unsorted,int index) {
		int length = unsorted.length;
		int minIndex = index;
		for (int i = index; i < length; i++) {
			if (unsorted[i]<unsorted[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	private void swapIndexs(int index1,int index2,int[] unsorted) {
		int temp =  unsorted[index1];
		unsorted[index1] = unsorted[index2];
		unsorted[index2] = temp;
	}
	public static void main(String[] args) {
		int[] test = {2,3,8,7,6,1,9,12,18,15};
		SelectSort sort=new SelectSort();
		int[] arr=sort.selectSort(test);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

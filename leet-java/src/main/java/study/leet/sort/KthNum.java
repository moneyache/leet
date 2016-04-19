package study.leet.sort;

public class KthNum {

	private int[] arr;
	private int k;
	public KthNum(int[] arr, int k) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		this.k = k;
	}
	public int getKthNum() {
		return KthRecur(arr, 0, arr.length - 1, k);
	}
	public int  KthRecur(int[] arr, int star, int end, int k) {
		int i = 0;
		int j = end - star;
		int partionor = arr[star];
		int[] temp = new int[j + 1];
		for (int l = star + 1; l <= end; l++) {
			int m = arr[l];
			if (m > partionor) {
				temp[j--] = m;
			}
			else {
				temp[i++] = m;
			}
		}
		temp[i] = partionor;
		int num = i;
		if (num == k - 1) {
			return partionor;
		}
		else if (num > k - 1) {
			return KthRecur(temp, 0, i, k);
		}
		else {
			return KthRecur(temp, i + 1, temp.length - 1, k - num - 1);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1, 8, 9, 12, 3, 8, 6, 4, 2};
		int k = 7;
		KthNum kthNum = new KthNum(arr, k);
		System.out.println(kthNum.getKthNum());
	}
}

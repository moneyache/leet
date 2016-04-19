package study.leet.sub.sequence;

public class LISeq {

	public int liseq(int[] arr) {
		int len = arr.length;
		if (len < 2) {
			return len;
		}
		int[] res = new int[len];
		res[0] = 1;
		int max = 0;
		for (int i = 1; i < len; i++) {
			if (arr[i] >= arr[i - 1]) {
				res[i] = res[i - 1] + 1;
			}
			else {
				int temp = i - 2;
				while (temp >= 0) {
					if (arr[i] >= arr[temp]) {
						res[i] = Math.max(res[i], res[temp] + 1);
					}
					temp --;
				}
			}
			max = Math.max(max, res[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		LISeq liSeq = new LISeq();
		int[] arr = {1, 5, 7, 9, 2, 3, 4, 6};
		System.out.println(liSeq.liseq(arr));
	}
}

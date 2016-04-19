package study.leet.sub.sequence;

public class LCSeq {

	public int lcseq(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int max = 0;
		int[][] res = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					res[i][j] = res[i - 1][j - 1] + 1;
				}
				else {
					res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
				}
				max = Math.max(res[i][j], max);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LCSeq lcSeq = new LCSeq();
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
		int[] arr2 = {1, 3, 5, 8, 2, 3, 4, 7};
		System.out.println(lcSeq.lcseq(arr1, arr2));
	}
}

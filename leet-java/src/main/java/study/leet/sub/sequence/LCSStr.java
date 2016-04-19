package study.leet.sub.sequence;

public class LCSStr {

	public int lcsStr(String str1, String str2) {
		
		return recurse(str1.toCharArray(), str2.toCharArray());
	}
	private int recurse(char[] arr1, char[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[][] res = new int[len1 + 1][len2 + 1];
		int max = 0;
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					res[i][j] = res[i - 1][j - 1] + 1;
				}
				else {
					res[i][j] = 0;
				}
				max = Math.max(res[i][j], max);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LCSStr lcsStr = new LCSStr();
		String str1 = "abcdf";
		String str2 = "eadfc";
		System.out.println(lcsStr.lcsStr(str1, str2));
	}
}

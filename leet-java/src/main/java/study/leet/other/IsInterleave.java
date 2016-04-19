package study.leet.other;

public class IsInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3 .length()) {
			return false;
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
		return recursie(s1, s2, s3, 0, 0, 0, matrix);
    }
	public boolean recursie(String s1, String s2, String s3, int start1, int start2, int start3, int[][] matrix) {
		if (s1.length() - 1 <= start1 && s2.length() - 1 <= start2) {
			return true;
		}
		if (matrix[start1][start2] == 1) {
			return true;
		}
		if (matrix[start1][start2] == -1) {
			return false;
		}
		char indexChar = s3.charAt(start3);
		boolean res1 = false;
		if (s1.length()  > start1) {
			char char1 = s1.charAt(start1);
			if (indexChar == char1) {
				res1 = recursie(s1, s2, s3, start1 + 1, start2, start3 + 1, matrix);
			}
		}
		boolean res2 = false;
		if (s2.length() > start2) {
			char char2 = s2.charAt(start2);
			if (indexChar == char2) {
				res2 = recursie(s1, s2, s3, start1, start2 + 1, start3 + 1, matrix);
			}
		}
		matrix[start1][start2] = res1 | res2 ? 1 : -1 ;
		return res1 | res2;
	}
	public static void main(String[] args) {
		//String s1 = "aabcc";
		//String s2 = "dbbca";
		//String s3 = "aadbbbaccc";
		String s1 = "",s2 = "" , s3 = "";
		IsInterleave interleave = new IsInterleave();
		System.out.println(interleave.isInterleave(s1, s2, s3));
	}
}

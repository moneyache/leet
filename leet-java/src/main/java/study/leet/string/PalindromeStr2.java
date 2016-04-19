package study.leet.string;

import java.util.HashMap;
import java.util.Map;

public class PalindromeStr2 {

    public int minCut(String s) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[][] matrix = new int[s.length()][s.length()];
        return cutRecur(s.length() - 1, s, map, matrix) - 1;
    }
    public int cutRecur(int end, String s, Map<Integer, Integer> map, int[][] matrix) {
    	if (end == 0) {
    		map.put(end, 1);
			return 1;
		}
    	if (isPalindrome(0, end, s, matrix)) {
    		map.put(end, 1);
			return 1;
		}
    	int result = Integer.MAX_VALUE;
    	for (int i = 1; i <= end; i++) {
			if (isPalindrome(i, end, s, matrix)) {
				Integer value = map.get(i - 1);
				int temp;
				if (value == null) {
					temp = cutRecur(i - 1, s, map, matrix) + 1;
				}
				else {
					temp = value + 1;
				}
				if (temp < result) {
					result = temp;
				}
			}
		}
    	map.put(end, result);
    	return result;
	}
    public boolean isPalindrome(int start, int end, String s, int[][] matrix) {
    	int matrixVal = matrix[start][end];
    	if (matrixVal == 1) {
			return true;
		}
    	if (matrixVal == -1) {
			return false;
		}
    	if (start >= end) {
			return true;
		}
		char startChar = s.charAt(start);
		char endChar = s.charAt(end);
		if (startChar != endChar) {
			matrix[start][end] = -1;
			return false;
		}
		else {
			boolean res = isPalindrome(start + 1, end - 1, s, matrix);
			matrix[start][end] = res == true ? 1 : -1;
			return res;
		}
	}
    public static void main(String[] args) {
    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    			+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		PalindromeStr2 palindromeStr = new PalindromeStr2();
		System.out.println(palindromeStr.minCut(s));
	//	System.out.println(palindromeStr.isPalindrome(2, 2, s));
	}
}

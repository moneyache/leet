package study.leet.string;

public class LPalindromeStr {

    public String longestPalindrome(String s) {
    	if (s == null) {
			return null;
		}
    	if (s.length() < 2) {
			return s;
		}
    	int len = s.length();
    	String resStr = s.substring(0, 1);
		for (int i = 0; i < len; i++) {
			String tmp = helper(i, i, s);
			if (tmp.length() > resStr.length()) {
				resStr = tmp;
			}
			tmp = helper(i, i + 1, s);
			if (tmp.length() > resStr.length()) {
				resStr = tmp;
			}
		}
        return resStr;
    }
    private String helper(int start, int end, String s) {
    	char[] arr = s.toCharArray();
		while (start >= 0 && end < arr.length && (arr[start] == arr[end])) {
			start --;
			end ++;
		}
		return s.substring(start + 1, end);
	}
    public static void main(String[] args) {
		LPalindromeStr lPalindromeStr = new LPalindromeStr();
		String s = "esbtzjaaijqkgmhseohcfvgq";
		System.out.println(lPalindromeStr.longestPalindrome(s));
	}
}

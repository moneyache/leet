package study.leet.other;

public class LcomPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null) {
			return null;
		}
    	String res = "";
    	int len = strs.length;
    	if (len == 0) {
			return res;
		}
    	if (len == 1) {
			return strs[0];
		}
    	for(int index = 0; ; index ++) {
    		int i = 0;
    		if (index >= strs[0].length()) {
				return res;
			}
    		char curChar = strs[0].charAt(index);
			for (; i < len; i++) {
				String curStr = strs[i];
				if (curStr.length() <= index) {
					break;
				}
				if (curChar != curStr.charAt(index)) {
					break;
				}
			}
			if (i < len) {
				break;
			}
			else {
				res += curChar;
			}
		}
        return res;
    }
    public static void main(String[] args) {
		LcomPrefix lcomPrefix = new LcomPrefix();
		String[] strs = {"ab", "abc", "abd", "abef"};
		System.out.println(lcomPrefix.longestCommonPrefix(strs));
	}
}

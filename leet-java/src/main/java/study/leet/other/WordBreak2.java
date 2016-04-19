package study.leet.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak2 {

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<>();
		if (dict == null || s == null || dict.isEmpty() || s.isEmpty()) {
			return list;
		}
		int[] dp = new int[s.length() + 1];
		dfs(list, s, 0, "", dict, dp);
		return list;
    }
	private boolean dfs(List<String> list, String s, int start, String tmp, Set<String> dict, int[] dp) {
		if (start >= s.length()) {
			list.add(tmp);
			return true;
		}
		boolean res = false;
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (dp[start] == -1) {
				continue;
			}
			if (dict.contains(sub)) {
				String newStr;
				if (tmp.equals("")) {
					newStr = sub;
				}
				else {
					newStr = tmp + " " + sub;
				}
				if (dp[i + 1] == -1) {
					continue;
				}
				res |= dfs(list, s, i + 1, newStr, dict, dp);
			}
			
		}
		if (!res) {
			dp[start] = -1;
		}
		return res;
	}
	public static void main(String[] args) {
		WordBreak2 break2 = new WordBreak2();
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("12");
		dict.add("12123");
		dict.add("123");
		dict.add("34");
		dict.add("45");
		dict.add("56");
		dict.add("89");
		String s = "a1212389";
		//List<String> list = break1.wordBreak(s, dict);
		List<String> list = new ArrayList<>();
		list = break2.wordBreak(s, dict);
		for (String string : list) {
			System.out.print(string + ",");
		}
		/*List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list2.add("3");
		list2.add("4");
		List<String> list3 = break1.combineLists(list1, list2);
		for (String string : list3) {
			System.out.println(string);
		}*/
	}
}

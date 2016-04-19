package study.leet.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		boolean[] arr = new boolean[len + 1];
		arr[0] = true;
		for (int i = 0; i <= len; i++) {
			if (!arr[i]) {
				continue;
			}
			for (String str : dict) {
				int tempLen = str.length();
				if (i + tempLen > len) {
					continue;
				}
				if (arr[i + tempLen]) {
					continue;
				}
				if (s.substring(i, i + tempLen).equals(str)) {
					arr[i + tempLen] = true;
				}
			}
			
		}
		return arr[len];
    }
	public static void main(String[] args) {
		WordBreak break1 = new WordBreak();
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("12");
		dict.add("1123");
		dict.add("34");
		dict.add("45");
		dict.add("56");
		dict.add("89");
		String s = "a112345689";
		int[] arr = {2, 5, 1, 3, 9};
		Arrays.sort(arr);
		//System.out.println(Arrays.binarySearch(arr, 13));
		System.out.println(break1.wordBreak(s, dict));
	}
}

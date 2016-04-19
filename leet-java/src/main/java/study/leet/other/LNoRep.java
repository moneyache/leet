package study.leet.other;

import java.util.HashMap;
import java.util.Map;


public class LNoRep {
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.isEmpty()) {
			return 0;
		}
    	int len = s.length();
    	if (len == 1) {
			return 1;
		}
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	int max = 1;
    	for (int i = 0; i < len; i++) {
    		char cur = s.charAt(i);
    		if (!map.containsKey(cur)) {
				map.put(cur, i);
			}
    		else {
				max = Math.max(max, map.size());
				i = map.get(cur);
				map.clear();
			}
		}
        return max > map.size() ? max :map.size();
    }
    public static void main(String[] args) {
		LNoRep lNoRep = new LNoRep();
		String s = "abcadvc";
		System.out.println(lNoRep.lengthOfLongestSubstring(s));
	}
}

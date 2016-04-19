package study.leet.other;

import java.util.HashMap;
import java.util.Map;

public class MiniWindow {
    public String minWindow(String S, String T) {
    	if (S == null || T== null || S.isEmpty() || T.isEmpty()) {
			return "";
		}
    	char[] sArr = S.toCharArray();
    	char[] tArr = T.toCharArray();
    	Map<Character, Integer> record = new HashMap<Character, Integer>();
    	initMap(tArr, record);
    	String res = null;
    	for (int i = 0; i < sArr.length; i++) {
			if (!record.containsKey(sArr[i])) {
				continue;
			}
			Map<Character, Integer> map = new HashMap<>(record);
			String temp = "";
			while (i < sArr.length && !map.isEmpty()) {
				char cur = sArr[i];
				Integer value = map.get(cur);
				if (value == null) {
					temp += cur;
					i ++;
					continue;
				}
				if (value > 1) {
					temp += cur;
					map.replace(cur, value - 1);
					i ++;
					continue;
				}
				i ++;
				temp += cur;
				map.remove(cur);
			}
			if (map.isEmpty()) {
				res = res == null ? temp : res.length() <= temp.length() ? res : temp; 
			}
		}
        return res;
    }
    public void initMap(char[] tArr, Map<Character, Integer> map) {
		for (char c : tArr) {
			if (map.containsKey(c)) {
				int val = map.get(c);
				map.replace(c, val + 1);
			}
			else {
				map.put(c, 1);
			}
		}
	}
    public static void main(String[] args) {
		MiniWindow miniWindow = new MiniWindow();
		/*Map<Character, Integer> map = new HashMap<>();
		char[] tArr = {'c', 'a', 'b', 'c'};
		miniWindow.initMap(tArr, map);*/
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(miniWindow.minWindow(S, T));
	}
}

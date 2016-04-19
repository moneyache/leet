package study.leet.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();
		List<String> initList = new ArrayList<>();
		initList.add(start);
		dfs(start, end, dict, initList, res);
		return res;
	}
	public void dfs(String start, String end, Set<String> dict, List<String> path, List<List<String>> res) {
		int min;
		if (res.isEmpty()) {
			min = Integer.MAX_VALUE;
		}
		else {
			min = res.get(0).size();
		}
		int lenght = path.size();
		if (lenght > min - 1) {
			return;
		}
		int strLen = start.length();
		for (int i = 0; i < strLen; i++) {
			char[] charArr = start.toCharArray();
			for (char c = 'a';  c <= 'z'; c++) {
				charArr[i] = c;
				String newStr = new String(charArr);
				if (newStr.equals(end)) {
					path.add(newStr);
					if (lenght < min - 1) {
						res.clear();
						min = lenght + 1;
					}
					res.add(path);
					return;
				}
				if (!dict.contains(newStr)) {
					continue;
				}
				List<String> newPath = new ArrayList<>(path);
				newPath.add(newStr);
				dict.remove(newStr);
				dfs(newStr, end, dict, newPath, res);
				dict.add(newStr);
			}
		}
	}
	public void recurse(String mid, String end, Set<String> dict, List<List<String>> res, List<String> curList) {
		int len = mid.length();
		if (mid.equals(end)) {
			res.add(curList);
			return;
		}
		for (int i = 0; i < len; i++) {
			char[] charArr = mid.toCharArray();
			for (char c = 'a';  c <= 'z'; c++) {
				charArr[i] = c;
				String newStr = new String(charArr);
				if (!curList.contains(newStr)) {
					if (newStr.equals(end)) {
						List<String> newList = new ArrayList<String>(curList);
						newList.add(newStr);
						res.add(newList);
					}
					else if (dict.contains(newStr)) {
						List<String> newList = new ArrayList<String>(curList);
						newList.add(newStr);
						recurse(newStr, end, dict, res, newList);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder2 wordLadder2 = new WordLadder2();
		List<List<String>> res = wordLadder2.findLadders(start, end, dict);
		for (List<String> list : res) {
			System.out.println("...........:");
			for (String string : list) {
				System.out.print(string + ",");
			}
		}
	}
}

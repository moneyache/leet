package study.leet.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PalindromeStr {
	public List<List<String>> partition(String s) {
		Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
		int end = s.length() - 1;
		for (int i = 0; i <= end; i++) {
			partitionRecurs(i, map, s);
		}
        return map.get(end);
    }
	public void partitionRecurs(int index, Map<Integer, List<List<String>>> map, String s) {
		List<List<String>> curList = new ArrayList<>();
		List<Integer> list = getIndexPalindrome(index, s);
		for (int integer : list) {
			String subStr = s.substring(integer, index + 1);
			List<List<String>> tempList = map.get(integer - 1);
			if (tempList == null) {
				tempList = new ArrayList<>();
				tempList.add(new ArrayList<>());
			}
			for (List<String> list2 : tempList) {
				List<String> newList = new ArrayList<>(list2);
				newList.add(subStr);
				curList.add(newList);
			}
		}
		map.put(index, curList);
	}
	public List<Integer> getIndexPalindrome(int index, String s) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= index; i++) {
			if (isPalindrome(i, index, s)) {
				list.add(i);
			}
		}
		return list;
	}
	public boolean isPalindrome(int start, int end, String s) {
		if (start == end) {
			return true;
		}
		char startChar = s.charAt(start);
		char endChar = s.charAt(end);
		if (start == end - 1) {
			return startChar == endChar ? true : false;
		}
		if (startChar == endChar) {
			return isPalindrome(start + 1, end - 1, s);
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		String s = "ababa";
		PalindromeStr palindromeStr = new PalindromeStr();
		List<List<String>> list = palindromeStr.partition(s);
		for (List<String> list2 : list) {
			System.out.println("new line...............");
			for (String string : list2) {
				System.out.println(string);
			}
		}
	}
}

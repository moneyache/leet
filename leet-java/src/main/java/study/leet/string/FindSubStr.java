package study.leet.string;

import java.util.ArrayList;
import java.util.List;


public class FindSubStr {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> list = new ArrayList<>();
		if (S == null || L == null || L.length == 0 || S.isEmpty()) {
			return list;
		}
		int size = L[0].length();
		if (S.length() < size) {
			return list;
		}
		List<Integer> map = new ArrayList<Integer>();
		fullMap(map, L);
		for (int i = size; i <= S.length();) {
			String temp = S.substring(i - size, i);
			Integer index = contain(map, L, temp);
			if (index != -1) {
				map.remove(index);
				if (map.isEmpty()) {
					i -= L.length * size;
					list.add(i);
					fullMap(map, L);
				}
				i += size;
			}
			else {
				fullMap(map, L);
				i ++;
			}
		}
		return list;
	}
	private void fullMap(List<Integer> map, String[] L) {
		
		map.clear();
		for (int j = 0; j < L.length; j++) {
			map.add(j);
		}
	}
	private int contain(List<Integer> map, String[] L, String temp) {
		for (int i : map) {
			if (L[i].equals(temp)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L = {"fooo", "barr", "wing", "ding", "wing"};
		FindSubStr findSubStr = new FindSubStr();
		List<Integer> list = findSubStr.findSubstring(S, L);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}

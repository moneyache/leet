package study.leet.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<>();
		Queue<Integer> distanceQueue = new LinkedList<>();
		queue.add(start);
		distanceQueue.add(1);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			int distance = distanceQueue.poll();
			if (cur.equals(end)) {
				return distance;
			}
			for (int i = 0; i < cur.length(); i++) {
				char[] charArr = cur.toCharArray();
				for (char j = 'a'; j < 'z'; j++) {
					charArr[i] = j;
					String newStr = new String(charArr);
					if (dict.contains(newStr)) {
						queue.add(newStr);
						distanceQueue.add(distance ++);
						dict.remove(newStr);
					}
				}
				
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		WordLadder ladder = new WordLadder();
		Set<String> dict = new HashSet<>();
		dict.add("hit");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		String start = "hxt";
		String end = "dog";
		System.out.println(ladder.ladderLength(start, end, dict));
	}
}

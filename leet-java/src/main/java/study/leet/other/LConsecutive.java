package study.leet.other;

import java.util.HashSet;
import java.util.Set;

public class LConsecutive {
    public int longestConsecutive(int[] num) {
    	Set<Integer> set = new HashSet<>();
    	for (int integer : num) {
			set.add(integer);
		}
    	int max = 1;
    	for (int integer : num) {
			int left = integer - 1;
			int right = integer + 1;
			int count = 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count ++;
				set.remove(right);
				right++;
			}
			max = Math.max(count, max);
		}
    	return max;
    }
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 9, 10, 11};
		LConsecutive lConsecutive = new LConsecutive();
		System.out.println(lConsecutive.longestConsecutive(arr));
	}
}

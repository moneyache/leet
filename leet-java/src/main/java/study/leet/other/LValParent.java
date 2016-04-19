package study.leet.other;

import java.util.Stack;


public class LValParent {

    public int longestValidParentheses(String s) {
    	if (s == null) {
			return 0;
		}
    	char[] arr = s.toCharArray();
    	int len = arr.length;
    	if (len < 2) {
			return 0;
		}
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}
			char top = arr[stack.peek()];
			if (top == '(' && arr[i] == ')') {
				stack.pop();
				continue;
			}
			stack.push(i);
		}
        if (stack.isEmpty()) {
			return len;
		}
        int max = 0;
        int high = len;
        while (!stack.isEmpty()) {
			int low = stack.pop();
			max = Math.max(max, high - low - 1);
			high = low;
		}
        max = Math.max(max, high);
        return max;
    }
    public static void main(String[] args) {
		LValParent lValParent = new LValParent();
		String s = "()()()((())((";
		System.out.println(lValParent.longestValidParentheses(s));
	}
}

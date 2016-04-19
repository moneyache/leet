package study.leet.string;

import java.util.Stack;

public class ReverseWord {

	public String reverseWords(String s) {
		Stack<String> stack = str2Arr(s);
		if (stack == null) {
			return "";
		}
		StringBuilder newStrBuilder = new StringBuilder("");
		while (!stack.isEmpty()) {
			String temp = stack.pop();
			newStrBuilder.append(temp + " ");
		}
		if (!newStrBuilder.toString().equals("")) {
			newStrBuilder.deleteCharAt(newStrBuilder.length() - 1);
		}
        return newStrBuilder.toString();
    }
	public Stack<String> str2Arr(String str) {
		if (str == null) {
			return null;
		}
		Stack<String> wordStack = new Stack<String>();
		int length = str.length();
		int index = 0;
		while (index < length) {
			char point;
			StringBuilder builder = new StringBuilder("");
			while ((index < length) && (point = str.charAt(index)) != ' ') {
				builder.append(point);
				index ++ ;
			}
			if (!builder.toString().equals("")) {
				wordStack.push(builder.toString());
			}
			index ++ ;
		}
		return wordStack;
		
	}
	public static void main(String[] args) {
		ReverseWord solution2 = new ReverseWord();
		String a = "a";
		String res = solution2.reverseWords(a);
		System.out.println(res);
		/*System.out.println(",,,,,,,,,,,,,,,,"+new String());
		StringBuilder builder = new StringBuilder(" ");
		System.out.println(builder == new StringBuilder(" "));*/
	}
}

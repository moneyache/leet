package study.leet.other;

import java.util.Stack;

public class PolishNotation {

	public int evalRPN(String[] tokens) {
		int length = tokens.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			String temp = tokens[i];
			switch (temp) {
			case "+":
				int secondAdd = stack.pop();
				int firstAdd = stack.pop();
				stack.push(firstAdd + secondAdd);
				break;
			case "-":
				int secondSub = stack.pop();
				int firstSub = stack.pop();
				stack.push(firstSub - secondSub);
				break;
			case "*":
				int secondMul = stack.pop();
				int firstMul = stack.pop();
				stack.push(firstMul * secondMul);
				break;
			case "/":
				int secondDiv = stack.pop();
				int firstDiv = stack.pop();
				stack.push(firstDiv / secondDiv);
				break;
			default:
				stack.push(Integer.parseInt(temp));
				break;
			}
		}
        return stack.pop();
    }
	public static void main(String[] args) {
		PolishNotation notation = new PolishNotation();
		String[] test = {"2", "1", "+", "3", "*"};
		System.out.println(notation.evalRPN(test));
	}
}

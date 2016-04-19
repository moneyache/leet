package study.leet.other;

public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null) {
			return 0;
		}
		int len = s.length();
		if (len == 0 || !isRight1(s.charAt(0))) {
			return 0;
		}
		if (len == 1) {
			return 1;
		}
		int[] arr = new int[len];
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (isRight1(s.charAt(i))) {
				arr[i] += arr[i - 1];
			}
			if (isRight2(s.substring(i - 1, i + 1))) {
				if (i - 2 == -1) {
					arr[i] += 1;
				}
				else {
					arr[i] += arr[i - 2];
				}
			}
		}
		return arr[len - 1];
	}
	private boolean isRight1(char a) {
		if (a == '0') {
			return false;
		}
		return true;
	}
	private boolean isRight2(String a) {
		int temp = Integer.parseInt(a);
		if (temp <= 26 && temp >= 10) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String string = new String("111");
		String string2 = string.intern();
		String string3 = "111";
		System.out.println(string == string2);
		System.out.println(string3 == string2);
	}
}

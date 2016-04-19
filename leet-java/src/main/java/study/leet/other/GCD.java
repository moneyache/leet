package study.leet.other;


public class GCD {

	public int gcd(int int1, int int2) {
		if (int1 < int2) {
			return gcd(int2, int1);
		}
		if (int2 == 0) {
			return int1;
		}
		if (isEven(int1)) {
			if (isEven(int2)) {
				return 2 * gcd(int1 >> 1, int2 >> 1);
			}
			return gcd(int1 >> 1, int2);
		}
		else {
			if (isEven(int2)) {
				return gcd(int1, int2 >> 1);
			}
			else {
				return gcd(int2, int1 - int2);
			}
		}
	}
	private boolean isEven(int a) {
		a = a & 1;
		return a == 0 ? true :false;
	}
	public static void main(String[] args) {
		int a = 15;
		int b = 45;
		GCD cGcd = new GCD();
		System.out.println(cGcd.gcd(a, b));
	}
}

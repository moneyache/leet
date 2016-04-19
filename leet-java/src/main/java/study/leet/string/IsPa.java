package study.leet.string;

public class IsPa {

    public boolean isPalindrome(int x) {
        if (x < 0) {
			return false;
		}
        if (x == 0) {
			return true;
		}
        if (x % 10 == 0) {
			return false;
		}
        return recursion(x, 0);
    }
    private boolean recursion(int x, int y) {
    	if (x < y) {
			return false;
		}
    	if (x == y) {
			return true;
		}
		int last = x % 10;
		int temp = y * 10 + last;
		if (temp == x) {
			return true;
		}
		else {
			return recursion(x / 10, temp);
		}
	}
    public static void main(String[] args) {
		int x = 1;
		IsPa isPa = new IsPa();
		System.out.println(isPa.isPalindrome(x));
	}
}

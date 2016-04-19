package study.leet.string;

public class IsPalinDromeNum {
    public boolean isPalindrome(int x) {
    	if (x < 0) {
			return false;
		}
    	if (x == 0) {
			return true;
		}
        int div = 1;
        while ((x / div) >= 10) {
			div *= 10;
		}
        while (x != 0) {
			int high = x / div;
			int low = x % 10;
			if (high != low) {
				return false;
			}
			x = (x % div) / 10;
			div /= 100;
		}
        return true;
    }
    public static void main(String[] args) {
		IsPalinDromeNum isPalinDromeNum = new IsPalinDromeNum();
		System.out.println(isPalinDromeNum.isPalindrome(121));
	}
}

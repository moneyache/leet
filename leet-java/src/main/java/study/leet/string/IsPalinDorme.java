package study.leet.string;

public class IsPalinDorme {

	public boolean isPalindrome(String s) {
		int length = s.length();
		
        return part(0, length - 1, s);
    }
	public boolean part(int start, int end, String s) {
		while (start < end) {
			char preChar = s.charAt(start);
			char laterChar = s.charAt(end);
			if (!isValidChar(preChar)) {
				start ++;
				continue;
			}
			if (!isValidChar(laterChar)) {
				end --;
				continue;
			}
			if (!isEqual(preChar, laterChar)) {
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
	public boolean isValidChar(char a) {
		if (a <= 'Z' && a >= 'A') {
			a += 32;
			return true;
		}
		if (a <= '9' && a >= '0') {
			return true;
		}
		return a <= 'z' && a >= 'a' ? true : false;
	}
	public boolean isEqual(char a, char b) {
		if (a <= 'Z' && a >= 'A') {
			a += 32;
		}
		if (b <= 'Z' && b >= 'A') {
			b += 32;
		}
		return a == b ? true : false;
	}
	public static void main(String[] args) {
		IsPalinDorme isPalinDorme = new IsPalinDorme();
		char a = 'A';
		isPalinDorme.isValidChar(a);
		System.out.println(a);
		System.out.println(isPalinDorme.isPalindrome("1a2"));
	}
}

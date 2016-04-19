package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class FullPermutation {

	public static List<String> arrList = new ArrayList<>();
	public static List<String> fullPermutationStr(String str) {
		char[] charSeq = str.toCharArray();
		List<Character> preChars = new ArrayList<>();
		for (char character : charSeq) {
			preChars.add(character);
		}
		permutation(new ArrayList<Character>(), preChars);
		return arrList;
	}
	public static void permutation(List<Character> preChars, List<Character> suffixChars) {
		
		int size = suffixChars.size();
		if (size == 0) {
			arrList.add(charList2Str(preChars));
		}
		for (int i = 0; i < size ; i++) {
			List<Character> preChari = new ArrayList<Character>(preChars);
			preChari.add(suffixChars.get(i));
			List<Character> suffixCharsi = new ArrayList<>(suffixChars);
			suffixCharsi.remove(i);
			permutation(preChari, suffixCharsi);
		}
	}
	public static String charList2Str(List<Character> chars) {
		StringBuilder string = new StringBuilder();
		for (Character character : chars) {
			string.append(character);
		}
		return new String(string);
	}
	public static void main(String[] args) {
		String testString = "abcd";
		List<String> list = fullPermutationStr(testString);
		for (String string : list) {
			System.out.println(string);
		}
	}
}

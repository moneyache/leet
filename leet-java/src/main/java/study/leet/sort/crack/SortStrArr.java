package study.leet.sort.crack;

import java.util.Arrays;
import java.util.Comparator;

public class SortStrArr {

	public static String sortCharArray(String inputStr) {
		char[] charArray=inputStr.toCharArray();
		String[] strArray=new String[]{"aooo","biin","cdien","bdien"};
		
		Arrays.sort(strArray, new Comparator<String>() {
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}});
		for (String string : strArray) {
			System.out.println(string);
		}
		/*Arrays.sort(charArray);
		for (char c : charArray) {
			System.out.println(c);
		}*/
		return null;
	}
	public static String[] sortStrArray(String[] strArr) {
		return null;
	}
	public static void main(String[] args) {
		sortCharArray("eixoao12no");
		//System.out.println("qss".compareTo("qas"));
	}
}

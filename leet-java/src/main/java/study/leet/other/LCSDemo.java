package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class LCSDemo {

	private char[] str1Array;
	private char[] str2Array;
	private List<Character> comSqueue;
	public LCSDemo(String str1, String str2) {
		// TODO Auto-generated constructor stub
		this.str1Array = str1.toCharArray();
		this.str2Array = str2.toCharArray();
		comSqueue=new ArrayList<Character>();
	}
	public List<Character> getCom() {
		System.out.println(LCS(str1Array.length-1, str2Array.length-1, ""));
		return comSqueue;
	}
	public String LCS(int row, int column, String squeue) {
		if ((row == -1) || (column == -1)) {
			return squeue;
		}
		if (str1Array[row] == str2Array[column]) {
			
			return LCS(row-1, column-1, squeue+str1Array[row]);
		}
		else {
			return getLonger(LCS(row, column-1, squeue), LCS(row-1, column, squeue));
		}
	}
	private String getLonger(String str1, String str2) {
		int lenght1 = str1.length();
		int lenght2 = str2.length();
		return lenght1 > lenght2 ? str1 : str2;
	}
	public static void main(String[] args) {
		LCSDemo demo =  new LCSDemo("12345678901", "45986017");
		/*int[][] matrix = new int[9][8];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				matrix[i][j] = demo.LCS(i, j);
			}
		}*/
		
		for (char is : demo.getCom()) {
			System.out.println(is);
		}
		/*for (int[] is : matrix) {
			//System.out.println("............");
			for (int i : is) {
				//System.out.println(i);
			}
		}*/
	}
}

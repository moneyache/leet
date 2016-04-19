package study.leet.other;


public class Fibonacci {
//recursion
	public static int generateFib(int mount) {
		if (mount==0) {
			return 0;
		}
		if (mount==1) {
			return 1;
		}
		
		return generateFib(mount-1)+generateFib(mount-2);
	}
//non recursion
	public static int generateFibNoRe(int mount) {
		int temp1=0;
		int temp2=1;
		if (mount==0) {
			return temp1;
		}
		if (mount==1) {
			return temp2;
		}
		for (int i = 2; i <= mount; i++) {
			int temp=temp1+temp2;
			temp1=temp2;
			temp2=temp;
		}
		return temp2;
	}
	public static void main(String[] args) {
		System.out.println(generateFibNoRe(10));
	}
	
}

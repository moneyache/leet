package study.leet.other;

public class NPow {

	public static long  npow(long n,int pow) {
		long res=1;
		while (pow>0) {
			if ((pow&1)==1) {
				res *=n;
			}
			n *=n;
			pow>>=1;
		}
		return res;
	}
	public static void main(String[] args) {
		//long res=npow(2, 2);
		System.out.println(4|0);
	}
}

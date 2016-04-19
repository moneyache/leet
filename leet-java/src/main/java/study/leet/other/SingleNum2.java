package study.leet.other;

public class SingleNum2 {

	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int res = 0;
		for (int i : A) {
			res = res ^ i;
		}
		return res;  
	}
	public static void main(String[] args) {
		int[] A = {1, 1, 3, 3, 4, 4, 0, 5, 5};
		SingleNum2 singleNum = new SingleNum2();
		System.out.println(singleNum.singleNumber(A));
	}
}

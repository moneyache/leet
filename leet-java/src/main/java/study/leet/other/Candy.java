package study.leet.other;

public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		if (ratings.length == 1) {
			return 1;
		}
		int size = ratings.length;
		int[] candys = new int[size];
		for (int i = 0; i < size; i++) {
			candys[i] = 1;
		}
		for (int i = 1; i < size; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candys[i] = candys[i - 1] + 1;
			}
		}
		for (int i = size - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				if (candys[i] <= candys[i + 1]) {
					candys[i] = candys[i + 1] + 1;
				}
			}
		}
		int sum = 0;
		for (int i : candys) {
			sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] ratings = {1, 2, 2, 4, 6, 2};
		Candy candy = new Candy();
		System.out.println(candy.candy(ratings));
	}
}

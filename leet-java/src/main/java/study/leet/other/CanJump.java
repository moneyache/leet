package study.leet.other;

public class CanJump {

	public boolean canJump(int[] A) {
		int len = A.length;
		boolean[] arr = new boolean[len];
		arr[0] = true;
		for (int i = 0; i < len; i++) {
			if (!arr[i]) {
				return false;
			}
			int jumpStep = A[i];
			if (jumpStep + i >= len - 1) {
				return true;
			}
			int j = jumpStep + i;
			while (j >= i) {
				if (arr[j]) {
					break;
				}
				arr[j--] = true;
			}
		}
		return false;
	}
	public int canJump2(int[] A) {
		int len = A.length;
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] == -1) {
				return -1;
			}
			int jumpStep = A[i];
			if (jumpStep + i >= len - 1) {
				return arr[i] + 1;
			}
			int j = jumpStep + i;
			while (j >= i) {
				if (arr[j] != -1) {
					break;
				}
				arr[j--] = arr[i] + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		int[] A = {1, 2, 3, 4, 0, 0, 0, 1};
		System.out.println(canJump.canJump2(A));
		/*boolean[] test = new boolean[2];
		System.out.println(test[1]);*/
	}
}

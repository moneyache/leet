package study.leet.list;

public class RemoveDupArr {
    public int removeDuplicates(int[] A) {
     
    	if(A == null){
    		return 0;
    	}
    	int len = A.length;
    	if (len < 2) {
			return len;
		}
    	int curVal = A[0];
    	int index = 1;
    	for (int i = 1; i < len; i++) {
    		int tmpVal = A[i];
			if (curVal == tmpVal) {
				continue;
			}
			curVal = tmpVal;
			A[index ++] = tmpVal;
		}
    	return index;
    }
    public static void main(String[] args) {
		RemoveDupArr removeDupArr = new RemoveDupArr();
		int[] A = {1, 1, 2, 2, 3, 4, 5, 5};
		System.out.println(removeDupArr.removeDuplicates(A));
		for (int i : A) {
			System.out.print(i + ",");
		}
	}
}

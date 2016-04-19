package study.leet.sort.crack;

public class InsertArrayWithSorted {
/*
 * nice algorithm
 * 
 */
	public static void insertArrayWithSorted (int[] arrayA,int[] arrayB,int m,int n) {
		int i=m-1,j=n-1;
		int last=m+n-1;
		while ((j>=0)&&(i>=0)) {
			if (arrayA[i]>arrayB[j]) {
				arrayA[last--]=arrayA[i--];
			}
			else {
				arrayA[last--]=arrayB[j--];
			}
		}
		while (j>=0) {
			arrayA[j]=arrayB[j--];
		}
	}
	public static void main(String[] args) {
		int[] testArray=new int[10];
		testArray[0]=0;
		testArray[1]=4;
		testArray[2]=6;
		testArray[3]=8;
		int [] testArray2=new int[]{0,1,2,3,4,5};
		insertArrayWithSorted(testArray, testArray2, 4,6 );
		for (int i : testArray) {
			System.out.println(i);
		}
	}
}

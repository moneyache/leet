package study.leet.other;

public class MedianNum {

	public double findMedianSortedArrays(int A[], int B[]) {
		int size1 = A.length;
		int size2 = B.length;
		int res = medianRecur(0, size1 - 1, 0, size2 - 1, A, B);
        return res;
    }
	public int  medianRecur(int start1, int end1, int start2, int end2, int A[], int B[]) {
		int mid1 = start1 + (end1 - start1)/2;
		int mid2 = start2 + (end2 - start2)/2;
		int midValA = A[mid1];
		int midValB = B[mid2];
		if ((end1 - start1 == 1 && end2 - start2 == 0) || (end1 - start1 == 0 && end2 - start2 == 1)) {
			return midValA > midValB ? midValA : midValB;
		}
		if (midValA > midValB) {
			 return medianRecur(start1, mid1, mid2, end2, A, B);
		}
		else if(midValA < midValB) {
			return medianRecur(mid1, end1, start2, mid2, A, B);
		}
		return midValA;
	}
	public static void main(String[] args) {
		MedianNum medianNum = new MedianNum();
		int[] A = {1, 2, 3};
		int[] B = {4, 5, 6, 7, 8, 9};
		System.out.println(medianNum.findMedianSortedArrays(A, B));
	}
}

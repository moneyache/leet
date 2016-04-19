package study.leet.sort.crack;

public class RotaArrSearch {

	private int[] rotaArr;
	private int key;
	public RotaArrSearch(int[] rotaArr,int key) {
		// TODO Auto-generated constructor stub
		this.rotaArr=rotaArr;
		this.key=key;
		
	}
	public int search() {
		int index=getIndex(rotaArr);
		if (key>rotaArr[0]) {
			return midSearch(0, index, key);
		}
		else if (key<rotaArr[0]) {
			return midSearch(index+1, rotaArr.length-1, key);
		}
		else {
			return 0;
		}
	}
	private int getIndex(int[] rotaArr) {
		int length = rotaArr.length;
		for (int j = 0; j < length; j++) {
			if (rotaArr[j]>rotaArr[j+1]) {
				return j;
			}
		}
		return 0;
	}
	private int  midSearch(int start, int end, int searchKey) {
		while (start<=end) {
			int mid=(start+end)/2;
			if (rotaArr[mid]>searchKey) {
				end=mid-1;
			}
			else if (rotaArr[mid]<searchKey) {
				start=mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;	
	}
	/*public int searchKey(int[] arr, int searchKey) {
		int start=0;
		int end=arr.length-1;
		int first=arr[0];
		while (end>=start) {
			int mid=(start+end)/2;
			int midValue=arr[mid];
			if (first<midValue) {
				if (searchKey<midValue) {
					end=mid-1;
				}
				if (searchKey>midValue) {
					start=mid+1;
				}
				if (searchKey==midValue) {
					return mid;
				}
			}
			else if (first>midValue) {
				
			}
		}
	}*/
	public static void main(String[] args) {
		int[] test=new int[]{7,8,9,0,1,2,3,4,5,6};
		RotaArrSearch search=new RotaArrSearch(test, 9);
		System.out.println(search.search());
	}
}

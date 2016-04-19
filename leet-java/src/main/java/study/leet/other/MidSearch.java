package study.leet.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MidSearch {

	public int start;
	public int end;
	public  int midSearch(ArrayList<Integer> list,int key) {
		if (list.isEmpty()) {
			return -1;
		}
		start=0;
		int length=list.size();
		 end=length-1;
		while (start<=end) {
			int mid=(start+end)/2;
			if (list.get(mid)>key) {
				end=mid-1;
			}
			else if(list.get(mid)<key){
				start=mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	public static int test(String key) {
		return 2;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		
		Map<String, String> map=new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		int[] array=new int[10];
		map.forEach((x,y)->System.out.println(x+"...."+test(y)));
		//list.stream().filter((x)->x%2==0).forEach((x)->System.out.println(x+array[0]));
		//MidSearch search=new MidSearch();
		//System.out.println(search.midSearch(list,12));
	}
}

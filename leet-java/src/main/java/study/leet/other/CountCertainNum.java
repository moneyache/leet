package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class CountCertainNum {

	List<List<Integer>> allList;
	int mount;
	public CountCertainNum(int mount) {
		// TODO Auto-generated constructor stub
		allList=new ArrayList<>();
		this.mount=mount;
	}
	public List<List<Integer>> getList() {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(0);
		count(mount, list);
		return this.allList;
	}
	@SuppressWarnings("unchecked")
	private  void count(int current,ArrayList<Integer> list) {
		if (current<0) {
			return;
		}
		if (current==0) {
			this.allList.add(list);
			return;
		}
		if (list.isEmpty()) {
			list.add(0);
			System.out.println("bukenengn.............");
		}
		else {
			int last=list.get(list.size()-1);
			if (last<=1) {
				
				ArrayList<Integer> list1=(ArrayList<Integer>) list.clone();
				list1.add(1);
				count(current-1,list1);
			}
		    if (last<=5) {
				ArrayList<Integer> list1=(ArrayList<Integer>) list.clone();
				list1.add(5);
				count(current-5,list1);
			}
			 if (last<=10) {
				ArrayList<Integer> list1=(ArrayList<Integer>) list.clone();
				list1.add(10);
				count(current-10,list1);
			}
			 if (last<=25) {
				ArrayList<Integer> list1=(ArrayList<Integer>) list.clone();
				list1.add(25);
				count(current-25,list1);
			}
		}
	}
	public static void main(String[] args) {
		CountCertainNum certainNum=new CountCertainNum(10);
		List<List<Integer>> lists=certainNum.getList();
		for (List<Integer> list : lists) {
			System.out.println("new line");
			for (Integer integer : list) {
				System.out.println(integer);
			}
		}
	}
}

package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class ValidParenth {

	public  int n;
	public  List<String> list;
	public ValidParenth(int n) {
		// TODO Auto-generated constructor stub
		this.n=n;
		this.list=new ArrayList<>();
	}
	public List<String> getList() {
		getAllValidParenth(0, 0, "");
		return list;
	}
	public  void getAllValidParenth(int RigCount,int leftCount,String string) {
		if (RigCount>leftCount) {
			return;
		}
		if (RigCount<n) {
			String tempString1=string+")";
			int newRig=RigCount+1;
			if (newRig<=leftCount) {
				getAllValidParenth(newRig, leftCount, tempString1);
			}
		}
		if (leftCount<n) {
			String tempString2=string+"(";
			int newLeft=leftCount+1;
			getAllValidParenth(RigCount, newLeft, tempString2);
		}
		if ((RigCount==n)&&(leftCount==n)) {
			list.add(string);
		}
	}
	public static void main(String[] args) {
		ValidParenth validParenth=new ValidParenth(5);
		List<String> list=validParenth.getList();
		for (String string : list) {
			System.out.println(string+"\n");
		}
	}
}

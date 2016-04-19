package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class AllStr {

	public static List<char []> allStr(String string) {
		if (string.length()==0) {
			List<char[]> list=new ArrayList<>();
			list.add(new char[]{' '});
			return list;
		}
		char first=string.charAt(0);
		return insertChar(first, allStr(string.substring(1)));
	}
	public static List<char[]> insertChar(char a,List<char[]> chars) {
		int length=chars.get(0).length;
		if (length==0) {
			List<char[]> list=new ArrayList<>();
			list.add(new char[]{a});
			return list;
		}
		for (char[] cs : chars) {
			for (int i = 0; i <=length; i++) {
				char[] temp=new char[length+1];
				temp[i]=a;
				int j=0;
				while (j<=length) {
					if (j<i) {
						temp[j]=cs[j++];
					}
					else if(j==i){
						j++;
					}
					else {
						temp[j]=cs[j-1];
						j++;
					}
			}
				cs=temp;	
			}
		}
		return chars;
		}
	public static void main(String[] args) {
		String aString="si2on";
		List<char[]> list=allStr(aString);
		for (char[] cs : list) {
			for (char c : cs) {
				System.out.println(c);
			}
			
		}
	}
	}

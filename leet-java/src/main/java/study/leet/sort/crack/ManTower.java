package study.leet.sort.crack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ManTower {

	private Man[] mans1;
	private Man[] mans2;
	
 	public ManTower(Man[] mans) {
		// TODO Auto-generated constructor stub
 		this.mans1 = mans.clone();
 		Arrays.sort(mans1);
 		this.mans2 = mans1.clone();
 		Arrays.sort(mans1, (Man man1, Man man2) -> man1.weight>man2.weight ? 1:man1.weight==man2.weight?0:-1);
	}
 	public Man[] getResult() {
		return lCSMans(mans1.length-1, mans2.length-1, new Man[0]);
	}
	private Man[] getLongerMans(Man[] man1, Man[] man2) {
		
		return man1.length > man2.length ? man1 : man2;
	}
	private  Man[] lCSMans( int i, int j, Man[] result) {
		if (i <0 || j<0) {
			return result;
		}
		if (mans1[i].equals(mans2[j])) {
			int length = result.length;
			Man[] newResult = new Man[length+1];
			for (int k = 0; k < length; k++) {
				newResult[k] = result[k];
			}
			newResult[length] = mans1[i];
			return lCSMans(i-1, j-1, newResult.clone());
		}
		else {
			return getLongerMans(lCSMans(i-1, j, result.clone()), lCSMans(i, j-1, result.clone()));
		}
	}
	public static void main(String[] args) {
		Man man1 = new Man(12,2);
		Man man2 = new Man(13,4);
		Man man3 = new Man(14,7);
		Man man4 = new Man(15,1);
		Man man5 = new Man(16,9);
		Man man6 = new Man(17,10);
		Man[] array = {man1, man2, man3, man4, man5, man6 };
		ManTower tower = new ManTower(array);
		Man[] reMans = tower.getResult();
		for (Man man : reMans) {
			System.out.println("man:" + man.weight + ".." + man.height);
		}
 	}
}

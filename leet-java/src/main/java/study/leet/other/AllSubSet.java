package study.leet.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubSet {

	public static List<Set<Integer>> allSubSet(Set<Integer> originaSet) {
		List<Set<Integer>> sets=new ArrayList<Set<Integer>>();
		Set<Integer> newSet=new HashSet<>();
		sets.add(newSet);
		for (Integer integer : originaSet) {
			addElement(sets, integer);
		}
		return sets;
	}
	public static void addElement(List<Set<Integer>> sets,int element) {
		List<Set<Integer>> tempList=new ArrayList<>();
		for (Set<Integer> set : sets) {
			Set<Integer> tempSet=new HashSet<>();
			tempSet.addAll(set);
			tempSet.add(element);
			tempList.add(tempSet);
		}
		sets.addAll(tempList);
	}
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		List<Set<Integer>> list=allSubSet(set);
		for (Set<Integer> set2 : list) {
			System.out.println("new set:");
			for (Integer integer : set2) {
				System.out.println(integer+"   ");
			}
			System.out.println("\n");
		}
	}
}

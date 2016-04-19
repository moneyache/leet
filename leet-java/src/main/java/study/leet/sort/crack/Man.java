package study.leet.sort.crack;

import java.util.Arrays;

public class Man implements Comparable<Man>{

		public int weight;
		public int height;
		public Man(int weight,int height) {
			// TODO Auto-generated constructor stub
			this.weight=weight;
			this.height=height;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return (this.weight == ((Man)obj).weight) && (this.height == ((Man)obj).height);
		}

		@Override
		public int compareTo(Man o) {
			// TODO Auto-generated method stub
			int res;
			res = (this.height>o.height) ? 1:((this.height<o.height) ? -1:0);
			return res;
		}
		public static void main(String[] args) {
			Man[] arr = {};
			Integer[] arr1 = {};
			Man man = new Man(1, 2);
			Arrays.asList(arr1).add(1);
		}
}

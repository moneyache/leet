package study.leet.other;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {

	private List<ArrayList<Point>> allList;
	public EightQueen() {
		// TODO Auto-generated constructor stub
		this.allList=new ArrayList<>();
	}
	public List<ArrayList<Point>> getList() {
		setQueen(0, new ArrayList<Point>());
		return this.allList;
	}
	class Point{
		int x,y;
		public Point(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	public boolean isWrongPoint(Point other) {
			
			return ((this.x==other.x)|(this.y==other.y)|(Math.abs(this.y-other.y)==Math.abs(this.x-other.x)));
		}
	}
	private boolean checkList(ArrayList<Point> list) {
		int listLength = list.size();
		if (listLength<2) {
			return true;
		}
		Point lastPoint=list.get(listLength-1);
		for (int i = 0; i <= listLength-2; i++) {
			if (lastPoint.isWrongPoint(list.get(i))) {
				return false;
			}
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public void setQueen(int step,ArrayList<Point> list) {
		//int listLength = list.size();
		if (step >= 8) {
			if (checkList(list)) {
				this.allList.add(list);
			}
			return ;
		}
		if (step>=0&&step<=7) {
				if(checkList(list)){
					for (int i = 0; i < 8; i++) {
						Point ipoint=new Point(step, i);
						ArrayList<Point> iList=(ArrayList<Point>) list.clone();
						iList.add(ipoint);
						setQueen(step+1, iList);
				}
			}
			else {
				return;	
				}
		}
		
	}
	public void test() {
		if (true) {
			for (int i = 0; i < 10; i++) {
				if (i==5) {
					return;
				}
			}
			System.out.println("after return........");
		}
		
	}
	public static void main(String[] args) {
		EightQueen eightQueen=new EightQueen();
		//eightQueen.test();
		List<ArrayList<Point>> list=eightQueen.getList();
		for (ArrayList<Point> arrayList : list) {
			System.out.println("one plan.......................................");
			for (Point point : arrayList) {
				System.out.println("X:"+point.x+" Y:"+point.y);
			}
		}
	}
}

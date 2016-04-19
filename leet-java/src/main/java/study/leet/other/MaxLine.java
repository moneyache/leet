package study.leet.other;

import java.util.ArrayList;
import java.util.List;


public class MaxLine {

	  public static class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
	  public  class Line {
		  List<Point> points;
		  public Line(Point point1, Point point2) {
			// TODO Auto-generated constructor stub
			  points = new ArrayList<Point>();
			  points.add(point1);
			  points.add(point2);
		}
		  public boolean containsOnePoint(Point p) {
			return points.contains(p);
		}
		  public boolean addToLine(Point point3) {
			Point point1 = points.get(0);
			Point point2 = points.get(1);
			int left = (point3.x - point1.x) * (point2.y - point1.y);
			int right = (point3.y - point1.y) * (point2.x - point1.x);
			if (left == right) {
				points.add(point3);
				return true;
			}
			return false;
		}
		  public int  getSize() {
			return points.size();
		}
		  
	  }
	    public int maxPoints(Point[] points) {
	       int length = points.length;
	       List<Line> lines = new ArrayList<>();
	       for (int i = 0; i < length; i++) {
			Point pointI = points[i];
			List<Line> lineI = new ArrayList<>();
			for (int j = i + 1; j < length; j++) {
				Point pointJ = points[j];
				int sizeI = lineI.size();
				if (sizeI > 0) {
					for (int k = 0; k < sizeI; k ++) {
						if (lineI.get(k).addToLine(pointJ)) {
							continue;
						}
						lineI.add(new Line(pointI, pointJ));
					}
				}
				else if(!contains(lines, pointI, pointJ)){
					lineI.add(new Line(pointI, pointJ));
				}
			}
			lines.addAll(lineI);
		}
	       int max = 0;
	       for (Line line : lines) {
	    	   int size = line.getSize();
			if (size > max) {
				max = size;
			}
		}
	    	return max;
	}
	    private boolean contains(List<Line> lines, Point a, Point b) {
			for (Line line : lines) {
				if (line.containsOnePoint(a) && line.containsOnePoint(b)) {
					return true;
				}
			}
			return false;
		}
	    public static void main(String[] args) {
			MaxLine line = new MaxLine();
			Point[] points = {
					new Point(), new Point(0,1),
					new Point(0, 2),new Point(1, 0),
					new Point(1, 1),new Point(2, 2)
					};
			//Point[] points = {new Point()};
			System.out.println(line.maxPoints(points));
		}
}

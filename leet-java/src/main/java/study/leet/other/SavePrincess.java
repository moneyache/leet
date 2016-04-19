package study.leet.other;

import java.util.LinkedList;
import java.util.Queue;

public class SavePrincess {

	private char[][] maze;
	private Point princer;
	private int maxPace;
	public SavePrincess(char[][] maze, Point princerPoint, int maxPace) {
		// TODO Auto-generated constructor stub
		this.maze = maze;
		this.princer = princerPoint;
		this.maxPace = maxPace;
	}
	public static char[][] initMaze() {
		char[][] imaze = {
				{'p','*','.','.','.'},
				{'.','.','.','*','.'},
				{'.','.','.','*','.'},
				{'.','.','.','*','.'},
				{'.','.','.','*','.'},
				};
		return imaze;
	}
	public Queue<Point> save(int xNum, int yNum) {
		int pace = 0;
		Queue<Point> path = new LinkedList<Point>();
		path.offer(princer);
		maze[princer.getX()][princer.getY()] = '#';
		while (!path.isEmpty()) {
			Point curPlace = path.poll();
			Point[] adfPoints = adjPoints(curPlace);
			for (Point point : adfPoints) {
				int x = point.getX();
				int y = point.getY();
				if (x >= xNum) {
					continue;
				}
				if (y >= yNum) {
					continue;
				}
				char curChar = maze[x][y];
				switch (curChar) {
				case 'p':
					pace ++;
					path.clear();
					break;
				case '*':
					pace ++;
					
					break;
				case '.':
					pace ++;
					maze[x][y] = '#';
					path.offer(curPlace);
					break;
				case '#':
					pace ++;
					
					break;
				default:
					break;
				}
			}
		}
		return path;
	}
	private Point[] adjPoints(Point cur) {
		int x = cur.getX();
		int y = cur.getY();
		Point[] points = {
				new Point(x, y + 1),
				new Point(x, y - 1),
				new Point(x + 1, y),
				new Point(x - 1, y)
				
		};
		return points;
	}
}

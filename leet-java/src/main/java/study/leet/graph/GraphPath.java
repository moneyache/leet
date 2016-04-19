package study.leet.graph;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GraphPath<E> {

	private GraphMatrix<E> graph;
	private Set<Integer> unSettleNodes;
	private Set<Integer> settleNodes;
	private int sourceNode;
	private Map<Integer, Integer> paths;
	public GraphPath(GraphMatrix<E> graphMatrix, int sourceNum) {
		// TODO Auto-generated constructor stub
		this.graph = graphMatrix;
		int nodeNum = graphMatrix.getNodeNum();
		this.sourceNode = sourceNum;
		
		this.unSettleNodes = new HashSet<>();
		for (int i = 0; i < nodeNum; i++) {
			if (i == sourceNode) {
				continue;
			}
			unSettleNodes.add(i);
		}
		//init setted set
		this.settleNodes = new HashSet<>();
		settleNodes.add(sourceNode);
		//init paths map
		this.paths = new HashMap<Integer,Integer>();
		//paths.put(sourceNode, 0);
	}
	public Map<Integer, Integer> getPaths() {
		dijkstra();
		return paths;
	}
	private void dijkstra() {
		while (!unSettleNodes.isEmpty()) {
			int minNde = sourceNode;
			int minPath = Integer.MAX_VALUE;
			for (int unsetNode : unSettleNodes) {
				int temp = minDistance(sourceNode, unsetNode);
				if (temp < minPath) {
					minPath = temp;
					minNde = unsetNode;
				}
			}
			paths.put(minNde, minPath);
			settleNodes.add(minNde);
			unSettleNodes.remove(minNde);
		}
	}
	private int dirDistance(int source, int j){
		int value = graph.getAdjMatrix()[source][j];
		if( value== 0){
			return Integer.MAX_VALUE;
		}
		return value;
		
	}
	private int dirDistance(int source, int mid, int j){
		if (!settleNodes.contains(mid) || !settleNodes.contains(source)) {
			throw new IllegalArgumentException();
		}
		int value1 = paths.get(mid);
		int value2 = dirDistance(mid, j);
		if ((value1 == Integer.MAX_VALUE) || (value2 == Integer.MAX_VALUE)) {
			return Integer.MAX_VALUE;
		}
		return value1 + value2;
	}
	private int minDistance(int source, int j){
		int minDistance = Integer.MAX_VALUE;
		for (int setNode : settleNodes) {
			int tempDistance;
			if (setNode == source) {
				tempDistance = dirDistance(source, j);
			}
			else {
				tempDistance = dirDistance(source, setNode, j);
			}
			if (tempDistance < minDistance) {
				minDistance = tempDistance;
			}
		}
		return minDistance;
		
	}
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class<GraphNode> class1 = GraphNode.class;
		int nodeNum = 5;
		@SuppressWarnings("unchecked")
		GraphNode<Integer>[] nodes =(GraphNode<Integer>[]) Array.newInstance(class1, nodeNum);
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new GraphNode<Integer>(i, "node" + i);
		}
		int[][] adjMatrix = new int[nodeNum][nodeNum];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (i == j) {
					continue;
				}
				adjMatrix[i][j] = new Random().nextInt(3);
				System.out.println("i:"+i+"j:"+j+"value:"+adjMatrix[i][j]);
			}
		}
		GraphMatrix<Integer> graph = new GraphMatrix<>(nodes, adjMatrix, 1);
		GraphPath<Integer> path = new GraphPath<>(graph, 2);
		Map<Integer, Integer> paths = path.getPaths();
		paths.forEach((key, value) -> System.out.println("key:"+key+" v:"+value));
	}
}

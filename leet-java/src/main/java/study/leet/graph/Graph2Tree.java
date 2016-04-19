package study.leet.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph2Tree {

	private GraphMatrix<Integer> sourceGraph;
	//private GraphMatrix<Integer> tree;
	public Graph2Tree(GraphMatrix<Integer> sourceGraph) {
		// TODO Auto-generated constructor stub
		this.sourceGraph = sourceGraph;
		prim(1);
	}
	public GraphMatrix<Integer> prim(int sourceNode) {
		GraphNode<Integer>[] sourceNodes = sourceGraph.getNodes();
		int[][] sourceMatrix = sourceGraph.getAdjMatrix();
		
		int sourceNodeNum = sourceGraph.getNodeNum();
		int[][] newMatrix = new int[sourceNodeNum][sourceNodeNum];
		List<Integer> unsetList = new ArrayList<Integer>();
		for (int i = 0; i < sourceNodeNum; i++) {
			if (i == sourceNode) {
				continue;
			}
			unsetList.add(i);
		}
		List<Integer> setList = new ArrayList<>();
		setList.add(sourceNode);
		while (!unsetList.isEmpty()) {
			int minWeight = Integer.MAX_VALUE;
			int oriNode = sourceNode;
			int newSetNode = sourceNode;
			for (Integer integer : setList) {
				int min = getMinNear(integer, sourceMatrix, unsetList);
				if (min == -1) {
					continue;
				}
				int tempWeight = sourceMatrix[integer][min];
				if (minWeight > tempWeight) {
					minWeight = tempWeight;
					newSetNode = min;
					oriNode = integer;
				}
			}
			newMatrix[oriNode][newSetNode] = minWeight;
			unsetList.remove(Integer.valueOf(newSetNode));
			setList.add(newSetNode);
		}
		GraphMatrix<Integer> newGraphMatrix = new GraphMatrix<>(sourceNodes, newMatrix, 1);
		return newGraphMatrix;
	}
	private int getMinNear(int source, int[][] sourceMatrix,List<Integer> unsetList) {
		int[] sourceArray = sourceMatrix[source];
		int minWeight = Integer.MAX_VALUE;
		int minNode = -1;
		int count = 0;
		for (int i : sourceArray) {
			if (i == 0) {
				count ++;
				continue;
			}
			else if ((unsetList.contains(count)) && (i < minWeight)) {
				minWeight = i;
				minNode = count;
			}
			count ++;
		}
		return minNode;
	}
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class<GraphNode> class1 = GraphNode.class;
		int nodeNums = 4;
		@SuppressWarnings("unchecked")
		GraphNode<Integer>[] nodes =(GraphNode<Integer>[]) Array.newInstance(class1, nodeNums);
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new GraphNode<Integer>(i, "node" + i);
		}
		int[][] adjMatrix = new int[nodeNums][nodeNums];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (i == j) {
					continue;
				}
				adjMatrix[i][j] = new Random().nextInt(5);
				System.out.println("i:"+i+"j:"+j+"value:"+adjMatrix[i][j]);
			}
		}
		GraphMatrix<Integer> graph = new GraphMatrix<>(nodes, adjMatrix, 0);
		Graph2Tree graph2Tree = new Graph2Tree(graph);
		GraphMatrix<Integer> treeGraphMatrix = graph2Tree.prim(0);
		
		for (int[] is : treeGraphMatrix.getAdjMatrix()) {
			for (int i : is) {
				System.out.println(i);
			}
		}
	}
}

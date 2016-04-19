package study.leet.graph;

import java.lang.reflect.Array;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class GraphTrav<E> {

	public void BFSTrav(GraphMatrix<E> graph) {
		int nodeNum = graph.getNodeNum();
		boolean[] isVisited = new boolean[nodeNum];
		for (int i = 0; i < nodeNum; i++) {
			if (!isVisited[i]) {
				bfsVertex(graph, i, isVisited);
			}
		}
	}
	public void DFSTrav(GraphMatrix<E> graph) {
		int nodeNum = graph.getNodeNum();
		boolean[] isVisited = new boolean[nodeNum];
		for (int i = 0; i < nodeNum; i++) {
			if (!isVisited[i]) {
				dfsVertex(graph, i, isVisited);
			}
		}
	}
	private void dfsVertex(GraphMatrix<E> matrix, int vertex, boolean[] isVisited) {
		GraphNode<E>[] nodes = matrix.getNodes();
		int[][] adjMatrix = matrix.getAdjMatrix();
			GraphNode<E> current = nodes[vertex];
			isVisited[vertex] = true;
			current.visitNode();
			for (int i = 0; i < nodes.length; i++) {
				if (i == vertex) {
					continue;
				}
				if ((!isVisited[i]) && (adjMatrix[vertex][i] !=0)) {
					dfsVertex(matrix, i, isVisited);
				}
			}
	}
	//
	private void bfsVertex(GraphMatrix<E> matrix, int vertex, boolean[] isVisited) {
		GraphNode<E>[] nodes = matrix.getNodes();
		int[][] adjMatrix = matrix.getAdjMatrix();
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		while (!queue.isEmpty()) {
			int temp = queue.remove();
			GraphNode<E> current = nodes[temp];
			isVisited[temp] = true;
			current.visitNode();
			for (int i = 0; i < nodes.length; i++) {
				if (i == temp) {
					continue;
				}
				if ((!isVisited[i]) && (adjMatrix[temp][i] !=0)) {
					queue.add(i);
					isVisited[i] = true;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class<GraphNode> class1 = GraphNode.class;
		@SuppressWarnings("unchecked")
		GraphNode<Integer>[] nodes =(GraphNode<Integer>[]) Array.newInstance(class1, 10);
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new GraphNode<Integer>(i, "node" + i);
		}
		int[][] adjMatrix = new int[10][10];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix.length; j++) {
				if (i == j) {
					continue;
				}
				adjMatrix[i][j] = new Random().nextInt(2);
				System.out.println("i:"+i+"j:"+j+"value:"+adjMatrix[i][j]);
			}
		}
		GraphMatrix<Integer> graph = new GraphMatrix<>(nodes, adjMatrix, 0);
		GraphTrav<Integer> graphTrav = new GraphTrav<>();
		graphTrav.DFSTrav(graph);
	}
	
}

package study.leet.graph;

public class GraphMatrix<E> {

	private GraphNode<E>[] nodes;
	private int[][] adjMatrix;
	private int nodeNum;
	private int graphType;
	public GraphMatrix(GraphNode<E>[] nodes, int[][] adjMatrix, int graphType) {
		// TODO Auto-generated constructor stub
		this.setNodeNum(nodes.length);
		this.setAdjMatrix(adjMatrix);
		this.setGraphType(graphType);
		this.setNodes(nodes);
	}
	public GraphNode<E>[] getNodes() {
		return nodes;
	}
	public void setNodes(GraphNode<E>[] nodes) {
		this.nodes = nodes;
	}
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}
	public int getNodeNum() {
		return nodeNum;
	}
	public void setNodeNum(int nodeNum) {
		this.nodeNum = nodeNum;
	}
	public int getGraphType() {
		return graphType;
	}
	public void setGraphType(int graphType) {
		this.graphType = graphType;
	}
	
}

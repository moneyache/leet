package study.leet.graph;

public class GraphEdge<E> {

	public GraphNode<E> startNode;
	public GraphNode<E> endNode;
	public GraphEdge(GraphNode<E> startNode,GraphNode<E> endNode) {
		this.startNode=startNode;
		this.endNode=endNode;
	}
}

package study.leet.graph;


public class GraphNode <E>{

	private E data;
	private String name;
	public GraphNode(E data, String name) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.setName(name);
	}
	public E getData() {
		return this.data;
	}
    public void visitNode() {
		System.out.println("this is the node" + this.name +"isVisited");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

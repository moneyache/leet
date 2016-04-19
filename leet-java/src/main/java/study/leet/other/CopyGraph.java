package study.leet.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CopyGraph {
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		List<UndirectedGraphNode> neighbors = node.neighbors;
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		if (neighbors == null) {
			return copy;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> record = new HashMap<>();
		record.put(node, copy);
		Queue<UndirectedGraphNode> bfs = new LinkedList<>();
		bfs.add(node);
		while (!bfs.isEmpty()) {
			UndirectedGraphNode cur = bfs.remove();
			UndirectedGraphNode curCopy = record.get(cur);
			if (curCopy == null) {
				curCopy = new UndirectedGraphNode(cur.label);
				record.put(cur, curCopy);
			}
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				bfs.add(neighbor);
				UndirectedGraphNode neighborCopy = record.get(neighbor);
				if (neighborCopy == null) {
					neighborCopy = new UndirectedGraphNode(neighbor.label);
					record.put(neighbor, neighborCopy);
				}
				curCopy.neighbors.add(neighborCopy);
			}
			
		}
		return copy;
	}
	public static void main(String[] args) {
		CopyGraph copyGraph = new CopyGraph();
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		UndirectedGraphNode copyGraphNode = copyGraph.cloneGraph(node);
		System.out.println(copyGraphNode.neighbors.size());
	}
}

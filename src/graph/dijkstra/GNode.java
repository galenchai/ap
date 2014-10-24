package graph.dijkstra;


import java.util.HashMap;
import java.util.Map;

public class GNode {

	private String name;
	
	private Map<GNode, Integer> child = new HashMap<GNode, Integer>();
	
	public GNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<GNode, Integer> getChild() {
		return child;
	}

	public void setChild(Map<GNode, Integer> child) {
		this.child = child;
	}
	
}

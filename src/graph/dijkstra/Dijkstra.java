package graph.dijkstra;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

	Set<GNode> open = new HashSet<GNode>();
	Set<GNode> close = new HashSet<GNode>();
	Map<String, Integer> path = new HashMap<String, Integer>(); // path distance
	Map<String, String> pathInfo = new HashMap<String, String>(); // path information

	public GNode init() {
		path.put("B", 1);
		pathInfo.put("B", "A->B");
		path.put("C", 1);
		pathInfo.put("C", "A->C");
		path.put("D", 4);
		pathInfo.put("D", "A->D");
		path.put("E", Integer.MAX_VALUE);
		pathInfo.put("E", "A");
		path.put("F", 2);
		pathInfo.put("F", "A->F");
		path.put("G", 5);
		pathInfo.put("G", "A->G");
		path.put("H", Integer.MAX_VALUE);
		pathInfo.put("H", "A");
		GNode start = new GMapBuilder().build(open, close);
		return start;
	}

	public void computePath(GNode start) {
		GNode nearest = getShortestPath(start);
		if (nearest == null) {
			return;
		}
		close.add(nearest);
		open.remove(nearest);
		Map<GNode, Integer> childs = nearest.getChild();
		for (GNode child : childs.keySet()) {
			if (open.contains(child)) {
				Integer newCompute = path.get(nearest.getName()) + childs.get(child);
				if (path.get(child.getName()) > newCompute) {
					path.put(child.getName(), newCompute);
					pathInfo.put(child.getName(), pathInfo.get(nearest.getName()) + "->" + child.getName());
				}
			}
			computePath(start); // repeat myself
			computePath(nearest); // recursive outter
		}
	}

	public void printPathInfo() {
		Set<Map.Entry<String, String>> pathInfos = pathInfo.entrySet();
		for (Map.Entry<String, String> pathInfo : pathInfos) {
			System.out.println(pathInfo.getKey() + " : " + pathInfo.getValue());
		}
	}

	private GNode getShortestPath(GNode node) {
		GNode res = null;
		int minDis = Integer.MAX_VALUE;
		Map<GNode, Integer> childs = node.getChild();
		for (GNode child : childs.keySet()) {
			if (open.contains(child)) {
				int distance = childs.get(child);
				if (distance < minDis) {
					minDis = distance;
					res = child;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Dijkstra test = new Dijkstra();
		GNode start = test.init();
		test.computePath(start);
		test.printPathInfo();
	}

}

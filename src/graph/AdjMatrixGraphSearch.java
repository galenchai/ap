package graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

@SuppressWarnings("all")
public class AdjMatrixGraphSearch {

	private int vertexNum;
	private Vector[] vector;
	private int[] visited;
	private Stack stack;
	private Stack result;
	private Queue queue;
	public AdjMatrixGraphSearch() {};

	public AdjMatrixGraphSearch(int num) {
		vertexNum = num;
		vector = new Vector[vertexNum];
		visited = new int[vertexNum];
		for (int t : visited) t = 0;
		stack = new Stack();
		result = new Stack();
		queue = new PriorityQueue();
	}
	/**
	 * add undirected edge
	 * @param I a vertex of the edge
	 * @param J another vertex of the edge
	 * @return is added successful
	 */
	public boolean addEdge(int I, int J) {
		if (J == I) { //check if user has typed in a vertex instead of edge, if yes return false
			return false;
		}
		//check the vertex is within all the vertex, if no, return false
		if (I < vertexNum && J < vertexNum && I >= 0 && J >= 0) {
			if (I > J) { //exchange I & J
				int k = I; I = J; J = k; 
			}
			if (isEdgeExists(I, J)) {
				return false;
			}
			vector[I].add(J);
			return true;
		}
		return false;
	}

	public boolean isEdgeExists(int i, int j) {
		if (i < vertexNum && j < vertexNum && i >= 0 && j >= 0) {
			if (i == j) return false;
			if (i > j) { //exchange i & j
				int k = i; i = j; j = k; 
			}
			if (vector[i] == null) vector[i] = new Vector(8);
			for (int q = 0; q < vector[i].size(); q++) {
				if (((Integer) vector[i].get(q)).intValue() == j) {
					System.out.println("Vertex" + i + " and " + " vertex " + j + " exist edge");
					return true;
				}
			}
		}
		return false;
	}

	public void dfs() {
		visited[0] = 1;
		stack.push(0);
		//if stack is not null, loop search
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex((Integer) stack.peek());
			//search for adj vertex that hasn't been visited, pop up it from stack, mark it as visited
			if (v == -1) {
				result.push(stack.peek());
				stack.pop();
			} else {
				visited[v] = 1;
				stack.push(v);

			}
		}
		System.out.println("Depth First Search: ");
		// result.list();
	}

	public void bsf() {
		visited[0] = 1;
		queue.add(0);
		while (!queue.isEmpty()) {
			int v = (Integer) queue.poll();
			result.push(v);
			int i;
			while ((i = getAdjUnvisitedVertex(v)) != -1) {
				visited[i] = 1;
				queue.add(i);
			}
		}
		System.out.println("Breadth First Search: ");
		// result.list();
	}

	public int getAdjUnvisitedVertex(int v) {
		int temp;
		//check if adj vertext is null
		if (vector[v] != null) {
			//over all the adj vertexs
			for (int j = 0; j < vector[v].size(); j++) {
				temp = ((Integer) vector[v].get(j)).intValue();
				//check if adj vertext has been visited
				if (visited[temp] == 0)
					return ((Integer) vector[v].get(j)).intValue();
			}
		}
		return -1;
	}

	public Stack getResult() {
		return result;
	}
}
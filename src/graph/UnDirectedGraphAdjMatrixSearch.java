package graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Undirected graph
 * @author hcl130
 *
 */
public class UnDirectedGraphAdjMatrixSearch {
	
	public final static int[][] GRAPH_MATRIX = new int[][]{
	  // 0  1  2  3  4  5
		{0, 0, 1, 0, 1, 1},//0
		{0, 0, 1, 0, 1, 0},//1
		{1, 1, 0, 1, 0, 0},//2
		{0, 0, 1, 0, 0, 5},//3
		{1, 1, 0, 0, 0, 0},//4
		{1, 0, 0, 0, 0, 0} //5
	};
	
	public Set<Integer> visited = new HashSet<Integer>();
	
	public Stack<Integer> STACK_DFS = new Stack<Integer>();
	
	public List<Integer> RESULT = new ArrayList<Integer>();
	
	public Queue<Integer> QUEUE_BFS = new PriorityQueue<Integer>();
	
	public void dfsWithoutRecursive() {
		visited.add(Integer.valueOf(0));
		STACK_DFS.push(Integer.valueOf(0));
		while (!STACK_DFS.isEmpty()) {
			int nextVertex = getUnvisitedAdjVertex(STACK_DFS.peek());
			if (-1 != nextVertex) {
				visited.add(Integer.valueOf(nextVertex));
				STACK_DFS.push(Integer.valueOf(nextVertex));
			} else {
				RESULT.add(STACK_DFS.pop());
			}
		}
	}
	
	public void bfsWithoutRecursive() {
		visited.add(Integer.valueOf(0));
		QUEUE_BFS.add(Integer.valueOf(0));
		while (!QUEUE_BFS.isEmpty()) {
			
		}
	}
	
	private int getUnvisitedAdjVertex(int vertex) {
		for (int i = 0; i < GRAPH_MATRIX.length; i ++) {
			if (1 == GRAPH_MATRIX[vertex][i]) {
				if (!visited.contains(Integer.valueOf(i))) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		UnDirectedGraphAdjMatrixSearch g = new UnDirectedGraphAdjMatrixSearch();
		g.dfsWithoutRecursive();
		for (Integer i : g.RESULT) {
			System.out.print(i + ", ");
		}
	}

}


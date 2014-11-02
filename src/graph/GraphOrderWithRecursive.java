package graph;
import java.util.HashSet;
import java.util.Set;


public class GraphOrderWithRecursive {
	
	public final static int[][] GRAPH = new int[][]{
		{0, 1, 0, 1, 0, 0},
		{1, 0, 1, 0, 0, 0},
		{0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0},
		{0, 0, 0, 1, 0, 0},
		{0, 0, 1, 0, 0, 0}
	};
	
	/**
	 * depth first search
	 * @param matrix
	 */
	public void dfs(int[][] matrix, Set<Integer> visited, int vertex) {
		int unvisitedVertex = getUnvisitedVertex(visited, matrix[vertex]);
		while (-1 != getUnvisitedVertex(visited, matrix[vertex])) {
			System.out.print("->" + unvisitedVertex);
			visited.add(unvisitedVertex);
			dfs(matrix, visited, unvisitedVertex);
		}
	}
	
	protected int getUnvisitedVertex(Set<Integer> visited, int[] array) {
		for (int i = 0; i < array.length; i ++) {
			if (array[i] == 1 && !visited.contains(i)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * breadth first search
	 * @param matrix
	 */
	public void bfs(int[][] matrix) {
		
	}
	
	public static void main(String[] args) {
		GraphOrderWithRecursive g = new GraphOrderWithRecursive();
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		g.dfs(GRAPH, set, 0);
	}

}

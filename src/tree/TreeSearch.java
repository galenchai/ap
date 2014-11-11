package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1 dfsRecursive
 * 2 bfsRecursive TODO not sure if can be implemented by recursive
 * 3 dfsNonRecursive
 * 4 bfsNonRecursive
 * @author hcl130
 *
 */
public class TreeSearch {
	
	public void dfsRecursive(TreeNode node) {
		if (null == node) return;
		System.out.print(node.getValue() + ", ");
		dfsRecursive(node.getLeftChild());
		dfsRecursive(node.getRightChild());
	}
	
	public void bfsRecursive(TreeNode node) {
	}
	
	public void dfsNonRecursive(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			if (null == treeNode) continue;
			System.out.print(treeNode.getValue() + ", ");
			stack.push(treeNode.getRightChild());
			stack.push(treeNode.getLeftChild());
		}
	}
	
	public void bfsNonRecursive(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			if (null == treeNode) continue;
			System.out.print(treeNode.getValue() + ", ");
			queue.add(treeNode.getLeftChild());
			queue.add(treeNode.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		/**
		 *         A
		 *        / \
		 *       B   C
		 *      / \  /
		 *     E  G H
		 */
		TreeNode treeNodeE = new TreeNode("E", null, null);
		TreeNode treeNodeG = new TreeNode("G", null, null);
		TreeNode treeNodeH = new TreeNode("H", null, null);
		TreeNode treeNodeB = new TreeNode("B", treeNodeE, treeNodeG);
		TreeNode treeNodeC = new TreeNode("C", treeNodeH, null);
		TreeNode treeNodeA = new TreeNode("H", treeNodeB, treeNodeC);
		TreeSearch ts = new TreeSearch();
		ts.dfsRecursive(treeNodeA);
		System.out.println();
		ts.dfsNonRecursive(treeNodeA);
		System.out.println();
		ts.bfsNonRecursive(treeNodeA);
	}
	
}

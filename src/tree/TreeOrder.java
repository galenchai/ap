package tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * four order method for a binary tree
 * @author Vinson
 *
 */
public class TreeOrder {

	/**
	 * preOrder means read parent node first, and then left child and right child
	 * time complexity is O(n)
	 * @param root
	 */
	public void preOrder(Node root) {
		if (null == root) return;
		System.out.print(root.getValue() + ", ");
		preOrder(root.getLeftChild());
		preOrder(root.getRightChild());
	}
	
	/**
	 * read left node first, and then parent and right child
	 * time complexity is O(n)
	 * @param root
	 */
	public void inOrder(Node root) {
		if (null == root) return;
		inOrder(root.getLeftChild());
		System.out.print(root.getValue() + ", ");
		inOrder(root.getRightChild());
	}
	
	/**
	 * read left node first, and then right child node and parent
	 * time complexity is O(n)
	 * @param root
	 */
	public void postOrder(Node root) {
		if (null == root) return;
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		System.out.print(root.getValue() + ", ");
	}
	
	/**
	 * print node level by level
	 * time complexity is O(n) 
	 * The space complexity is the largest number of all the levels, the best is O(1) and the worst is O((n+1)/2))
	 * @param root
	 */
	public void levelOrder(Node root) {
		//TODO difference between queues
		Queue<Node> q = new ArrayBlockingQueue<Node>(10);
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.getValue() + ", ");
			if (null != n.getLeftChild()) q.add(n.getLeftChild());
			if (null != n.getRightChild()) q.add(n.getRightChild());
		}
	}
	
	/**
	 *               A
	 *              / \
	 *             D   C
	 *            / \   \
	 *           F   B   G
	 * 
	 */
	public Node genTestData() {
		Node f = new Node();
		f.setValue("F");
		Node b = new Node();
		b.setValue("B");
		Node g = new Node();
		g.setValue("G");
		
		Node d = new Node();
		d.setValue("D");
		d.setLeftChild(f);
		d.setRightChild(b);
		
		Node c = new Node();
		c.setValue("C");
		c.setRightChild(g);
		
		Node a = new Node();
		a.setValue("A");
		a.setLeftChild(d);
		a.setRightChild(c);
		
		return a;
	}
	
	public static void main(String args[]) {
		TreeOrder to = new TreeOrder();
		to.preOrder(to.genTestData());
		System.out.println();
		to.inOrder(to.genTestData());
		System.out.println();
		to.postOrder(to.genTestData());
		System.out.println();
		to.levelOrder(to.genTestData());
	}
	
}

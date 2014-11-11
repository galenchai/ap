package tree;


/**
 * three order method for a binary tree
 * @author Vinson
 *
 */
public class TreeOrder {

	/**
	 * preOrder means read parent node first, and then left child and right child
	 * time complexity is O(n)
	 * @param root
	 */
	public void preOrder(TreeNode root) {
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
	public void inOrder(TreeNode root) {
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
	public void postOrder(TreeNode root) {
		if (null == root) return;
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		System.out.print(root.getValue() + ", ");
	}
	
	public TreeNode genTestData() {
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
		
		return treeNodeA;
	}
	
	public static void main(String args[]) {
		TreeOrder to = new TreeOrder();
		to.preOrder(to.genTestData());
		System.out.println();
		to.inOrder(to.genTestData());
		System.out.println();
		to.postOrder(to.genTestData());
	}
	
}

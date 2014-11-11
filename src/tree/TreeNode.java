package tree;

public class TreeNode {
	
	private String value;
	
	private TreeNode leftChild;
	
	private TreeNode rightChild;
	
	public TreeNode() {}
	
	public TreeNode(String value, TreeNode leftChild, TreeNode rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}

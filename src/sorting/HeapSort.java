package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap actually is a binary tree which the value of parent node is less than children's value 
 * Time complexity is O(nlogn) and space complexity is O(1)
 * @author Vinson
 *
 */
public class HeapSort {
	
	/**
	 * Always add to the last
	 * @param heap
	 * @param node
	 */
	public void addNode(List<Integer> heap, Integer node) {
		heap.add(node);
		int c = heap.size() - 1, p = (c - 1) / 2;
		while (p >= 0) {
			if (heap.get(p) <= node) break;
			heap.set(c, heap.get(p));
			c = p;
			p = (p - 1) / 2;
		}
		heap.set(c, node);
	}
	
	public void downMaxNode(List<Integer> heap, int start, int size) {
		Integer top = heap.get(start);
		int p = start, c = 2 * p + 1;
		while (c < size) {
			if (c + 1 < size && heap.get(c + 1) < heap.get(c)) c++;
			if (heap.get(c) > top) break;
			heap.set(p, heap.get(c));
			p = c;
			c = 2 * p + 1;
		}
		heap.set(p, top);
	}
	
	/**
	 * Always delete root node and add the last to it 
	 * @param heap
	 */
	public void deleteNode(List<Integer> heap) {
		Integer top = heap.get(heap.size() - 1);
		heap.set(0, top);
		heap.remove(heap.size() - 1);
		downMaxNode(heap, 0, heap.size() - 1);
	}
	
	public void initHeap(List<Integer> tree, int size) {
		for (int i = size/2 - 1; i >= 0; i --) {
			downMaxNode(tree, i, size);
		}
	}
	
	public void heapSort(List<Integer> heap) {
		Integer swap = null;
		for (int i = heap.size() - 1; i > 0; i --) {
			initHeap(heap, i + 1);
			swap = heap.get(0);
			heap.set(0, heap.get(i));
			heap.set(i, swap);
		}
	}
	
	public static void main(String[] args) {
		/**
		 *         1
		 *        / \
		 *       2   3
		 *      / \  /
		 *     5  7 8
		 */
		List<Integer> heap = new ArrayList<Integer>();
		//{1, 2, 3, 5, 7, 8}
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(5);
		heap.add(7);
		heap.add(8);
		List<Integer> nonHeap = new ArrayList<Integer>();
		nonHeap.add(8);
		nonHeap.add(3);
		nonHeap.add(2);
		nonHeap.add(7);
		nonHeap.add(5);
		nonHeap.add(1);
		HeapSort ts = new HeapSort();
		//ts.addNode(tree, 2);
//		ts.deleteNode(tree);
//		ts.initTree(nonTree, nonTree.size());
		ts.heapSort(nonHeap);
		for (Integer i : nonHeap) {
			System.out.print(i + ", ");
		}
	}

}

package sorting;

public class QuickSort {
	
	/**
	 * the best time complexity is nlogn, the worst time complexity is n2
	 * the space complexity is nlogn
	 * @param array
	 * @param left
	 * @param right
	 */
	public void quick(int[] array, int left, int right) {
		if (left < right) {
			int i = left, j = right, x = array[left];
			while (i < j) {
				while (i < j && array[j] >= x) j --;
				if (i < j) array[i++] = array[j];
				while(i < j && array[i] < x) i ++;
				if (i < j) array[j--] = array[i];
			}
			array[i] = x;
			quick(array, left, i - 1);
			quick(array, i + 1, right);
		}
	}
	
	public static void main(String args[]) {
		int[] array = new int[] {3, 9, 21, 7, 5, 6, 1, 13, 98, 32};
		QuickSort qs = new QuickSort();
		qs.quick(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}
	
	

}

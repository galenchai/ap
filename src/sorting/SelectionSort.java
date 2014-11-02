package sorting;

public class SelectionSort {
	
	/**
	 * Time complexity is O(n^2) and space complexity is O(1)
	 * @param array
	 */
	public void selectionSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i ++) {
			for (int j = i + 1; j < array.length; j ++) {
				if (array[j] < array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3, 9, 21, 7, 5, 6, 1, 13, 98, 32};
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}

}

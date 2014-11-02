package sorting;

public class BubbleSort {
	
	/**
	 * Time complexity is O(n2), space complexity is O(1)
	 * @param array
	 */
	public void bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i ++) {
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public void enhancedBubbleSort(int[] array) {
		int temp, count;
		for (int i = 0; i < array.length; i ++) {
			count = 0;
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					count ++;
				}
			}
			if (count == 0) break;
		}
	}
	
	public static void main(String args[]) {
		int[] array = new int[] {39, 21, 39, 2, 17, 8, 19, 33,7};
		BubbleSort bs = new BubbleSort();
		//bs.bubbleSort(array);
		bs.enhancedBubbleSort(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}

}

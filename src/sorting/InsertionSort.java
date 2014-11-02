package sorting;

public class InsertionSort {
	
	/**
	 * Time complexity is O(n^2) and space complexity is O(1)
	 * @param array
	 */
	public void insertionSort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i ++) {
			if (array[i] < array[i - 1]) {
				int j;
				temp = array[i];
				for (j = i - 2; j >=0; j --) {
					if (array[j] < array[i]) {
						j ++;
						break;
					}
				}
				for (int k = i; k > j; k --) {
					array[k] = array[k - 1];
				}
				array[j] = temp;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {39, 21, 39, 2, 17, 8, 19, 33,7};
		InsertionSort is = new InsertionSort();
		is.insertionSort(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}

}

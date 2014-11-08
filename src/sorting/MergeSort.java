package sorting;

public class MergeSort {
	
	public void mergeSort(int[] array, int left, int right, int[] result) {
		if (left >= right) return;
		int center = (right + left) / 2;
		mergeSort(array, left, center, result);
		mergeSort(array, center + 1, right, result);
		merge(array, left, center, right, result);
	}
	
	protected void merge(int[] array, int left, int center, int right, int[] result) {
		int i = left, j = center + 1, r = 0;
		while (i <= center && j <= right) {
			if (array[i] < array[j]) {
				result[r++] = array[i++];
			} else {
				result[r++] = array[j++];
			}
		}
		while (i <= center) {
			result[r++] = array[i++];
		}
		while (j <= right) {
			result[r++] = array[j++];
		}
		for (int x = 0; x < r; x ++) {
			array[left + x] = result[x];
		}
	}
	
	public static void main(String args[]) {
		int[] array = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19, 2, 21};
		MergeSort ms = new MergeSort();
		int[] result = new int[array.length];
		ms.mergeSort(array, 0, array.length - 1, result);
		for (int r : array) {
			System.out.print(r + ", ");
		}
	}

}

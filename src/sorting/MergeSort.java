package sorting;

public class MergeSort {
	
	public void mergeSort(int array[], int left, int right) {
		if (left >= right) {
			return;
		}
		int center = array.length / 2;
		mergeSort(array, left, center);
		mergeSort(array, center + 1, right);
		merge(array, left, center, right);
	}
	
	public void merge(int array[], int left, int center, int right) {
		
	}
	
	public static void main(String args[]) {
		int[] array = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19, 2, 21};
		MergeSort ms = new MergeSort();
		ms.mergeSort(array, 0, array.length);
	}

}

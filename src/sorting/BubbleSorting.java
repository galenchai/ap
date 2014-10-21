package sorting;

import java.util.HashMap;
import java.util.Map;


public class BubbleSorting {
	
	
	public final static int[] SORT_ARRAY = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19, 2, 21};
	
	public final static String[][] SCORE_ARRAY = new String[][]{{"John", "3"}, {"Smith", "7"}, {"Turn", "9"}, {"Tay", "2"}, {"Allen", "3"}, {"Joe", "8"}};
	
	public final static int[] FIBONACCI_ARRAY = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
	
	public static void printArray(int[] array, boolean printArray) {
		if (printArray) {
			for (int i : array) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}
	}
	
	public static void printArray(int[] array, int length) {
			for (int i = 0; i < length; i ++) {
				System.out.print(array[i] + ", ");
			}
			System.out.println("");
	}
	
	/**
	 * Original bubble sorting
	 * The worst time complexity: O(n^2)
	 * @param array
	 */
	public static void bubbleSorting(int[] array, boolean printArray) {
		long start = System.currentTimeMillis();
		int temp;
		for (int i = 0; i < array.length; i ++) {
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("ButtleSorting time elapsed: " + (end - start));
	}
	
	/**
	 * The sorting has been finished if no data exchange occurs
	 * The best time complexity: O(1), the worst: O(n^2)
	 * @param array
	 */
	public static void bubbleSortingEnhanced(int[] array, boolean printArray) {
		long start = System.currentTimeMillis();
		int temp, count;
		for (int i = 0; i < array.length; i ++) {
			count = 0;
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					count ++;
				}
			}
			if (count == 0) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("ButtleSortingEnhanced time elapsed: " + (end - start));
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void bubbleSortingPartialSeq(int[] array, boolean printArray) {
		
	}
	
	public static int fibonacci(int seq, Map map) {
		if (map.containsKey(seq)) {
			return (Integer) map.get(seq);
		}
		int value = fibonacci(seq - 1, map) + fibonacci(seq - 2, map);
		map.put(seq, value);
		return value;
	}
	
	/**
	 * Classic dynamic programming algorithm:
	 * Compute the sub questions and merge them
	 * @param seq
	 * @return
	 */
	public static int optFib(int seq) {
		Map map = new HashMap();
		map.put(0, 1);
		map.put(1, 1);
		return fibonacci(seq, map);
	}
	
	public static void insertionSorting(int[] array, boolean printArray) {
		long start = System.currentTimeMillis();
		int i, j, k, temp;
		for (i = 1; i < array.length; i ++) {
			for (j = i - 1; j >= 0; j --) {
				if (array[j] < array[i]) {
					break;
				}
			}
			temp = array[i];
			for (k = i - 1; k > j ; k --) {
				array[k + 1] = array[k];
			}
			array[k + 1] = temp;
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("InsertionSorting time elapsed: " + (end - start));
	}
	
	public static void mergeSorting(int[] array, boolean printArray) {
		long start = System.currentTimeMillis();
		mergeSortInner(array, 0, array.length - 1); 
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("MergeSorting time elapsed: " + (end - start));
	}
  
    private static void mergeSortInner(int[] data, int left, int right) {  
        if (left >= right)  
            return;  
        int center = (left + right) / 2;  
        mergeSortInner(data, left, center);  
        mergeSortInner(data, center + 1, right);  
        merge(data, left, center, right);  
    }  
  
    private static void merge(int[] data, int left, int center, int right) {  
        int[] tmpArr = new int[data.length];  
        int mid = center + 1;  
        int third = left;  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    }  
	
	public static void compareCmmonValues(int[] array1, int[] array2, boolean printArray) {
		long start = System.currentTimeMillis();
		int array[] = new int[array1.length < array2.length ? array1.length : array2.length];
		int count = 0;
		for (int i : array1) {
			for (int j : array2) {
				if (i == j) {
					array[count ++] = i;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("CommonValues time elapsed: " + (end - start));
	}
	
	public static void compareCommonValuesWithSorting(int[] array1, int[] array2) {
		long start = System.currentTimeMillis();
		int array[] = new int[array1.length < array2.length ? array1.length : array2.length];
		int i = 0, j = 0, r = 0;
		mergeSortInner(array1, 0, array1.length - 1);
		mergeSortInner(array2, 0, array2.length - 1);
		printArray(array1, true);
		printArray(array2, true);
		for (; i < array1.length; i ++) {
			for (; j < array2.length; ) {
				if (array1[i] == array2[j]) {
					array[r ++] = array1[i ++];
					j ++;
				} else if (array1[i] > array2[j]) {
					j ++;
				} else {
					break;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, r);
		System.out.println("CommonValuesWithSorting time elapsed: " + (end - start));
	}
	
	/**
	 * {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19, 2, 21}
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSorting(int array[], int left, int right) {
		if (left < right) {
			int i = left, j = right, x = array[left];
			while (i < j) {
				while (i < j && array[j] >= x) { j--; }
				if (i < j) { array[i++] = array[j]; }
				while (i < j && array[i] < x) { i++; }
				if (i < j) { array[j--] = array[i]; }
				printArray(array, true);
			}
			array[i] = x;
			quickSorting(array, left, i - 1);
			quickSorting(array, i + 1, right);
		}
	}
	
	public static void quickSortWithTimeElapse(int array[], boolean printArray) {
		long start = System.currentTimeMillis();
		quickSorting(array, 0, array.length - 1);
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("quickSorting time elapsed: " + (end - start));
	}
	
	public static void sortScore(String array[][], int left, int right) {
		if (left < right) {
			int i = left, j = right;
			String[] x = array[left];
			while (i < j) {
				while (i < j && ((array[j][1].compareTo(x[1])) > 0 || (array[j][1].compareTo(x[1]) == 0 && array[j][0].compareTo(x[0]) <= 0))) {
					j --;
				}
				if (i < j) {
					array[i] = array[j];
					i ++;
				}
				while (i < j && ((array[i][1].compareTo(x[1]) < 0 || (array[i][1].compareTo(x[1]) == 0 && array[i][0].compareTo(x[0])>= 0)))) {
					i ++;
				}
				if (i < j) {
					array[j] = array[i];
					j --;
				}
			}
			array[i] = x;
			sortScore(array, left, i -1);
			sortScore(array, i + 1, right);
		}
	}
	
	/*
	 * Backtracking algorithm:
	 * Try and if not satisfied then go back and try another way 
	 */
	public static void queen() {
		
	}
	
	private boolean queenCheck(int row, int column) {
		if (1 == row) {
			return true;
		}
		int i, j;
		for (i = 0; i < row - 1; i ++) {
			
		}
		return false;
	}
	
	/**
	 * Greedy algorithm:
	 * Get the best solution for each sub question and merge them
	 */
	public static void change(int[] changeVals, int sum) { //the array needs to be sorted
		int k = changeVals.length;
		int[] num = new int[k];
		for (int i = 0; i < k; i ++) {
			num[i] = sum/changeVals[i];
			sum = sum % changeVals[i];
		}
		for (int i = 0; i < num.length; i ++) {
			System.out.println(num[i]);
		}
	}
	
	public static void main(String args[]) {
//		bubbleSorting(Data.SORT_TEST_ARRAY, false);
//		bubbleSortingEnhanced(Data.SORT_TEST_ARRAY, false);
//		insertionSorting(Data.SORT_TEST_ARRAY, false);
//		mergeSorting(Data.SORT_TEST_ARRAY, false);
//		quickSortWithTimeElapse(SORT_ARRAY, true);
		//compareCommonValuesWithSorting(SORT_ARRAY, FIBONACCI_ARRAY);
		//System.out.println("Fibonacci, input: 11: result: " + fibonacci(11));
//		sortScore(SCORE_ARRAY, 0, SCORE_ARRAY.length - 1);
//		for (int i = SCORE_ARRAY.length - 1; i >= 0; i --) {
//			System.out.println(SCORE_ARRAY[i][0] + " : " + SCORE_ARRAY[i][1]);
//		}
		change(new int[]{25, 10, 5, 1}, 99);
	}
	
	
	
}
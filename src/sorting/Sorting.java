package sorting;

public class Sorting {
	
	public final static int[] SORT_ARRAY = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19, 2, 21};
	
	public final static String[][] SCORE_ARRAY = new String[][]{{"John", "3"}, {"Smith", "7"}, {"Turn", "9"}, {"Tay", "2"}, {"Allen", "3"}, {"Joe", "8"}};
	
	public static void printArray(int[] array, boolean printArray) {
		if (printArray) {
			for (int i : array) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}
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
	}
	
	
}
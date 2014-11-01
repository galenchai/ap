package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Give a bunch of array, return the elements existed at least two arrays
 * 
 * @author Vinson
 * 
 */
public class CommonValuesOfArrays {

	public static Integer[] ARRAY_A = new Integer[] {1, 3, 9, 5, 8, 7, 18};
	
	public static Integer[] ARRAY_B = new Integer[] {2, 24, 36, 5, 9, 2, 1};
	
	public static Integer[] ARRAY_C = new Integer[] {3, 1, 15, 8, 9, 20, 118};
	
	/**
	 * Time complexity is O(m*n), m & n are the count of parameter arrays and the count of element within the arrays   
	 * @param args
	 * @return
	 */
	public Map<Integer, Integer> getCommonValues(Integer[]... args) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer> ();
		Map<Integer, Boolean> tempMap = new HashMap<Integer, Boolean>();
		for (Integer[] array : args) {
			for (Integer element : array) {
				if (null == tempMap.get(element)) {
					if (null != resultMap.get(element)) {
						resultMap.put(element, resultMap.get(element) + 1);
					} else {
						resultMap.put(element, 1);
					}
					tempMap.put(element, true);
				}
			}
			tempMap.clear();
		}
		return resultMap;
	}
	
	public static void main(String args[]) {
		CommonValuesOfArrays cv = new CommonValuesOfArrays();
		Map<Integer, Integer> resultMap = cv.getCommonValues(ARRAY_A, ARRAY_B, ARRAY_C);
		for (Integer number : resultMap.keySet()) {
			Integer value = resultMap.get(number);
			if (value > 1) {
				System.out.print(number + ", ");
			}
		}
	}
	
}

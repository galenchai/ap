package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic programming
 * compute the sub question and reuse the result
 * @author Vinson
 *
 */
public class Fibonacci {
	
	public final static int[] FIBONACCI_ARRAY = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
	
	public int fibonacci(int seq) {
		if (0 == seq || 1 == seq) {
			return 1;
		} else {
			return fibonacci(seq - 1) + fibonacci(seq - 2);
		}
	}
	
	public int enhancedFibonacci(int seq, Map<Integer, Integer> map) {
		if (null != map.get(seq)) {
			return map.get(seq);
		}
		if (0 == seq || 1 == seq) {
			map.put(0, 1);
			map.put(1, 1);
			return 1;
		} else {
			int r = enhancedFibonacci(seq - 1, map) + enhancedFibonacci(seq - 2, map);
			map.put(seq, r);
			return r;
		}
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(7));
		System.out.println(f.enhancedFibonacci(7, new HashMap<Integer, Integer>()));
	}

}

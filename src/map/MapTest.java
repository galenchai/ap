package map;

import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	
	/**
	 * Insertion time complexity of TreeMap is logn
	 * Delete time complexity of TreeMap is 
	 * Searching time complexity of TreeMap is logn
	 */
	public void testTreeMap() {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("23455", "23455");
		map.put("abcde", "abcde");
		map.put("13927", "13927");
		map.put("ade", "ade");
		map.put("339", "339");
		map.put("ADf", "ADf");
		for (String str : map.keySet()) {
			System.out.print(map.get(str) + ", ");
		}
	}
	
	public static void main(String args[]) {
		MapTest mt = new MapTest();
		mt.testTreeMap();
	}

}

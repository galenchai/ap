package ipsorting;

/**
 * Use Quick Sort to solve this problem
 * @author Vinson
 *
 */
public class IpSorting {
	
	public static String[] ARRAY_IP = new String[]{
			"114.215.148.187",
			"137.25.53.23",
			"61.2.5.33",
			"166.5.62.1",
			"138.223.21.111",
			"138.223.21.111",
			"138.223.21.78",
			"138.223.21.39",
			"138.22.31.111",
			"147.29.21.121"
	};
	
	/**
	 * Time complixity is 4n + nlogn + 3n
	 * @param ARRAY_IP
	 * @return
	 */
	public String[] sort(String[] ARRAY_IP) {
		long[] arr = convertStringArrToLongArr(ARRAY_IP);
		quickSort(arr, 0, arr.length - 1);
		return convertlongArrToStringArr(arr);
	}
	
	/**
	 * time complexity is nlongn
	 * @param arr
	 * @param left
	 * @param right
	 */
	public void quickSort(long[] arr, int left, int right) {
		if (left < right) {
			int l = left, r = right;
			long x = arr[left];
			while (l < r) {
				while (l < r && arr[r] >= x) r --;
				if (l < r) arr[l ++] = arr[r];
				while (l < r && arr[l] <= x) l ++;
				if (l < r) arr[r --] = arr[l];
			}
			arr[l] = x;
			quickSort(arr, left, l - 1);
			quickSort(arr, l + 1, right);
		}
		
		
	}
	
	/**
	 * time complexity 3n
	 * @param longArr
	 * @return
	 */
	private String[] convertlongArrToStringArr(long[] longArr) {
		String[] strArr = new String[longArr.length];
		String tempStr = "";
		int len = 0, i = 0;
		String[] element = new String[4];
		for (long l : longArr) {
			tempStr = String.valueOf(l);
			len = tempStr.length();
			if (12 == len) {
				element[0] = tempStr.substring(0, 3);
				element[1] = tempStr.substring(3, 6);
				element[2] = tempStr.substring(6, 9);
				element[3] = tempStr.substring(9, 12);
			} else if (11 == len) {
				element[0] = tempStr.substring(0, 2);
				element[1] = tempStr.substring(2, 5);
				element[2] = tempStr.substring(5, 8);
				element[3] = tempStr.substring(8, 11);
			} else if (10 == len) {
				element[0] = tempStr.substring(0, 1);
				element[1] = tempStr.substring(1, 4);
				element[2] = tempStr.substring(4, 7);
				element[3] = tempStr.substring(7, 10);
			}
			strArr[i ++] = element[0].concat(".").
					concat(element[1]).concat(".").
					concat(element[2]).concat(".").
					concat(element[3]);
		}
		return strArr;
	}
	
	/**
	 * time complexity is 4n
	 * @param strArr
	 * @return
	 */
	private long[] convertStringArrToLongArr(String[] strArr) {
		long[] longArr = new long[strArr.length];
		String tempStr = "";
		int i = 0;
		for (String str : strArr) {
			for (String s : str.split("\\.")) {
				tempStr = tempStr.concat(addZero(s, 3 - s.length()));
			}
			longArr[i ++] = Long.valueOf(tempStr);
			tempStr = "";
		}
		return longArr;
	}
	
	private String addZero(String str, int count) {
		for (int i = 0; i < count; i ++) {
			str = "0".concat(str);
		}
		return str;
	}
	
	public static void main(String[] args) {
		IpSorting ipSorting = new IpSorting();
		String[] result = ipSorting.sort(ARRAY_IP);
		for (String str : result) {
			System.out.println(str + ", ");
		}
	}

}

package array;

public class Change {

	/**
	 * Greedy algorithm:
	 * Get the best solution for each sub question and merge them
	 */
	public void change(int[] changeVals, int sum) { //the array needs to be sorted
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
	
	public static void main(String[] args) {
		int[] changes = new int[]{25, 10, 5, 1};
		Change c = new Change();
		c.change(changes, 99);
	}
	
}

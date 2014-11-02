package graph;

/**
 * Backtracking
 * @author Vinson
 *
 */
public class EightQueen {
	
	private static int[][] past = new int[8][8];
	
	private static int num = 0;

	/**
	 * @param row starts from 0;
	 * @param column starts from 0
	 * @param past row:column
	 * @return
	 */
	private static boolean check(int row, int column) {
		if (0 == row) {
			return true;
		}
		for (int i = 0; i < row; i ++) { //check the same column
			if (past[i][column] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = column - 1; (i >=0)&&(j >= 0); i --, j --) { //from left top to right bottom
			if (past[i][j] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = column + 1; (i >= 0)&&(j < 8); i --, j ++) { //from right top to left bottom
			if (past[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void queen(int row) {
		for (int j = 0; j < 8; j ++) {
			past[row][j] = 1;
			if (check(row, j)) {
				if (7 == row) {
					print();
				} else {
					queen(row + 1);
				}
			}
			past[row][j] = 0;
		}
	}
	
	public static void print() {
		System.out.println("This is the " + (num ++) + " answer!");
//		if (num >= 92) {
//			System.exit(1);
//		}
		for (int[] i : past) {
			for (int j : i) {
				System.out.print(j + ", ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String args[]) {
		queen(0);
	}
	
}

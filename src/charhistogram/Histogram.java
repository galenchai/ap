package charhistogram;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Histogram {
	private static int max = 0;
	private static Map<Character, Integer> histogram = new HashMap<Character, Integer>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			for (int i = 97; i <= 122; i++) {
				this.put((char) i, 0);
			}
		}
	};

	public static void readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		char key;

		while ((line = reader.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				key = Character.toLowerCase(line.charAt(i));
				if (histogram.containsKey(key)) {
					histogram.put(key, histogram.get(key) + 1);
					if (histogram.get(key) > max) {
						max = histogram.get(key);
					}
				}
			}
		}
		reader.close();
	}

	public static void main(String[] args) {
		try {
			readFile("d:/test.txt");
			for (int i = 97; i <= 122; i++) {
				for (int j = 0; j < ((histogram.get((char) i) / max) * 80); j++) {
					System.out.print("*");
				}
				System.out.println((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
import java.util.HashMap;
import java.util.Map;

public class Day08 {
	
	public static final int WIDTH = 25;
	public static final int HEIGHT = 6;
	
	public static Map<Integer,int[][]> layers = new HashMap<>();
	
	
	static {
		String fileName = "Input\\Input_Day08.txt";

		String rawInput = FileIO.getFileAsString(fileName);
		
		int p = 0;
		int layerNum = 0;
		while(p < rawInput.length()) {
			int[][] layer = new int[HEIGHT][WIDTH];
			for(int row = 0; row < HEIGHT; row++) {
				for(int col = 0; col < WIDTH; col++) {
					layer[row][col] = Integer.parseInt(rawInput.substring(p, p+1));
					p++;
				}
			}
			layers.put(layerNum, layer);
			layerNum++;
		}
	}
	
	
	public static int part01() {
		int[][] data = new int[layers.size()][3];
		int min = Integer.MAX_VALUE;
		int minLayer = 0;
		for(int i= 0; i < layers.size(); i++) {
			int[][] l = layers.get(i);
			for(int row = 0; row < l.length; row++) {
				for(int col = 0; col < l[row].length; col++) {
					data[i][l[row][col]] += 1;
				}
			}
			if (min > data[i][0]) {
				min = data[i][0];
				minLayer = i;
			}
		}
		return data[minLayer][1] * data[minLayer][2];
	}
	
	public static String part02() {
		char[][] image = new char[HEIGHT][WIDTH];
		for(int row = 0; row < image.length; row++) {
			for(int col = 0; col < image[row].length; col++) {
				image[row][col] = ' ';
			}
		}
		for(int i=layers.size()-1; i >= 0; i--) {
			int[][] l = layers.get(i);
			for(int row = 0; row < l.length; row++) {
				for(int col = 0; col < l[row].length; col++) {
					switch(l[row][col]) {
					case 0: 
						image[row][col] = ' ';
						break;
					case 1:
						image[row][col] = '█';
						break;
				    default:
				    	break;
					}
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for(int row = 0; row < image.length; row++) {
			for(int col = 0; col < image[row].length; col++) {
				result.append(image[row][col]);
			}
			result.append("\n");
		}
		
		return result.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.printf("Part 1 result: %d%n", part01());
		System.out.printf("Part 2 result%n%n%s%n" , part02());
	}
	
	
	
}

import java.util.ArrayList;
import java.util.List;

public class Day01 {

	public static List<Integer> data = new ArrayList<>();

	static {
		String fileName = "Input\\Input_Day01.txt";

		List<String> rawInput = FileIO.getFileAsList(fileName);
		for (String s : rawInput) {
			data.add(Integer.parseInt(s));
		}
	}

	public static int calcFuel(int mass) {
		return (mass / 3) - 2;
	}

	public static int part01(List<Integer> data) {
		int result = 0;
		for (int mass : data) {
			result += calcFuel(mass);
		}

		return result;
	}

	public static int part02(List<Integer> data) {
		int result = 0;
		for (int mass : data) {
			while (mass > 0) {
				mass = Math.max(calcFuel(mass), 0);
				result += mass;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.printf("Part 1 result: %d%n", part01(data));
		System.out.printf("Part 2 result: %d%n", part02(data));

	}

}

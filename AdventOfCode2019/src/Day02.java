import java.util.List;

public class Day02 {

	static int[] data;
	
	static {
		String fileName = "Input\\Input_Day02.txt";

		String rawData = FileIO.getFileAsString(fileName);
		String[] rawArray = rawData.split(",");
		data = new int[rawArray.length];
		System.out.println(rawArray.length);
		for(int i = 0; i < rawArray.length; i++) {
			data[i] = Integer.parseInt(rawArray[i]);
		}
	}
	
	public static int compute(int[] data, int reg1, int reg2) {
		int[] myData = new int[data.length];
		for(int i=0; i < data.length; i++) {
			myData[i] = data[i];
		}
		myData[1] = reg1;
		myData[2] = reg2;
		int ip = 0;
		int op = myData[ip];
		while (op != 99) {
			switch(op) {
			case 1: 
				myData[myData[ip + 3]] = myData[myData[ip + 1]] + myData[myData[ip + 2]];
				break;
			case 2:
				myData[myData[ip + 3]] = myData[myData[ip + 1]] * myData[myData[ip + 2]];
				break;
			default:
				System.err.print("Something went seriously wrong!");
				break;
			}
			ip+=4;
			op = myData[ip];
		}
		return myData[0];
	}
	
	
	public static int part01(int[] data) {
		return compute(data, 12, 2);
	}
	
	public static int part02(int[] data) {
		for(int x = 0; x < 100; x++) {
			for(int y = 0; y < 100; y++) {
				if(compute(data, x,y) == 19690720) {
					return 100 * x + y;
				}
			}
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Part 1 result: %d%n", part01(data));
		System.out.printf("Part 2 result: %d%n", part02(data));

	}

}

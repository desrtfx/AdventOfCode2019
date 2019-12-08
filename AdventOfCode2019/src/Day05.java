 
public class Day05 {
    static int[] data;
 
    static {
        String fileName = "Input\\Input_Day05.txt";
 
        String rawData = FileIO.getFileAsString(fileName);
        String[] rawArray = rawData.split(",");
        data = new int[rawArray.length];
        System.out.println(rawArray.length);
        for (int i = 0; i < rawArray.length; i++) {
            data[i] = Integer.parseInt(rawArray[i]);
        }
    }
 
    public static int compute(int[] data, int input) {
        int[] myData = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            myData[i] = data[i];
        }
        int ip = 0;
        int opMode = myData[ip];
        while (opMode != 99) {
            int op = opMode % 100; // lowest two digits
            opMode = opMode / 100;
            int modeP1 = opMode % 10; // 0 positional, 1 direct
            opMode = opMode / 10;
            int modeP2 = opMode % 10;
            switch (op) {
            case 1: // add
                myData[myData[ip + 3]] = myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1]
                        + myData[(modeP2 == 0) ? myData[ip + 2] : ip + 2];
                ip += 4;
                break;
            case 2: // mul
                myData[myData[ip + 3]] = myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1]
                        * myData[(modeP2 == 0) ? myData[ip + 2] : ip + 2];
                ip += 4;
                break;
            case 3: // input
                myData[myData[ip + 1]] = input; // Data input
                ip += 2;
                break;
            case 4: // output
                System.out.println(myData[myData[ip + 1]]); // data output
                ip += 2;
                break;
            case 5: // JT
                if (myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1] != 0) {
                    ip = myData[(modeP2 == 0) ? myData[ip + 2] : ip + 2];
                } else {
                    ip += 3;
                }
                break;
            case 6: // JF
                if (myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1] == 0) {
                    ip = myData[(modeP2 == 0) ? myData[ip + 2] : ip + 2];
                } else {
                    ip += 3;
                }
                break;
            case 7: // LT
                if (myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1] < myData[(modeP2 == 0) ? myData[ip + 2] : ip + 2]) {
                    myData[myData[ip + 3]] = 1;
                } else {
                    myData[myData[ip + 3]] = 0;
                }
                ip += 4;
                break;
            case 8: // EQ
                if (myData[(modeP1 == 0) ? myData[ip + 1] : ip + 1] == myData[(modeP2 == 0) ? myData[ip + 2]
                        : ip + 2]) {
                    myData[myData[ip + 3]] = 1;
                } else {
                    myData[myData[ip + 3]] = 0;
                }
                ip += 4;
                break;
            default:
                System.err.print("Something went seriously wrong!");
                break;
            }
            opMode = myData[ip];
        }
        return myData[0];
    }
 
    public static int part01(int[] data) {
        return compute(data, 1);
    }
 
    public static int part02(int[] data) {
        return compute(data, 5);
    }
 
    public static void main(String[] args) {
        System.out.printf("Part 1 result: %d%n", part01(data));
 
        System.out.printf("Part 2 result: %d%n", part02(data));
 
    }
}
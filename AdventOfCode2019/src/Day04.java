import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Day04 {
 
    public static final int INPUT_MIN = 256310;
    public static final int INPUT_MAX = 732736;
    public static List<char[]> validPwds = new ArrayList<>();
 
    public static boolean hasDouble(char[] pwd) {
        for (int i = 0; i < pwd.length - 1; i++) {
            if (pwd[i] == pwd[i + 1]) {
                return true;
            }
        }
        return false;
    }
 
    public static boolean isAscending(char[] pwd) {
        for (int i = 0; i < pwd.length - 1; i++) {
            if (pwd[i] > pwd[i + 1]) {
                return false;
            }
        }
        return true;
    }
 
    public static boolean notInLargerGroup(char[] pwd) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < pwd.length - 1; i++) {
            if (pwd[i] == pwd[i + 1]) {
                chars.put(pwd[i], chars.getOrDefault(pwd[i], 1) + 1);
            }
        }
        for (int count : chars.values()) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
 
    public static int part01() {
        int count = 0;
        for (int i = INPUT_MIN; i <= INPUT_MAX; i++) {
            char[] pwd = (String.valueOf(i)).toCharArray();
            if (hasDouble(pwd) && isAscending(pwd)) {
                count++;
                validPwds.add(pwd);
            }
        }
        return count;
    }
 
    public static int part02() {
        int count = 0;
        for (char[] pwd : validPwds) {
            if (notInLargerGroup(pwd)) {
                count++;
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.printf("Part 1: number of passwords is: %d%n", part01());
        System.out.printf("Part 2: number of passwords is: %d%n", part02());
    }
 
}
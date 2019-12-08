import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Day03 {
 
    public static final String FILENAME = "Input\\Input_Day03.txt";
    public static Map<Point, Integer> ptsWire1;
    public static Map<Point, Integer> ptsWire2;
    public static Map<Character, Point> directions = new HashMap<>();
    public static int minSteps = Integer.MAX_VALUE;
 
    static {
        directions.put('R', new Point(1, 0));
        directions.put('L', new Point(-1, 0));
        directions.put('U', new Point(0, 1));
        directions.put('D', new Point(0, -1));
 
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(FILENAME));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
 
        String[] wire1 = lines.get(0).split(",");
        String[] wire2 = lines.get(1).split(",");
        ptsWire1 = processWire(wire1);
        ptsWire2 = processWire(wire2);
    }
 
    public static Map<Point, Integer> processWire(String[] wire) {
        Map<Point, Integer> pts = new HashMap<>();
        int x = 1;
        int y = 1;
        int steps = 0;
        for (String s : wire) {
            char direction = s.charAt(0);
            int dist = Integer.parseInt(s.substring(1));
            Point offset = directions.get(direction);
            for (int i = 0; i < dist; i++) {
                x += offset.x;
                y += offset.y;
                steps++;
                pts.putIfAbsent(new Point(x, y), steps);
            }
        }
        return pts;
    }
 
    public static int part01() {
        Map<Point, Integer> intersections = new HashMap<>();
 
        for (Point p : ptsWire2.keySet()) {
            if (ptsWire1.containsKey(p)) {
                intersections.put(p, (Math.abs(p.x) + Math.abs(p.y)));
                if (minSteps > ptsWire1.get(p) + ptsWire2.get(p)) {
                    minSteps = ptsWire1.get(p) + ptsWire2.get(p);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : intersections.values()) {
            if (min > i) {
                min = i;
            }
        }
 
        return min;
    }
 
    public static void main(String[] args) {
        System.out.printf("Part 1 distance: %d%n", part01());
        System.out.printf("Part 2 steps: %d%n", minSteps);
    }
}
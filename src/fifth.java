
import java.util.*;

public class fifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int len = sc.nextInt();
            ArrayList<Integer> road = new ArrayList<>();
            road.add(u);
            road.add(v);
            road.add(len);
            roads.add(road);
        }
        int maxDeletedRoads = findMaxDeletedRoads(n, m, roads);
        System.out.println(maxDeletedRoads);
    }

    public static int findMaxDeletedRoads(int n, int m, ArrayList<ArrayList<Integer>> roads) {
        int maxLen = 0;
        for (ArrayList<Integer> road : roads) {
            maxLen = Math.max(maxLen, road.get(2));
        }
        int left = 0;
        int right = maxLen;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDeleteRoads(n, m, roads, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static boolean canDeleteRoads(int n, int m, ArrayList<ArrayList<Integer>> roads, int x) {
        ArrayList<Integer> parent = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parent.set(i, i);
        }
        for (ArrayList<Integer> road : roads) {
            if (road.get(2) > x) {
                int u = road.get(0) - 1;
                int v = road.get(1) - 1;
                int parentU = find(parent, u);
                int parentV = find(parent, v);
                if (parentU != parentV) {
                    parent.set(parentU, parentV);
                }
            }
        }
        int numStates = 0;
        for (int i = 0; i < n; i++) {
            if (parent.get(i) == i) {
                numStates++;
            }
        }
        return numStates == 1;
    }

    private static int find(ArrayList<Integer> parent, int x) {
        if (parent.get(x) != x) {
            parent.set(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }
}

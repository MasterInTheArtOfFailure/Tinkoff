import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Pair>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Pair> insert = new ArrayList<>(1);
            insert.add(new Pair(i + 1));
            groups.add(insert);
        }
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (findSecond(x, y, groups)) {
                } else {
                int indexMax = Math.max(x, y) - 1;
                int indexMin = Math.min(x, y) - 1;
                for (Pair pair:groups.get(indexMax)) {
                    pair.groupsBeen++;
                }
                groups.get(indexMin).addAll(groups.get(indexMax));
                groups.remove(indexMax);}
            } else if (type == 2) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                findSecond(x, y, groups);
            }
            else {
                int x = sc.nextInt();
                findThird(x, groups);
            }
        }
    }

    public static boolean findSecond (int x, int y, ArrayList<ArrayList<Pair>> groups) {
        for (ArrayList<Pair> list : groups) {
            boolean flagY = false;
            boolean flagX = false;
            for (Pair pair : list) {
                if (pair.value == x) {
                    flagX = true;
                }
                if (pair.value == y) {
                    flagY = true;
                }
                if (flagY && flagX) {
                    System.out.println("YES");
                    return true;
                }
            }
        }
        System.out.println("NO");
        return false;
    }
    public static void findThird(int x, ArrayList<ArrayList<Pair>> groups) {
        for (ArrayList<Pair> list : groups) {
            for (Pair pair: list) {
                if (pair.value == x) {
                    System.out.println(pair.groupsBeen);
                }
            }
        }
    }

    public static class Pair {
        public int value;
        public int groupsBeen;

        public Pair(int value) {
            this.value = value;
            this.groupsBeen = 1;
        }
    }
}

/*
7 13
2 3 1
3 3
1 2 4
2 1 1
3 4
2 3 4
1 3 4
3 4
1 7 3
1 1 3
3 7
3 1
2 7 4

NO
1
YES
2
NO
3
3
2
YES
 */

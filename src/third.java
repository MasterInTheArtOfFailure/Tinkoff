
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class third {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer size = Integer.parseInt(br.readLine());

        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list1.add(Integer.parseInt(line1[i]));
            list2.add(Integer.parseInt(line2[i]));
        }

        int start = -1;
        int end = -1;

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                start = i;
                break;
            }
        }

        for (int i = list1.size() - 1; i >= 0; i--) {
            if (!list1.get(i).equals(list2.get(i))) {
                end = i;
                break;
            }
        }

        Collections.sort(list1.subList(start, end + 1));

        if (list1.equals(list2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

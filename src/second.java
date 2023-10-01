
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("s", 0);
        map.put("h", 0);
        map.put("e", 0);
        map.put("r", 0);
        map.put("i", 0);
        map.put("f", 0);

        String[] line = br.readLine().split("");
        for (String curr : line) {
            if (curr.equals("s")) {
                map.put("s", map.get("s") + 1);
            }
            else if (curr.equals("h")) {
                map.put("h", map.get("h") + 1);
            }
            else if (curr.equals("e")) {
                map.put("e", map.get("e") + 1);
            }
            else if (curr.equals("r")) {
                map.put("r", map.get("r") + 1);
            }
            else if (curr.equals("i")) {
                map.put("i", map.get("i") + 1);
            }
            else if (curr.equals("f")) {
                map.put("f", map.get("f") + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (String literal: map.keySet()) {
            int curr;
            if (literal.equals("f")) {
                curr = map.get(literal) / 2;
            } else {
                curr = map.get(literal);
            }
            ans = Math.min(ans, curr);
        }
        System.out.println(ans);
    }
}


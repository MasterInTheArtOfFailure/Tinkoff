
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class first {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int revAmount = Integer.parseInt(firstLine[0]);
        int dollars = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");

        int currMaxPrice = 0;
        int ansIndex = -1;

        for (int i = 0; i < revAmount; i++) {
            int curr = Integer.parseInt(secondLine[i]);
            if (curr > dollars) {
                continue;
            }
            if (curr > currMaxPrice) {
                currMaxPrice = curr;
                ansIndex = i;
            }
        }
        if (ansIndex != -1) {
            System.out.println(secondLine[ansIndex]);
        } else {
            System.out.println("0");
        }

    }
}


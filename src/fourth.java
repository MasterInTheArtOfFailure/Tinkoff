
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class fourth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int targetSum = Integer.parseInt(line1[0]);
        int amount = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        ArrayList<Integer> coins = new ArrayList<>();
        for (String s : line2) {
            coins.add(Integer.parseInt(s));
        }

        Map<Integer, Integer> coinMap = new HashMap<>();
        for (int coin : coins) {
            coinMap.put(coin, amount);
        }
        List<Integer> usedCoins = new ArrayList<>();
        boolean found = collectCoins(targetSum, coins, coinMap, usedCoins);
        if (found) {
            System.out.println(usedCoins.size());
            usedCoins.forEach(coin -> System.out.print(coin + " "));
        } else {
                System.out.println("-1");
        }
    }

    private static boolean collectCoins(int targetSum, ArrayList<Integer> coins, Map<Integer, Integer> coinMap, List<Integer> usedCoins) {
        if (targetSum == 0) {
            return true;
        }
        for (int coin : coins) {
            if (coinMap.get(coin) > 0 && targetSum >= coin) {
                coinMap.put(coin, coinMap.get(coin) - 1);
                usedCoins.add(coin);
                if (collectCoins(targetSum - coin, coins, coinMap, usedCoins)) {
                    return true;
                }
                usedCoins.remove(usedCoins.size() - 1);
                coinMap.put(coin, coinMap.get(coin) + 1);
            }
        }
        return false;
    }
}


// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1 << 30;

        
        int[][] dp = new int[n][k + 2];

        
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        
        for (int i = 0; i <= k + 1; i++) {
            dp[src][i] = 0;
        }

        
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (dp[from][i - 1] != INF) {
                    dp[to][i] = Math.min(dp[to][i], dp[from][i - 1] + price);
                }
            }
        }

        
        int result = INF;
        for (int i = 1; i <= k + 1; i++) {
            result = Math.min(result, dp[dst][i]);
        }

        
        return (result == INF) ? -1 : result;
    }
}

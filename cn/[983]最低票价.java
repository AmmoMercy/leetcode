import java.util.Arrays;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            if (i < 7) {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], costs[1]), costs[2]);
            } else if (i < 30) {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], dp[i - 7] + costs[1]), costs[2]);
            } else {
                dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], dp[i - 7] + costs[1]), dp[i - 30] + costs[2]);
            }
        }
        return dp[n];
    }
}
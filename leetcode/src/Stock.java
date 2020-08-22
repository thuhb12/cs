import sun.applet.AppletResourceLoader;

/*
121
 */
public class Stock {
    public int maxProfit_121(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = prices[prices.length-1];
        int profit = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            profit = Math.max(profit, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return profit;
    }

    public int maxProfit_122(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int a = 0;
        int b = -prices[0];
        int c;
        int d;
        for (int i = 1; i < prices.length; i++) {
            c = Math.max(a, b + prices[i]);
            d = Math.max(b, a-prices[i]);
            a = c;
            b = d;
        }
        return a;
    }

    public int maxProfit_309(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        dp[1][0] = -prices[0];
        dp[0][1] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int j = 1; j < prices.length; j++) {
            dp[0][j] = Math.max(dp[0][j-2], dp[1][j-1]+prices[j]);
            dp[1][j] = Math.max(dp[1][j-1], dp[1][j-2]-prices[j]);
        }
        return dp[0][prices.length-1];
    }

    public int maxProfit_123_188(int p, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] cache = new int[p+1][2];
        for (int i = 0; i <= p; i++) {
            cache[i][0] = 0;
            cache[i][1] = -prices[0];
        }
        int[][] target = new int[p+1][2];
        for (int i = 1; i < prices.length; i++) {
            target[0][0] = 0;
            target[0][1] = Math.max(cache[0][0]-prices[i], cache[0][1]);
            for (int k = 1; k <= p; k++) {
                target[k][0] = Math.max(cache[k][0], cache[k-1][1] + prices[i]);
                target[k][1] = Math.max(cache[k][0]-prices[i], cache[k][1]);
            }
            cache = target;
            target = new int[p+1][2];
        }
        return cache[p][0];

    }
}

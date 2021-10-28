package coding.leetcode._09_dfs_backtracking.combination._1d;

import java.util.Arrays;

/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.


Example 1:
    Input:
        coins = [1,2,5],
        amount = 11
    Output:
        3
    Explanation:
        11 = 5 + 5 + 1

Example 2:
    Input:
        coins = [2],
        amount = 3
    Output:
        -1

Example 3:
    Input:
        coins = [1],
        amount = 0
    Output:
        0

Example 4:
    Input:
        coins = [1],
        amount = 1
    Output:
        1

Example 5:
    Input:
        coins = [1],
        amount = 2
    Output:
        2


Constraints:
    1 <= coins.length <= 12
    1 <= coins[i] <= 2^31 - 1
    0 <= amount <= 10^4

*/

public class _0322_Coin_Change {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Solution_Backtracking {

        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, Integer.MAX_VALUE);
            if (amount < 1) {
                return 0;
            }
            return helper(coins, amount, memo);
        }

        private int helper(int[] coins, int remain, int[] memo) {
            if (remain == 0) {
                return 0;
            } else if (remain < 0) {
                return -1;
            } else {
                if (memo[remain] == Integer.MAX_VALUE) {
                    for (int coin : coins) {
                        int res = helper(coins, remain - coin, memo) + 1;
                        if (res > 0 && res < memo[remain]) {
                            memo[remain] = res;
                        }
                    }
                }
                memo[remain] = (memo[remain] == Integer.MAX_VALUE ? -1 : memo[remain]);
                return memo[remain];
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Solution_DP {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int currAmount = 1; currAmount <= amount; ++currAmount) {
                for (int coin : coins) {
                    if (coin <= currAmount) {
                        dp[currAmount] = Math.min(dp[currAmount], dp[currAmount - coin] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

}
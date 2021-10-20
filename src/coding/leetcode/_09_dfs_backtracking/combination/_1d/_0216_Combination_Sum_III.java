package coding.leetcode._09_dfs_backtracking.combination._1d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.


Example 1:
    Input:
        k = 3,
        n = 7
    Output:
        [[1,2,4]]
    Explanation:
        1 + 2 + 4 = 7
        There are no other valid combinations.

Example 2:
    Input:
        k = 3,
        n = 9
    Output:
        [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
        There are no other valid combinations.

Example 3:
    Input:
        k = 4,
        n = 1
    Output:
        []
    Explanation:
        There are no valid combinations.
        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Example 4:
    Input:
        k = 3,
        n = 2
    Output:
        []
    Explanation:
        There are no valid combinations.

Example 5:
    Input:
        k = 9,
        n = 45
    Output:
        [[1,2,3,4,5,6,7,8,9]]
    Explanation:
        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
        There are no other valid combinations.


Constraints:
    2 <= k <= 9
    1 <= n <= 60
    
*/

public class _0216_Combination_Sum_III {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Solution_Backtracking {

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(k, n, 1, new LinkedList<>(), res);
            return res;
        }

        private void helper(int k, int n, int index, LinkedList<Integer> curr, List<List<Integer>> res) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(curr));
            }
            if (k > 0) {
                for (int i = index; i < 10; ++i) {
                    if (n - i >= 0) {
                        curr.addLast(i);
                        helper(k - 1, n - i, i + 1, curr, res);
                        curr.removeLast();
                    }
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Solution_Backtracking2 {

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(k, n, 1, new LinkedList<>(), res);
            return res;
        }

        private void helper(int k, int n, int index, LinkedList<Integer> curr, List<List<Integer>> res) {
            if (n == 0 && k == 0) {
                res.add(new ArrayList<>(curr));
            } else if (n > 0 && k > 0 && index < 10) {
                // Add
                curr.add(index);
                helper(k - 1, n - index, index + 1, curr, res);
                curr.removeLast();
                // Not add
                helper(k, n, index + 1, curr, res);
            }
        }
    }
}
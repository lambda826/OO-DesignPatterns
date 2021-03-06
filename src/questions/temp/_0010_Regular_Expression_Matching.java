/**
 *  @author Yunxiang He
 *  @date 01/29/2018
 */

package questions.temp;

/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).


Example 1:
    Input:
        s = "aa"
        p = "a"
    Output: 
        false
    Explanation: 
        "a" does not dp the entire string "aa".

Example 2:
    Input:
        s = "aa"
        p = "a*"
    Output: 
        true
    Explanation: 
        '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
    Input:
        s = "ab"
        p = ".*"
    Output: 
        true
    Explanation: 
        ".*" means "zero or more (*) of any character (.)".

Example 4:
    Input:
        s = "aab"
        p = "c*a*b"
    Output: 
        true
    Explanation: 
        c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
    Input:
        s = "mississippi"
        p = "mis*is*p*."
    Output: 
        false


Note:
    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

*/

public class _0010_Regular_Expression_Matching {

    public static void main(String[] args) {
        System.out.println(new _0010_Regular_Expression_Matching().isMatch("aa", "a*"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // If p.charAt(j) == s.charAt(i) || p.charAt(j) == '.' :  dp[i][j] = dp[i-1][j-1];
    // If p.charAt(j) == '*': 
    //      Here are two sub conditions:
    //      if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    //      if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    //          dp[i][j] = dp[i-1][j]   // in this case, a* counts as multiple a 
    //       or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    //       or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[ss.length + 1][pp.length + 1];
        // Initiallization
        dp[0][0] = true;
        for (int j = 0; j < pp.length; j++) {
            if (pp[j] == '*') {
                if (j - 2 < 0) {
                    dp[0][j + 1] = true;
                } else {
                    dp[0][j + 1] = dp[0][j - 1];
                }
            }
        }
        for (int j = 0; j < pp.length; ++j) {
            for (int i = 0; i < ss.length; ++i) {
                if (pp[j] == '.' || pp[j] == ss[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pp[j] == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j]; // * matches 0 or 1
                    if (!dp[i + 1][j + 1] && (pp[j - 1] == '.' || pp[j - 1] == ss[i])) { // * matches 1+
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                }
            }
        }
        return dp[ss.length][pp.length];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isMatch_DP(String s, String p) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int j = p.length() - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                // ????????????????????????*???????????????element??????????????????
                for (int i = s.length() - 1; i >= 0; i--) {
                    // ??????match????????????????????????element???match??????????????????element???match
                    dp[i] = dp[i] || (dp[i + 1] && (p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)));
                }
                // ??????*?????????preceding???????????????element????????????????????????*???????????????????????????
                j--;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    // dp[i]???s???????????????match???????????????true???????????????????????????????????????????????????????????????match????????????????????????????????????match
                    dp[i] = dp[i + 1] && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                }
                // e.g. s = "ab", p = ".*c" ??????????????????p???????????????????????????*??????????????????????????????????????????????????????????????????????????????match[s.length()]?????????false
                dp[s.length()] = false;
            }
        }
        return dp[0];
    }

}

package questions._01_array;

/*

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.


Example 1:
    Input:
        secret = "1807",
        guess = "7810"
    Output:
        "1A3B"
    Explanation:
        Bulls are connected with a '|' and cows are underlined:
            "1807"
              |
            "7810"

Example 2:
    Input:
        secret = "1123",
        guess = "0111"
    Output:
        "1A1B"
    Explanation:
        Bulls are connected with a '|' and cows are underlined:
            "1123"        "1123"
              |      or     |
            "0111"        "0111"
            Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

Example 3:
    Input:
        secret = "1",
        guess = "0"
    Output:
        "0A0B"

Example 4:
    Input:
        secret = "1",
        guess = "1"
    Output:
        "1A0B"


Constraints:
    1 <= secret.length, guess.length <= 1000
    secret.length == guess.length
    secret and guess consist of digits only.

*/

public class _0299_Bulls_and_Cows {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Solution {
        public String getHint(String secret, String guess) {
            int[] nums = new int[10];
            int bulls = 0;
            int cows = 0;
            char[] ss = secret.toCharArray();
            char[] gg = guess.toCharArray();
            for (int i = 0; i < ss.length; ++i) {
                if (ss[i] == gg[i]) {
                    ++bulls;
                } else {
                    if (++nums[ss[i] - '0'] <= 0) { // There is a guess character to match.
                        ++cows;
                    }
                    if (--nums[gg[i] - '0'] >= 0) { // There is a secret character to match.
                        ++cows;
                    }
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

}
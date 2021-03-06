/**
 *  @author Yunxiang He
 *  @date 06/24/2018
 */

package questions.temp;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/*

We are given head, the head node of a linked list containing unique integer values.
We are also given the list G, a subset of the values in the linked list.
Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.


Example 1:
    Input: 
        head: 0->1->2->3
        G = [0, 1, 3]
    Output: 
        2
    Explanation: 
        0 and 1 are connected, so [0, 1] and [3] are the two connected components.

Example 2:
    Input: 
        head: 0->1->2->3->4
        G = [0, 3, 1, 4]
    Output: 
        2
    Explanation: 
        0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.

Note:
    If N is the length of the linked list given by head, 1 <= N <= 10^4.
    The value of each node in the linked list will be in the range [0, N - 1].
    1 <= G.length <= 10^4.
    G is a subset of all values in the linked list.

*/

public class _0817_Linked_List_Components {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int numComponents(ListNode head, int[] G) {
        boolean[] table = new boolean[10^4];
        for (int g : G) {
            table[g] = true;
        }
        int count = 0;
        boolean flag = false;
        while (head != null) {
            if (!table[head.val]) {
                flag = false;
            } else if (!flag) {
                count++;
                flag = true;
            }
            head = head.next;
        }
        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int numComponents2(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        int count = 0;
        boolean flag = false;
        while (head != null) {
            if (!set.contains(head.val)) {
                flag = false;
            } else if (!flag) {
                flag = true;
                ++count;
            }
            head = head.next;
        }
        return count;
    }
}

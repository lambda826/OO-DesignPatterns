/**
 *  @author Yunxiang He
 *  @date 01/22/2018
 */

package questions.temp;

/*

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
    
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.


For example,
    Given the following perfect binary tree,
             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL


Note:
    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).


 */

public class _0116_Populating_Next_Right_Pointers_in_Each_Node {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null && curr.left != null) {
            Node next = curr.left;
            while (curr != null && curr.next != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr.left.next = curr.right;
            curr = next;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}

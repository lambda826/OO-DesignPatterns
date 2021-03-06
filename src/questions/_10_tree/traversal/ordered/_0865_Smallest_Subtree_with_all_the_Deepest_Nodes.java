package questions._10_tree.traversal.ordered;

/*

Given the root of a binary tree, the depth of each node is the shortest distance to the root.
Return the smallest subtree such that it contains all the deepest nodes in the original tree.
A node is called the deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.


Note: This question is the same as 1123: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/


Example 1:
    Input:
        root = [3,5,1,6,2,0,8,null,null,7,4]
    Output:
        [2,7,4]
    Explanation:
        We return the node with value 2, colored in yellow in the diagram.
        The nodes coloured in blue are the deepest nodes of the tree.
        Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.

Example 2:
    Input:
        root = [1]
    Output:
        [1]
    Explanation:
        The root is the deepest node in the tree.

Example 3:
    Input:
        root = [0,1,3,null,2]
    Output:
        [2]
    Explanation:
        The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.


Constraints:
    The number of nodes in the tree will be in the range [1, 500].
    0 <= Node.val <= 500
    The values of the nodes in the tree are unique.

*/

import common.TreeNode;

public class _0865_Smallest_Subtree_with_all_the_Deepest_Nodes {


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Analysis: The problem is abstracted to comparing height of left subtree and right subtree
    //  1. If the heights equal, return root of the subtree
    //  2. or return whichever has greater height
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return postOrder(root).node;
    }

    private DepthNode postOrder(TreeNode node) {
        if (node == null) {
            return new DepthNode(null, 0);
        } else {
            DepthNode left = postOrder(node.left);
            DepthNode right = postOrder(node.right);
            if (left.depth > right.depth) {
                left.depth++;
                return left;
            } else if (left.depth < right.depth) {
                right.depth++;
                return right;
            } else {
                return new DepthNode(node, left.depth + 1);
            }
        }
    }

    class DepthNode {
        TreeNode node;
        int depth;

        public DepthNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}

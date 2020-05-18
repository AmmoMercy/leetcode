//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Queue<TreeNode>> out = new LinkedList<>();
        Queue<TreeNode> start = new LinkedList<>();
        start.add(root);
        out.add(start);
        while (!out.isEmpty()) {
            Queue<TreeNode> level = out.poll();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> levelContent = new LinkedList<>();
            while (!level.isEmpty()) {
                TreeNode node = level.poll();
                levelContent.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            if (!nextLevel.isEmpty()) out.add(nextLevel);
            res.add(levelContent);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

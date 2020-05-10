/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode p,q;
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        reverse(root);
        return res;
    }
    private boolean reverse(TreeNode node){
        if(node==null)return false;
        boolean left=reverse(node.left);
        boolean right=reverse(node.right);
        if(left&&right||((node==p||node==q)&&(left||right))){
            res=node;
            return true;
        }
        return node==p||node==q||right||left;
    }
}
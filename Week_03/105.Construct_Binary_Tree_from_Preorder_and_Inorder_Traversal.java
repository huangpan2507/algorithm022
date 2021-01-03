/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
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
    private TreeNode dfs(int[] p, int[] i, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
        if(ps >= pe || is >=ie) {                                                   // 判断遍历数组是否为空
            return null;
        }
        TreeNode root = new TreeNode(p[ps]);                                        // 从前序数组中找到根节点的值并构建根节点
        int index = map.get(root.val);                                              // 从中序中获取根节点的下标位置
        root.left = dfs(p, i, ps + 1, index - is + ps, is, index - 1, map);         // 遍历左子树，先序与中序数组一同确认左子树起始与结束位置
        root.right = dfs(p, i, index - is + ps + 1, pe, index + 1, ie, map);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {                                   // 用map省得每次都要重新查找根节点位置
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
}
// @lc code=end


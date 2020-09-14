package day0515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//        501. 二叉搜索树中的众数
//        94. 二叉树的中序遍历
//        65. 有效数字
public class Solution {
    private List<Integer> modes;
    private int cur;
    private int curtimes;
    private int lasttimes;
    private int[] findMode(TreeNode root){
        modes = new LinkedList<>();
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i=0;i<modes.size();i++)
            res[i] = modes.get(i);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root==null) return;
        inOrder(root.left);

        if (lasttimes==0)
            lasttimes=1;
        if (root.val!=cur)
            curtimes=0;
        cur=root.val;
        curtimes++;
        if (curtimes==lasttimes)
            modes.add(cur);
        if (curtimes>lasttimes){
            lasttimes=curtimes;
            modes.clear();
            modes.add(cur);
        }

        inOrder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List res = new ArrayList();
        adds(root,res);
        return res;
    }

    private void adds(TreeNode root, List res) {
        if (root!=null){
            if (root.left!=null)
                adds(root.left,res);
            res.add(root.val);
            if (root.right!=null)
                adds(root.right,res);
        }
    }
}

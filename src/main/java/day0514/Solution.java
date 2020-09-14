package day0514;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//617. 合并二叉树
//        102. 二叉树的层序遍历
//        145. 二叉树的后序遍历
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null)
            return t2;
        if (t2==null)
            return t1;
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }

    @Test
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        //节点入栈
        if (root!=null)
            queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> lever = new ArrayList<>();
            for (int i=0;i<n;i++){
                //出栈入链
                TreeNode node = queue.poll();
                lever.add(node.val);
                //将左右节点入栈
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            //链表入双层链表
            res.add(lever);
        }
        return res;
    }
}

package day0501;

import java.util.*;

public class Solution {
    //88. 合并两个有序数组

    public void merge(int[] num1,int m,int[] num2,int n) {
        //解法一：连接到一起，后排序
//        System.arraycopy(num2,0,num1,m,n);
//        Arrays.sort(num1);
        //解法二：从后往前直接判断，若num1[m]>num2[n]，则令num1[i]=num1[m],同时i前移，m前移，否则num1[i]=num2[n],同时i前移，n前移
        int i = m-- + --n;
        while (n >= 0) {
            if (m > 0 && num1[m] > num2[n])
                num1[i--] = num1[m--];
            else num1[i--] = num2[n--];
        }
    }
    //36. 有效的数独
    //利用hashmap映射，将（行/列/子块）出现一次的位置记为1，多出现一次就+1，最后遍历哈希表是否大于一即可。
    boolean isValidSudoku(char[][] board){
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];
        for (int i = 0;i<9;i++){
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0;i<9;i++){
            for (int j=0;j<9;j++){
                char num = board[i][j];
                if (num!='.'){
                    int n = (int) num;
                    int box = (i/3)*3+j/3;
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    columns[j].put(n,columns[j].getOrDefault(n,0)+1);
                    boxes[box].put(n,boxes[box].getOrDefault(n,0)+1);
                    if (rows[i].get(n)>1||columns[j].get(n)>1||boxes[box].get(n)>1)
                        return false;
                }
            }
        }
        return true;
    }
    //145. 二叉树的后序遍历
    //后续遍历
//    public List<Integer> res = new ArrayList<Integer>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root==null)
//            return res;
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        res.add(root.val);
//        return res;
//    }
    //先序遍历入栈
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left!=null)
                stack.push(node.left);
            if (node.right!=null)
                stack.push(node.right);
            res.add(0,node.val);
        }
        return res;
    }
}
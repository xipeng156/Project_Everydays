package day0509;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


//        面试题42. 连续子数组的最大和
//        面试题38. 字符串的排列
//        面试题51. 数组中的逆序对
public class Solution {
    //动态规划
    public int maxSubArray(int[] nums){
        int res = nums[0];//初始化
        for (int i = 1;i<nums.length;i++){//循环遍历
            nums[i] +=Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }

    //回溯法，深度优先搜索法，利用hashset进行剪枝
    List<String> res = new LinkedList<String>();
    char[] c;
    public String[] permutation(String s){
        c = s.toCharArray();//字符转字符数组
        dfs(0);
        return res.toArray(new String[res.size()]);//将list以数组形式返回
    }
    void dfs(int x){
        if (x == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = x ; i<c.length ; i++){
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }
    void swap(int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}

package day0518;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//557. 反转字符串中的单词 III
//        54. 螺旋矩阵
//        920. 播放列表的数量
public class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        String st = "";
        for (int i=0;i<str.length;i++){
            st+=String.valueOf(new StringBuilder(str[i]).reverse());
            st+=i==str.length?"":" ";
        }
        return st;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null||matrix.length==0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0;
        int count = (Math.min(m,n)+1)/2;
        while(i < count) {
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                list.add(matrix[j][(n-1)-i]);
            }

            for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                list.add(matrix[(m-1)-i][j]);
            }
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }

}

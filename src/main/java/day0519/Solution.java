package day0519;

import org.testng.annotations.Test;

import java.util.Stack;

//9.回文数 Ⅱ385. 迷你语法分析器895. 最大频率栈
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        if (x<10)
            return true;
        String ch = x+"";
        Stack<Character> stack = new Stack<>();
        int len_sum = ch.length();
        int len = len_sum/2;
        for (int i=0; i<len;i++)
            stack.push(ch.charAt(i));
        if (len_sum%2==1){
            len++;
            while (len<len_sum)
                if (ch.charAt(--len)==stack.peek())
                    stack.pop();
        }
        else
            while (len<len_sum)
                if (ch.charAt(--len)==stack.peek())
                    stack.pop();
        if (stack.empty())
            return true;
        else return false;
    }
}
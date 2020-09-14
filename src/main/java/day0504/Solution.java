package day0504;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int converInteger(int A, int B){
        return Integer.bitCount(A^B);
    }

    public int lengthOfLongestSubstring(String s){
        int m = 0;
        int len = s.length();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int end = 0,start = 0;end<len;end++){
            char a = s.charAt(end);
            if (map.containsKey(a))
                start = Math.max(start,map.get(a));
            m = Math.max(m,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return m;
    }
    //42.接雨水
    public int trap(int[] height){
        int sum=0;
        int max = getMax(height);
        for (int i=1;i<=height.length;i++){
            boolean isStar = false;
            int temp_sum = 0;
            for (int j = 0;j<height.length;j++){
                if (isStar&&height[j]<i)
                    temp_sum++;
                if (height[j]>=i){
                    sum=sum+temp_sum;
                    temp_sum=0;
                    isStar=true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max=0;
        for (int i = 0;i<height.length;i++){
            if (height[i]>max)
                max = height[i];
        }
        return max;
    }
}

package day0516;
//面试题39. 数组中出现次数超过一半的数字
//        面试题63. 股票的最大利润
//        233. 数字 1 的个数
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int maxProfit(int[] prices) {
        if (prices.length==0||prices.length==1)
            return 0;
        int max = prices[1]-prices[0];
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                max=Math.max(max,prices[i]-prices[i]);
            }
        }
        return max>0?max:0;
    }
}

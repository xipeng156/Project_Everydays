package day0903;

import java.util.*;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class twoSum {
//    1.暴力法
//    public int[] twoSum(int[] nums,int target){
//        List l = new ArrayList();
//        for (int i=0;i< nums.length;i++){
//            for (int j=i+1;j< nums.length;j++){
//                if (nums[i]+nums[j]==target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{};
//    }


//    哈希表法
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i)
                return new int[]{i,map.get(target-nums[i])};
        }
        return null;
    }
}

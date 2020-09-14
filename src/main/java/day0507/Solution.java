package day0507;

import java.math.BigInteger;

//        7. 整数反转
//        98. 验证二叉搜索树
//        41. 缺失的第一个正数
public class Solution {
    public static void main(String[] args) {
//        int x = reverse(1534236469);
//        System.out.println(x);
//        return;
        int a[] = {1,2,3,4};
        int x = firstMissingPositive(a);
        System.out.println(x);
    }
    public static int reverse(int x){
        String sx = x+"";
        int le = sx.length();
        boolean bo = false;
        if (sx.charAt(0)=='-') {
            sx = sx.substring(1, le);
            bo=true;
            le--;
        }
//        System.out.println(":"+sx+":"+le);
        String sy = "";
        while (le>0){
            sy+=sx.charAt(le-1);
            le--;
        }
        BigInteger bigy = new BigInteger(sy);
        System.out.println("BIG:"+bigy);
        int max = new Double(Math.pow(2,31)-1).intValue();
        int min = new Double(Math.pow(-2,31)).intValue();
        if (bigy.compareTo(new BigInteger(String.valueOf(max)))==1||bigy.compareTo(new BigInteger(String.valueOf(min)))==-1)
            return 0;
        int y = bigy.intValue();
        System.out.println("Y:"+y);
        System.out.println("max:"+Math.pow(2,31));

        if (bo)
            y*=-1;
        return y;
    }
    public static int reverse1(int x){
        int num =0;
        while (x!=0){
            int pop = x%10;
            if (num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&pop>7))
                return 0;
            if (num<Integer.MIN_VALUE/10||(num == Integer.MIN_VALUE/10&&pop<-8))
                return 0;
            num=num*10+pop;
            x/=10;
        }
        return num;
    }
    public boolean isValidBST(TreeNode root){
        return ret(root,null,null);

    }

    private boolean ret(TreeNode root, Integer lower, Integer upper) {
        if (root==null)
            return true;
        int val = root.val;
        if (lower!=null&&val<=lower)
            return false;
        if (upper!=null&&val>=upper)
            return false;
        if (!ret(root.left,lower,val))
            return false;
        if (!ret(root.right,val,upper))
            return false;
        return true;
    }
    public static int firstMissingPositive(int[] nums) {
        int[] co = new int[10];
        int len = nums.length-1;
        while (len>=0){
            co[nums[len]]++;
            len--;
        }
        int len2 = nums.length-1;
        while (len2>=0){
            if (co[len2]==0)
                return co[len2];
            len2--;
        }
        return co[len2++];
    }
}

package day0510;
//70.爬楼梯                        8.字符串转整数(atoi)       37.解数独
public class Solution {
    public int climbStairs(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int myAtoi(String str){
        if (str == null||str.length()==0)
            return 0;
        int i = 0;
        long res = 0;
        boolean isActive = true;
        //去空格
        while (i<str.length()&&str.charAt(i)==' ')
            i++;
        char[] array = str.toCharArray();
        if (i==str.length())
            return (int)res;
        if (array[i]=='-'||array[i]=='+'){
            if (array[i]=='-')
                isActive=false;
            i++;
        }else if(array[i]-'0'>9||array[i]-0<'0')
            return isActive?(int)res:(int)res*-1;
        for (;i<array.length;i++){
            int number = array[i] - '0';
            if (number<0||number>9)
                return isActive?(int)res:(int)res*-1;
            else res=res*10+number;
            if (isActive&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (!isActive&&res*-1<Integer.MIN_VALUE) return Integer.MIN_VALUE;

        }
        return isActive?(int)res :(int)res*-1;
    }
}
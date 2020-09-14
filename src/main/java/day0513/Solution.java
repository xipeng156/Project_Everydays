package day0513;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//1360. 日期之间隔几天
//93. 复原IP地址
//1028. 从先序遍历还原二叉树
public class Solution {
    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2020-01-15","2019-12-31"));
    }
    public static int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        int year1=Integer.parseInt(d1[0]);
        int year2=Integer.parseInt(d2[0]);
        int month1 = Integer.parseInt(d1[1]);
        int month2 = Integer.parseInt(d2[1]);
        int day1 = Integer.parseInt(d1[2]);
        int day2 = Integer.parseInt(d2[2]);
        if (Integer.parseInt(d1[0]+d1[1]+d1[2])>Integer.parseInt(d2[0]+d2[1]+d2[2]))
            return getData(year1,month1,day1)-getData(year2,month2,day2);
        return getData(year2,month2,day2)-getData(year1,month1,day1);
    }
//2020-01-15","2019-12-31"
    private static int getData(int year, int month, int day) {
        int sum = day;
        int[] month_day= {0,31,28,31,30,31,30,31,31,30,31,30,31};
        month--;
        while (month>0){
            sum+=month_day[month];
            if (month==2&&((year%4==0&&year%100!=0)||year%400==0))
                sum++;
            month--;
        }
        year--;
//        System.out.println(year+" "+sum);
        while (year>2018){
            sum+=365;
            if ((year%4==0&&year%100!=0)||year%400==0)
                sum++;
            year--;
        }
        return sum;
    }
    @Test
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        backtrace(s,0,cur,0,res);
        return res;
    }
    private void backtrace(String s, int index, StringBuilder cur, int depth, List<String> res) {
        int len = cur.length();
        if (depth == 4){
                //如果深度等于4且索引长度等于字符串长度，则去掉尾部的.并加入结果集
            if (index==s.length()){
                cur.deleteCharAt(cur.length()-1);
                res.add(cur.toString());
            }
            return;
        }
        for (int i =1;i<=3;i++){
            //超出长度，结束
            if (index+i>s.length()) break;
            //判断数字合法性
            if (Integer.parseInt(s.substring(index,index+i))>255)
                break;
            int num=Integer.parseInt(s.substring(index,index+i));
            //不能存在01.001.01.01
            if (String.valueOf(num).length()!=i)
                break;
            //入队列并加.
            cur.append(s.substring(index,index+i));
            cur.append(".");
            backtrace(s,index+i,cur,depth+1,res);
            cur.setLength(len);
        }
    }
}

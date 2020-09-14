package day0512;

import java.util.*;
//13. 罗马数字转整数
//12. 整数转罗马数字
//32. 最长有效括号
public class Solution {
    public static void main(String[] args) {
//        int n = romanToInt("LVIII");
//        System.out.println(n);
        System.out.println(intToRoman(58));
    }
    public static int romanToInt(String s){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int ans = 0;
        for (int i = 0;i<s.length();){
            if (i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                ans+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                System.out.println(s.substring(i,i+1));
                System.out.println(map.get(s.substring(i,i+1)));
                ans+=map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;
    }
    public static String intToRoman(int num) {
        String roman = "";
        while (num>0){
            if (num/1000>0){
                roman+="M";
                num-=1000;
            }else if(num/900==1){
                roman+="CM";
                num-=900;
            }else if(num/600==1){
                roman+="DC";
                num-=600;
            }else if (num/500==1){
                roman+="C";
                num-=500;
            }else if(num/400==1){
                roman+="CD";
                num-=400;
            }else if (num/100>0){
                roman+="C";
                num-=100;
            }else if(num/90==1){
                roman+="XC";
                num-=90;
            }else if(num/60==1){
                roman+="LX";
                num-=60;
            }else if (num/50==1){
                roman+="L";
                num-=50;
            }else if(num/40==1){
                roman+="XL";
                num-=40;
            }else if(num/10>0){
                roman+="X";
                num-=10;
            }else if (num%9==0){
                roman+="IX";
                num-=9;
            }else if (num%6==0){
                roman+="VI";
                num-=6;
            }else if (num/5==1){
                roman+="V";
                num-=5;
            }else if (num%4==0&&num/4==1){
                roman+="IV";
                num-=4;
            }else while (num>0){
                roman+="I";
                num--;
            }
        }
        return roman;
    }
}

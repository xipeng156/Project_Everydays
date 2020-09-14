package day0506;

import java.util.regex.Pattern;

//        1290. 二进制链表转整数
//        468. 验证IP地址
//        1220. 统计元音字母序列的数目
public class Solution {
    //        1290. 二进制链表转整数
    public int getDecimalValue(ListNode head){
        ListNode pre = head;
        int len=0;
        while (pre!=null){
            //链表求长度
            len++;
            pre=pre==null?null:pre.next;
        }
        // System.out.println(len);
        int sum = 0;
        while (head!=null)
        {
            sum += head.val*Math.pow(2,len-1);
            // System.out.println(sum);
            len--;
            head=head==null?null:head.next;
        }
        return sum;
    }
//    //        468. 验证IP地址
//    public String validIPAddress(String IP) {
//        String[] ip4 = IP.split("\\.");
//        int len_4 = ip4.length;
//        String[] ip6 = IP.split("\\:");
//        int len_6 = ip6.length;
//        //IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
//        //IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254
//        // .01 是不合法的.
//        if (len_4==4){
//            while (len_4>0){
//                if (ip4[len_4-1].charAt(0)=='0')
//                    return "Neither";
//                int ips =
//                        Integer.parseInt(ip4[len_4-1]);
//                if (ips<=0||ips>=256)
//                    return "Neither";
//                len_4--;
//            }
//            return "IPv4";
//        }
////地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  
////2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，
////字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
////然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
////同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
//        else if (len_6==8) {
//            while (len_6 > 0) {
//                if (ip6[len_6 - 1].length() == 0)
//                    return "Neither";
//            }
//            return "IPv6";
//        }
//        else
//            return "Neither";
//    }
//}
//class Solution{
    //正则表达式
    String ipv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern p_4 = Pattern.compile("^("+ipv4+"\\.){3}"+ipv4+"$");
    String ipv6 = "([0-9a-fA-F]{1,4})";
    Pattern p_6 = Pattern.compile("^("+ipv6+"\\:){7}"+ipv6+"$");
    public String validIPAddress(String IP){
        if (IP.contains("."))
            return (p_4.matcher(IP).matches())?"IPv4":"Neither";
        else if (IP.contains(":"))
            return (p_6.matcher(IP).matches())?"IPv6":"Neither";
        return "Neither";
    }
}
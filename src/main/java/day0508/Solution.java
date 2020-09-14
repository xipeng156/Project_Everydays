package day0508;
import java.util.Stack;

//面试题 17.01. 不用加号的加法
//        445. 两数相加 II
//        887. 鸡蛋掉落
public class Solution {
    public int add(int a, int b) {
//        return a==b?2*a:(a*a-b*b)/(a-b);
//    return a+b;
        while (b!=0){
            int sum = a^b;
            int carry = (a&b)<<1;
            a=sum;
            b=carry;
        }
        return a;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        while (l1!=null) {
            st1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            st2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head = null;
        while (!st1.isEmpty()||!st2.isEmpty()||carry>0){
            int sum =carry;
            sum+=st1.isEmpty()?0:st1.pop();
            sum+=st2.isEmpty()?0:st2.pop();
            ListNode node = new ListNode(sum%10);
            node.next = head;
            head = node;
            carry = sum/10;
        }
        return head;
    }
}

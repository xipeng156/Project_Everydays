package day0505;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    //824:山羊拉丁文
    public static String toGoatLatin(String s){
        String[] sp = s.split("\\s+");
        int l = sp.length;
        for (int i=0;i<l;i++){
            if (sp[i].charAt(0)=='a'||sp[i].charAt(0)=='e'||sp[i].charAt(0)=='i'||sp[i].charAt(0)=='o'||sp[i].charAt(0)=='u'||sp[i].charAt(0)=='A'||sp[i].charAt(0)=='E'||sp[i].charAt(0)=='I'||
                    sp[i].charAt(0)=='O'||sp[i].charAt(0)=='U'){
                sp[i]=sp[i]+"ma";
            }
            else {
                char temp = sp[i].charAt(0);
                System.out.println(temp);
                sp[i] = sp[i].substring(1);
                System.out.println(sp[i]);
                sp[i] = sp[i]+temp+"ma";
            }
            for (int j=0;j<=i;j++){
                sp[i]+="a";
            }
        }
        String st = String.join(" ",sp);
        return st;
    }
    //链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp;
        ListNode le = new ListNode(0);
        ListNode pre = le;
        int carry = 0;
        while (l1!=null||l2!=null) {
            int sum=carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            carry = sum / 10;
            pre.next = new ListNode(sum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            pre = pre.next;
        }
        if (carry==1)
            pre.next=new ListNode(carry);
        return le.next;
    }
    //23. 合并K个排序链表
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list =
                new ArrayList<Integer>(0);
        int len = lists.length-1;
        while (len>=0){
            while (lists[len]!=null){
                list.add(lists[len].val);
                lists[len]=lists[len].next;
            }
            len--;
        }
        Collections.sort(list);
//        list.sort(Integer::compareTo);
        ListNode ln = new ListNode(0);
        ListNode sa = ln;
//        for (int i=0;i<list.size();i++){
//            sa.val=list.get(i);
//            sa=sa.next;
//        }
        for (int i : list) {
            sa.next = new ListNode(i);
            sa = sa.next;
//        System.out.println(i);
        }

        return ln.next;
    }

    public static void main(String[] args) {
//        String st = toGoatLatin("I speak Goat Latin");
//        System.out.println(st);

    }
}

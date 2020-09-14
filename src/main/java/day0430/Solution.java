package day0430;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 
        逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;//进位器
        while (l1!=null||l2!=null){
            //一个数缺位则补0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x+y+carry;
            //下次进位数
            carry = sum/10;
            //sum尾数
            sum = sum%10;
            //sum位数入链表
            cur.next=new ListNode(sum);
            cur = cur.next;
            //下一指针
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
            cur.next=new ListNode(carry);
        return pre.next;
    }
/*    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.*/
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode start = pre,end=pre;
        while (n!=0){
            start=start.next;
            n--;
        }
        while ((start.next!=null)){
            start=start.next;
            end=end.next;
        }
        end.next=end.next.next;
        return pre.next;
    }
/*    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。
    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    示例：
    给你这个链表：1->2->3->4->5
    当 k = 2 时，应当返回: 2->1->4->3->5
    当 k = 3 时，应当返回: 3->2->1->4->5*/
    public ListNode reverseKGroup(ListNode head,int k){
        Deque<ListNode> dq = new ArrayDeque<ListNode>();
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        while (true){
            int count = 0;//计数器
            ListNode tep = head;//指针
            //节点入栈
            while (tep!=null&&count<k){
                dq.add(tep);
                tep=tep.next;
                count++;
            }
            //如果节点没到k，证明入栈结束，遍历完成，结束程序
            if(count!=k){
                p.next=head;
                break;
            }
            //弹出栈
            while (!dq.isEmpty()){
                p.next = dq.pollLast();//弹出栈顶
                p=p.next;
            }
            p.next = tep;
            head=tep;
        }
        return pre.next;
    }
}

package day0511;
//21. 合并两个有序链表 148. 排序链表25. K 个一组翻转链表
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode l3 = l;
        while (l1!=null&&l2!=null) {
            if (l1.val<=l2.val){
                l3.next=l1;
                l1=l1.next;
            }else {
                l3.next=l2;
                l2=l2.next;
            }
            l3=l3.next;
        }
        l3.next=l1==null?l2:l1;
        return l.next;
    }
    public ListNode sortList(ListNode head){
            if (head==null||head.next==null)
                return head;
            ListNode fast = head.next,slow = head;
            while (fast!=null&&fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left!=null&&right!=null){
                if (left.val<right.val){
                    h.next = left;
                    left = left.next;
                }else {
                    h.next = right;
                    right = right.next;
                }
                h=h.next;
            }
            h.next = left !=null?left:right;
            return res.next;
    }
}

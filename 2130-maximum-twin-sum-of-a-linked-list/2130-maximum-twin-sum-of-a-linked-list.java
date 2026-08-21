/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode curr = slow.next;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

       
        ListNode first = head;
        ListNode sec = prev;
        int max =0;

        while(sec!=null){
            int sum = first.val + sec.val;

            max = Math.max(max , sum);
            first = first.next;
            sec=sec.next;

        }
        
        return max;
    }
}
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy ;

        ListNode first = list1;
        ListNode second = list2;

        while(first!=null && second!=null ){

            if(first.val <= second.val){
                curr.next = first;
                curr = curr.next;
                first = first.next;
            }else{
                curr.next = second;
                 curr = curr.next;
                second = second.next;
            }
        }
        while(first!=null){
             curr.next = first;
                curr = curr.next;
                first = first.next;
        }

        while(second!=null){
               curr.next = second;
                 curr = curr.next;
                second = second.next;
        }

        return dummy.next;
    }
}
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCrit = -1;

        int  minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        int index = 1;

        ListNode prev = head ;
        ListNode curr = head.next ;

        while(curr.next!=null){
            ListNode next = curr.next ;

            if(curr.val<next.val && curr.val<prev.val || curr.val>next.val && curr.val>prev.val){
                if(first == -1){
                    first = index ;
                }else{

                minDist = Math.min(minDist , index - prevCrit);
                maxDist = index - first ;
            }
             prevCrit=index;
            }
            prev = curr ; 
            curr = next ;
            index++;

           
        }

        if(maxDist == -1){
            return new int[]{-1 , -1};
        }
         return new int[]{minDist , maxDist};
        
    }
}
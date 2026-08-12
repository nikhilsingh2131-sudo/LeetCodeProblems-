class Solution {
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> st = new Stack<>();

        ListNode curr = head;

        // Saare elements stack mein daalo
        while(curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }

        // Linked List ko dobara traverse karo
        curr = head;

        while(curr != null) {

            if(st.pop() != curr.val) {
                return false;
            }

            curr = curr.next;
        }

        return true;
    }
}
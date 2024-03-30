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
    public boolean isPalindrome(ListNode head) {
        //Find the middle Node
        ListNode slowptr = head , fastptr = head; 
        while(fastptr != null && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        if(fastptr != null){ // If the length of the list is odd, move slow pointer to the next node
            slowptr = slowptr.next;
        }

        //Reverse the second half
        slowptr = reverseList(slowptr);
        // Reset fast pointer to the head of the original list
        fastptr = head;
        // Traverse both halves of the list
        while(slowptr!= null){
            // Compare values of corresponding nodes
            if(fastptr.val != slowptr.val){
                return false; //If values don't match, it's not a palindrome
            }
            slowptr = slowptr.next; // Move to the next node in the reversed list
            fastptr = fastptr.next; // Move to the next node in the original list
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

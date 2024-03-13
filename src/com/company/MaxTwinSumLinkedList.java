/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        // Make dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head; // 0-->4-->8

        ListNode prevSlow = dummy; // 0

        ListNode slowptr = head; // 4
        ListNode fastptr = head; // 4

        // Travel until the fasst pointer reaches the last node or null
        while (fastptr != null && fastptr.next != null) {
            // move prevSlow ptr 1 node
            prevSlow =prevSlow.next ;
            // Slow ptr moves 1 node
            slowptr = slowptr.next;

            // fast ptr moves 2 nodes
            fastptr = fastptr.next.next;
        }
        //reverse the linkedlist
        ListNode PrevNode = null;
        ListNode currNode = slowptr; 
        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = PrevNode;
            PrevNode = currNode;
            currNode = nextNode;

        }
        //Linking the last node of the first half to the last node of the reversed second half
        prevSlow.next = PrevNode;
      
        int maxSum = 0;
        ListNode curr1 = head;
        ListNode curr2 = PrevNode;
        while(curr1 != null && curr2!=null){
            maxSum = Math.max(maxSum, curr1.val+curr2.val);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }


        return maxSum;
    }
}

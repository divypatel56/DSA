/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Make 2 pointers slow and fast
        //if both meet at some points it means this is a cycled Linked List

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr!= null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
        
    }
}

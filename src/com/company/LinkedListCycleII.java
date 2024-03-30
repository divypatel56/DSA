// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //1. Make 2 pointers
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            //2. slowptr moves X while fastptr moves 2x
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            //3. if they both meets it means, this is a linked List
            if (slowPtr == fastPtr) {
                //4. moves fast ptr to head(means noe head is fast ptr)
                while (head != slowPtr) {
                    //5. Move head and slowptr at same speet until they meet 
                    head = head.next;
                    slowPtr = slowPtr.next;
                }
                //6. return the node where they meet again this the beigning of the cycle
                return slowPtr;
            }
            // means no cylcle exists return null
        }
        return null;

    }
}

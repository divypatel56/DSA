/** Q: remove nth node from end of the Linked List */
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //make dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //start 2 pointers ptr1,ptr2 at first node.(dummy node)
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;
        //Move ptr2 n space ahed
        for(int i=0; i<n; i++){
            ptr2 = ptr2.next;
        }
        //Start moving both pointers ahead till next of ptr will be 0
        while(ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        //Remove next of ptr1
        ptr1.next = ptr1.next.next;
        // return head of the LinkedList
        return dummy.next;
        
    }
}

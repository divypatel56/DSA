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
    public void reorderList(ListNode head) {
        //if the List is empty return 
        if(head.next == null || head == null){
            return;
        }
        //First List head
        ListNode l1 = head;
        //First list tail
        ListNode prev = null;
        //Second list head
        ListNode slowptr = head;
        //second list tail
        ListNode fastptr = head;
        
        //Find Middle
        while(fastptr != null && fastptr.next !=null){
            prev = slowptr;
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        //Make first half and second half seprate 
        prev.next = null ;

        //reverse the 2nd half
        ListNode l2 = reverseList(slowptr);

        //Make reorderList
        reorder(l1,l2);
    }
    public void reorder(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;
            if(l1_next == null){
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

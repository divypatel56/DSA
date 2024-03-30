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
    public ListNode oddEvenList(ListNode head) {
        // 2-->1-->3-->5-->6-->4-->7-->Null

        //if list is empty
        if(head==null){
            return head;
        }
        
        //Make pointers for ood & even
        ListNode odd = head; //2
        ListNode even = head.next; // 1

        //Maintain evenHead
        ListNode evenHead = even; // 1

        while(even != null && even.next != null){

            //Change pointers for odd list
            odd.next = odd.next.next; // 2-->3, 3-->6, 6-->7
            odd = odd.next;    // odd = 3,6,7

            //change pointers for even list
            even.next = even.next.next; // 1-->5, 5-->4, 4-->Null
            even = even.next;  // even = 5,4,Null
        }
        //Assign evenList at the end of the odd list
        odd.next = evenHead; //2-->3-->6->7-->1-->5-->4-->N

        return head;



    }
}

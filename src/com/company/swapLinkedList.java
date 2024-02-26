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
//Leet 25
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Make dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;   // 0 ---> 1

        ListNode point = dummy;

        while(point.next != null && point.next.next != null){
            //Nodes to swap
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            //Actual swap
            swap1.next = swap2.next; //1-->3
            swap2.next = swap1;  //2->1
            //prepare for next swap
            point.next = swap2;  //point(0)-->2-->1-->3-->4
            point = swap1;    // 0-->2-->point(1)--->3-->4
        }

        return dummy.next;
        
    }
}

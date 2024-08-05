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
package com.company;
import com.company.AddTwoNumberLL;
public class FindMiddleofLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;

        // Travel until the fasst pointer reaches the last node or null
        while(fastptr != null && fastptr.next !=null){
            //Slow ptr moves 1 node
            slowptr = slowptr.next;

            //fast ptr moves 2 nodes
            fastptr = fastptr.next.next;
        }

        return slowptr;


    }
}



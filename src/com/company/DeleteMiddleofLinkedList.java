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
import  com.company.AddTwoNumberLL;
public class DeleteMiddleofLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        //Make dummy node
        ListNode dummy = new ListNode(0); 
        dummy.next = head; // 0-->4-->8

        ListNode prevSlow = dummy; // 0

        ListNode slowptr = head; //4
        ListNode fastptr = head; //4

        // Travel until the fasst pointer reaches the last node or null
        while(fastptr != null && fastptr.next !=null){
            //move prevSlow ptr 1 node
            prevSlow = prevSlow.next; 
            //Slow ptr moves 1 node
            slowptr = slowptr.next;

            //fast ptr moves 2 nodes
            fastptr = fastptr.next.next;
        }
        // remove the middle node
        prevSlow.next = slowptr.next;

        return dummy.next;

        
        
    }
}

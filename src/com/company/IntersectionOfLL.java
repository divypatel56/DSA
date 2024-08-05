package com.company;
import com.company.AddTwoNumberLL;
public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        // Adjust the starting points of both lists

        while(lenA > lenB){
            lenA--;
            headA = headA.next;
        }

        while(lenB > lenA){
            lenB--;
            headB = headB.next;
        }
        // Now both heads are at same distance from intersection
        // Start moving them both until they meet
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;

        }
        // Return the intersection point or null if there's no intersection
        return headA;

    }


    // Find the length of list
    private int getListLength(ListNode head){
        int length =0;
        while(head != null){
            length ++;
            head = head.next;

        }
        return length;
    }
}

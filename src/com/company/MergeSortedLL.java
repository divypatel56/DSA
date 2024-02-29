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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node for the merged LinkedList
        ListNode dummy = new ListNode(-1);
        // Point head to this dummy node
        ListNode headDummy = dummy;

        // Traverse both lists until one of them becomes null
        while(list1 != null && list2 != null){
            // Compare the values of the current nodes in both lists
            if(list1.val <= list2.val){
                // If the value in list1 is smaller or equal, add list1's node to the merged list
                dummy.next = list1;
                // Move to the next node in list1
                list1 = list1.next;
            }
            else{
                // If the value in list2 is smaller, add list2's node to the merged list
                dummy.next = list2;
                // Move to the next node in list2
                list2 = list2.next;
            }
            // Move the dummy pointer to the next node in the merged list
            dummy = dummy.next;
        }

        // If one of the lists is exhausted, append the rest of the other list to the merged list
        if(list1 == null){
            dummy.next = list2;
        }
        else if(list2 == null){
            dummy.next = list1;
        }

        // Return the head of the merged list, skipping the dummy node
        return headDummy.next;
    }
}

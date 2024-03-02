// Add two numbers in LinkedList 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to hold the result
        ListNode result = new ListNode(0);
        // Pointer to traverse the result list
        ListNode ptr = result;

        // Variable to hold carry during addition
        int carry = 0;

        // Continue until both lists are traversed completely
        while (l1 != null || l2 != null) {
            // Initialize sum with carry
            int sum = carry;

            // Add values from l1 if it's not null
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add values from l2 if it's not null
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry for the next calculation
            carry = sum / 10;
            // Update sum to store only the unit's place value
            sum = sum % 10;

            // Create a new node with the sum and attach it to the result list
            ptr.next = new ListNode(sum);
            // Move the pointer to the next node
            ptr = ptr.next;
        }

        // If there's a remaining carry, add it as a new node
        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        // Return the next of the dummy node, which holds the actual result
        return result.next;

    }
}

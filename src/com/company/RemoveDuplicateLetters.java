package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
 the smallest in lexicographical order(dictionary order) among all possible results.*/

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<Character,Integer>();
        HashSet<Character> seen = new HashSet<Character>();

        // Store the last occurrence index of each character in the string
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is already present in the stack, skip it
            if (seen.contains(c))
                continue;

            // Pop characters from the stack if they are greater than current character and still have occurrences later
            while (!stack.isEmpty() && c < stack.peek() && i < lastOccurrence.get(stack.peek())) {
                seen.remove(stack.pop());
            }

            // Add the current character to the stack and mark it as seen
            stack.push(c);
            seen.add(c);
        }

        // Construct the result string from the characters in the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "bcabc";
        String s2 = "cbacdcbc";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + removeDuplicateLetters(s1));

        System.out.println("Input: " + s2);
        System.out.println("Output: " + removeDuplicateLetters(s2));
    }

}
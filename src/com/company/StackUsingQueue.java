package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1;

    Queue<Integer> q2;

    /** For 2 queues */
//    public StackUsingQueue() {
//        q1 = new LinkedList<Integer>();
//        q2 = new LinkedList<Integer>();
//    }
    public StackUsingQueue() {
        q1 = new LinkedList<Integer>();

    }

    public void push(int x){
        q1.add(x);
        for (int i = 1; i < q1.size() ; i++) {
            q1.add(q1.remove());

        }
    }
/** For 2 queue */
//    public void push(int x) {
//        q1.add(x);
//    }


    public int pop(){
        return q1.remove();

    }
/** for 2 queue */
//    public int pop() {
//        if (q1.isEmpty())
//            return -1;
//
//        // Move all elements except the last one from q1 to q2
//        while (q1.size() > 1) {
//            q2.add(q1.remove());
//        }
//
//        // Remove and return the last element from q1
//        int poppedElement = q1.remove();
//
//        // Swap the references of q1 and q2
//        Queue<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//
//        return poppedElement;
//    }
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }

        return q1.peek();


    }
/** for 2 queues */
//    public int top() {
//        if (q1.isEmpty())
//            return -1;
//
//        // Move all elements from q1 to q2 except the last one
//        while (q1.size() > 1) {
//            q2.add(q1.remove());
//        }
//
//        // The last element in q1 is the top element
//        int topElement = q1.peek();
//
//        // Move the last element back to q1
//        q2.add(q1.remove());
//
//        // Swap the references of q1 and q2
//        Queue<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//
//        return topElement;
//    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();


        System.out.println("size is " + stack.size());

        while (!stack.empty()) {
            System.out.println(stack.top());
            stack.pop();
        }
    }
}

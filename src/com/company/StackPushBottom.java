package com.company;

import java.util.Stack;

public class StackPushBottom {
    public static void pushBottom(int num, Stack<Integer> stack){

        if(stack.isEmpty()){
            stack.push(num);
            return;
        }

        int top = stack.pop();
        pushBottom(num,stack);
        stack.push(top);

    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushBottom(top,s);



    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reverseStack(s);


        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}

package com.comapny;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        // Create number Stack
        Stack<Integer> numStack = new Stack<Integer>();
        // Create syring stack
        Stack<String> stringStack = new Stack<String>();
        int k=0;

        for(char c : s.toCharArray()){
            //if we get number add to num stack

            if(Character.isDigit(c)){
                k = (k*10)+(c-'0');
                continue;
            }
            if(c == '['){
                numStack.push(k);
                k=0;
                stringStack.push(String.valueOf(c));
                continue;
            }
            if(c != ']'){
                stringStack.push(String.valueOf(c));
                continue;
            }

            StringBuilder temp = new StringBuilder();
            while(!stringStack.peek().equals("[") ){
                temp.insert(0, stringStack.pop());
            }
            //pop ]
            stringStack.pop();

            StringBuilder replacement = new StringBuilder();
            int count = numStack.pop();
            for(int i=0; i<count; i++){
                replacement.append(temp);
            }

            // add it to stack
            stringStack.push(replacement.toString());

        }

        StringBuilder result = new StringBuilder();
        while(!stringStack.empty()){
            result.insert(0,stringStack.pop());
        }
        return result.toString();

    }
}


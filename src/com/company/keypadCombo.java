package com.company;

import java.util.ArrayList;
import java.util.List;

public class keypadCombo {
    String[] keyPad = { "","", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if(digits.length() == 0){
            return result;
        }

        generateCombination("",digits,result);
        return result;
    }
    public void generateCombination(String current, String digits, ArrayList<String> result) {
        if(digits.length()==0){
            result.add(current);
            return;
        }
        String key = keyPad[digits.charAt(0) - '0'];

        for (int i = 0; i < key.length(); i++) {
            generateCombination(current+key.charAt(i),digits.substring(1),result);

        }
    }

    public static void main(String[] args) {
        keypadCombo obj = new keypadCombo();
        List<String> combinations = obj.letterCombinations("23");
        System.out.println(combinations);
    }




}

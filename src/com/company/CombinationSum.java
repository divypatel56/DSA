package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrace(0,candidates,result,new ArrayList<Integer>(),target);
        return result;
    }

    public void backtrace(int start, int[] candidates,List<List<Integer>> resultList,
                          ArrayList<Integer> tempList, int target){

        if(target == 0){
            resultList.add(new ArrayList<Integer>(tempList));
        }
        if(target < 0){
            return;
        }


        for(int i=start; i<candidates.length; i++ ){
            tempList.add(candidates[i]);

            backtrace(i,candidates,resultList,tempList,target-candidates[i]);

            tempList.remove(tempList.size()-1);


        }

    }
}


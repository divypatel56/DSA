class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrace(nums, new ArrayList<Integer>(), result, new boolean[nums.length]);
        return result;
        
    }

    public void backtrace(int[] nums, ArrayList<Integer> tempList, 
    List<List<Integer>> resultList, boolean[] used){
        //Base case
        if(tempList.size()==nums.length && !resultList.contains(tempList)){
            resultList.add(new ArrayList<Integer>(tempList));
        }



        for(int i =0; i<nums.length; i++){
            if(used[i]) continue;

            //choose to add
            tempList.add(nums[i]);
            used[i] = true;

            backtrace(nums, tempList, resultList, used );

            //choose to skip
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }
}

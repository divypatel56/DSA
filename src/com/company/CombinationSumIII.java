class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrace(1,9,new ArrayList<Integer>(),result,k,n);
        return result;
        
    }
    public void backtrace(int start,int end, List<Integer> tempList,
    List<List<Integer>> resultList ,int k, int n){
        if(n==0 && tempList.size()==k){
            resultList.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=start; i<=end; i++){
            tempList.add(i);
            backtrace(i+1,end,tempList,resultList,k,n-i);
            tempList.remove(tempList.size()-1);
        }
    }
}

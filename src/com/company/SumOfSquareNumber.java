class Solution {
    public boolean judgeSquareSum(int c) {
        //Base case
        if(c < 0){
            return false;
        }
        //Make two pointers
        long front = 0;
        long tail = (int)Math.sqrt(c);

        while( front <= tail){
            long sum = front*front + tail*tail;

            if( sum == c){
                return true;
            }
            else if( sum < c ){
                front++;
            }
            else{
                tail --;
            }
        }
        return false;
        
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

         // Iterate through the asteroids
        for(int i=0; i<asteroids.length; i++){
             // If stack is empty or current asteroid is moving right, add it to stack
            if(stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
            }
            else{
                // Handle collision with asteroids moving left
                while(!stack.isEmpty()){
                    
                    int top = stack.peek(); 
                    // If top element is already moving left, push current asteroid and break
                    if(top < 0){
                        stack.push(asteroids[i]);
                        break;
                    }
                     // Calculate absolute value of current asteroid
                    int modVal = Math.abs(asteroids[i]);{
                         // If sizes of both asteroids are equal, destroy both and break
                        if( top == modVal){
                            stack.pop();
                            break;
                        }
                         // If top asteroid is larger, destroy current asteroid and continue loop
                        else if(top > modVal){
                            break;
                        }
                        // If top asteroid is smaller, destroy it and continue loop
                        stack.pop();
                        // If stack becomes empty, push current asteroid and break

                        if(stack.isEmpty()){
                            stack.push(asteroids[i]);
                            break;
                        }

                    }
                }
            }
        }
         // Convert stack to array for output
        int[] result = new int[stack.size()];
        for(int i = result.length-1; i>=0; i--){
            result[i] = stack.pop();

        }
        return result;
        
    }
}

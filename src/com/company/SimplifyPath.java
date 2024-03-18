//LeetCode Problem stack related
class Solution {
    public String simplifyPath(String path) {
        //make stack
        Stack<String> stack = new Stack<String>();
        //make string builder to return the canonical path
        StringBuilder sb = new StringBuilder();
        //Split path by "/" and add it to array
        String[] pathArr = path.split("/");

        for(int i=0; i<pathArr.length;i++){
            // if stackis not empty & i== .. --> pop
            if(!stack.isEmpty() && pathArr[i].equals("..")){
                stack.pop();
            }
            // else if stack is not empty & i!=. & i!=.. --> push
            else if(!pathArr[i].equals("") && !pathArr[i].equals(".")
            && !pathArr[i].equals("..")){
                stack.push(pathArr[i]);
            }
        }

        if(stack.isEmpty()){
            return "/" ;
        }
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
            
        }
        return sb.toString();


        
    }
}

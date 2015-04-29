public class Solution {
    public int trap(int[] height) {
        if(height==null||height.length<3)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            if(stack.empty())
                stack.push(i);
            else if(height[i]<height[stack.peek()]) {
            	stack.push(i);
            }
            else if(height[i]==height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else if(height[i] > height[stack.peek()]) {
            	if (stack.size()==1) {
            		stack.pop();
            		stack.push(i);
            	} else {
            		int low = stack.pop();
            		while(!stack.empty()&&height[i] > height[low]) {		
            			if(height[stack.peek()]<height[i]) {
            				int j = stack.pop();
	            			res = res + (i - j - 1)*(height[j] - height[low]); 
	            			low = j;
            			} else {
            				int j = stack.pop();
            				res = res + (i - j - 1)*(height[i] - height[low]);
            				stack.push(j);
            				low = i;
            				break;
            			}
            		}
            		if(!stack.empty())
            			stack.push(low);
            		else
            			stack.push(i);
            	}
            }
        }
        return res;
    }
}
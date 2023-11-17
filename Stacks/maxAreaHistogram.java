package Stacks;
import java.util.*;



public class maxAreaHistogram {
    public static void maxArea(int arr[]){
        int maxArea= 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        //next smaller right:
        Stack<Integer> s = new Stack<>(); //not a stack for heights but indexes,starts empty and fills according to requirements, pushes in every
                                        //index but looks for the one smaller in the order assigned by the for loop.
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();        //we wont ever need the popped one because for the next element, nsr will just be the current one now
            }
            if(s.isEmpty()){
                nsr[i] = arr.length; //one index after the last one so we know
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left:
        s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;   //one index before 0 so we know nothing exists before this .
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //area:
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1 ;  //width = j-i-1 = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println("max area of histogram is:" + maxArea);
    }
    public static void main(String args[]){
        int heights[] = {2,4};
        maxArea(heights);
    }
}

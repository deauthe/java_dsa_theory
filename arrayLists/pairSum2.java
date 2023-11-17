import java.util.*;
public class pairSum2 {
    ////find if any pair given in the SORTED and ROTATED arraylist gives a target sum of 5?
    public static void sumFinder(ArrayList<Integer> arr,int targetSum){
        //find the breaking point of this rotated array;
        int breakingPoint =0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>arr.get(i+1)){
                breakingPoint= i+1;
                break;
            }
        }
        //11,15,6,8,9,10 =>array
        int left = breakingPoint;
        int right= breakingPoint-1;
        
        while(arr.get(left)<arr.get(right)){
            int sum= arr.get(left)+arr.get(right);
            if(sum == targetSum){
                System.out.println(left + " and " + right + " is the index "
                                 + "with numbers " + arr.get(left)+ " and "
                                 + arr.get(right)+" giving sum = "+ targetSum );  
                //left++     
                System.out.println("left++");

                if(left<=arr.size()-1){
                    left++;
                }
                else{
                    left = 0;
                }
                //right--
                System.out.println("right--");

                if(right-1>=0){
                    right--;
                }
                else{
                    right=arr.size()-1;
                }
                if(left==arr.size() || right==arr.size()){
                    return;
                }
                //to find any more possible solutions
                
            }
            else if(sum>targetSum){
                System.out.println("right--");
                if(right-1>=0){
                    right--;
                }
                else{
                    right=arr.size()-1;
                }
            }
            else if(sum<targetSum){
                System.out.println("left++");

                if(left<=arr.size()-1){
                    left++;
                }
                else{
                    left = 0;
                }
            }
        }
        

    }
    public static void main(String args[]){
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(11);
        elements.add(15);
        elements.add(6);
        elements.add(8);
        elements.add(9);
        elements.add(10);
        int targetSum = 21;
        sumFinder(elements,targetSum);
}
}
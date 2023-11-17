import java.util.*;

public class twoPointerApproach {
    public static int twoPoint(ArrayList<Integer> heights){
        int right = heights.size()-1;
        int left =0;
        int maxWaterStored = 0;
        while(left<right){
            int Currheight = Math.min(heights.get(left), heights.get(right));
            int currWidth = right - left ; 
            int currWaterStored = Currheight* currWidth ; 
            if(currWaterStored>maxWaterStored){
                maxWaterStored = currWaterStored;
            }
            if(heights.get(left)<=heights.get(right)){
                left++;
            }
            else{
                right--;
            }
        }   
        return maxWaterStored;
        
    }
    public static void main(String args[]){
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        int ans = twoPoint(heights);
        System.out.print(ans);

    }
}

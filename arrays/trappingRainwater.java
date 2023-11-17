package arrays;

public class trappingRainwater {

    public static void displayArray(int Array[])
    {
        for(int i =0 ; i<Array.length ; i++ )
        {
            System.out.print(Array[i] + " ");
        }
        System.out.println() ; 
    }
    public static int rainwaterCalculator(int heights[]){
        int leftMax[] = new int[heights.length] ; 
        leftMax[0] = heights[0];
        for (int i = 1 ; i< heights.length;i++) //notice the range
        {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]); //notice that we used leftmax for i-1 index
            
        }

        int rightMax[] = new int[heights.length] ; 
        rightMax[heights.length - 1] = heights[heights.length-1] ; 
        for(int i = heights.length - 2; i>= 0 ; i--) //notice initial value, range
    {
        rightMax[i] = Math.max(rightMax[i+1], heights[i]);
    }   
         // displayArray(leftMax);
        // displayArray(rightMax);

        int trappedWater = 0;
        int waterLevel = 0;
        for(int i =0; i<heights.length; i++)
        {
            waterLevel = Math.min(leftMax[i], rightMax[i]) ;
            trappedWater += waterLevel - heights[i] ; 

        }
        return trappedWater ; 
    }
    public static void main(String args[])
    {
        //making separate arrays for left max and right max boundaries.
        //if the tower is the tallest in its vicinity then boundaries will be equal to its height
        int input[] = {4,2,0,6,3,2,5} ; 
        System.out.print(rainwaterCalculator(input));

    }
}

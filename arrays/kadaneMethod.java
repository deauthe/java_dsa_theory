package arrays;
import java.util.* ; 

public class kadaneMethod {
    public static void main(String args[])
    {
        int maxSum = Integer.MIN_VALUE ; 
        int currSum = 0; 
        int numbers[] = {-2,-3,4,5,-2,1,-1,-3} ; 

        //calculating the cs by adding numbers periodically in the arrays
        //a modification of this code will work when all the numbers are negative as the cs will never get above zero
        //for that rather than making cs 0, make it the smallest number in the array as the threshold .
        for(int i = 0; i<numbers.length ; i++)
        {
            currSum = currSum + numbers[i] ; 
            if(currSum<0)
            {
                currSum = 0 ;
            }
            maxSum = Math.max(currSum,maxSum); 

        }
        System.out.println(currSum +"kdakjdhakjd "+ maxSum);
    }
}
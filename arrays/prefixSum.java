package arrays;
import java.util.*;

public class prefixSum {
    //to calculate max sum of a subarray 
    //creating a prefix array

    public static void displayArray(int Array[])
    {
        for(int i =0 ; i<Array.length ; i++ )
        {
            System.out.print(Array[i] + " ");
        }
    }
    public static void main(String args[])
    {
            int numbers[] = {1,5,4,7,-9};
            int maxSum = Integer.MIN_VALUE ; 
            int prefix [] = new int[numbers.length]; 
            int sum = 0 ;

            //to make the prefix array
            for(int i = 0 ; i < numbers.length ; i++)
            {
                for(int j = i; j>=0 ; j--)
                {
                    sum= sum + numbers[j] ;
                    
                }
                prefix[i] = sum;
                sum = 0 ;
            }
            displayArray(prefix);
            int currSum =0;
            for(int i = 0 ; i < numbers.length ; i++)
            {
                
                for(int j = i; j<numbers.length ; j++)
                {
        
                    
                    currSum = i==0? prefix[j] : prefix[j] - prefix[i-1];
                    if(maxSum < currSum)
                    {
                        maxSum = currSum ; 
                    }
                }
           
            
    }   
    
    System.out.println();
    System.out.println(maxSum);
}}
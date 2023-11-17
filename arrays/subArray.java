import java.util.* ; 
//fun question
public class subArray {
    public static void main(String args[])
    {
        int numbers[] = {2,4,6,8}; 
        for(int i =0; i<numbers.length; i++)
        {
            int start = i;
            for(int j=start ; j<numbers.length ; j++)
            {
                int end= j;
                for(int k = start; k<=end; k++)
                {   //just to print
                    System.out.print(numbers[k] + " ") ; 
                }
                System.out.println();

            }
            System.out.println() ; 
        }
    }
    
}

package patterns;
import java.util.* ;
public class butterflyPattern {
    public static void main(String args[])
    {
        int r = 6 ;
        //first half
        for(int i = 1; i<=r; i++)
        {
            for(int u =1;u<=i; u++)
            {   

                System.out.print("*");
            }
            for(int u = 1; u<=2*(r-i); u++)
            {
                System.out.print(" ");

            }
            for(int u =1;u<=i; u++)
            {   

                System.out.print("*");
            }
            System.out.println();
        }
        //second half(outerloop flipped)
    
        for(int i = r; i>=1; i--)
        {
            for(int k =1;k<=i; k++)
            {   

                System.out.print("*");
            }
            for(int k = 1; k<=2*(r-i); k++)
            {
                System.out.print(" ");

            }
            for(int k =1;k<=i; k++)
            {   

                System.out.print("*");
            }
            System.out.println();
        }
}
}
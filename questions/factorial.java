
package questions;
import java.util.* ; 

public class factorial {
    public static void main(String args[])
    {   
        Scanner sc = new Scanner(System.in) ; 
        int n = sc.nextInt();
        int factorial = 1 ; 
        if(n!=0){
            for(int i = 1 ; i<=n ; i++){
                factorial = factorial * i ;

            }

        }
        else{
            factorial = 1 ; 
        }

        System.out.print("the factorial of the given number " + n + " is " + factorial);
       

    }
    
}

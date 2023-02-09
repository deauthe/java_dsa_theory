package bitmanipulation;
import java.util.* ; 

public class oddOrEven {
    public static boolean Check(int number){
        int bitmask =1 ;
        if((number & bitmask) == 0){
            //even number
            /*odd numbers have end digit in binary form = 1
             * so the & operator will return just 1 if the number 
             * is odd
             */
            return false ; 
        }
        else{
            return true;
        }
        }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in) ; 
        int number = sc.nextInt() ;

        if(Check(number)==true){
            System.out.print("odd") ; 
        
        }
        else{
            System.out.print("even") ; 
            
        }

    }
    }


package patterns;
import java.util.* ; 
public class halfPyramidNumbers {
    public static void main(String args[]){
        int r,c ; 
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = r ;
        for ( int i = 1 ; i <= r ; i++)
        {
            for(int j = 1 ; j<= c;  j++)
            {
                System.out.print(j) ; 
            }
            c -=1 ; 
            System.out.println("");
        }
    }
}

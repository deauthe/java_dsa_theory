package patterns;
import java.util.* ; 

public class hollowrectangle {
    /**
     * @param args
     */
    public static void main(String args[]){
        int r,c ;
        Scanner sc = new Scanner(System.in) ;
        r = sc.nextInt() ; 
        c = sc.nextInt() ; 
       for(int i = 1; i<=r ;i++){
        if(i == 1 || i==r ){
            for(int j= 1; j<=c ; j++){
                System.out.print("*");
            }
        }
        else{
            for(int j =1 ; j<=c ; j++){
                if(j==1 || j==c){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
        }
        
        System.out.println("");
       } 
    }
}

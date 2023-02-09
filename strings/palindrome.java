package strings;
import java.util.* ;

public class palindrome {
    public static boolean IsPalindrome(String str ){
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return false;
                

            }   
            else{
                continue ; 
            }      
        }
        return true ;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        System.out.print(IsPalindrome(str)) ; 
    }
}

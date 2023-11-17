package RECURSION;

public class optimizedPower {
    public static int OP(int a,int n){
        if(n==0){
            return 1;
        }
        int half = OP(a,n/2);
        int halfsq = half*half ; 
        if(n%2!=0){ // for the recursive part above, n will be n/2 yayy
            halfsq = a*halfsq;

        }
    return halfsq; 
}
    public static void main(String args[]){
        int a =2;
        int n = 8;
        
        System.out.println(OP(a,n)) ; 

        }
    }


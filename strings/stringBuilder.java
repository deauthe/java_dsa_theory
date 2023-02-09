package strings;

public class stringBuilder {
    /*".toString is something that can convert any "object 
     * to a string but,it has to be an object.
     * for ex:
     * int a = 10; here a cannot be converted to a string with this 
     * however 
     * Integer a =10 ;  can as it's an object
     */
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("") ;
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
            //0(26)
            //0(n^2) if we used the normal concatination method.

        }
        System.out.print(sb) ;
    }
}

package backtracking;

public class permutations {
    
    public static void permutations(String str,String ans){
        //base case:
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<=str.length()-1; i++){
            char curr= str.charAt(i);
            //deleting current char from string and then making another string without it.
            String newStr = str.substring(0,i) + str.substring(i+1); //this line just leaves out ith character;
            //abcde = ab + c + de if c was my current char
            //new str would be abde
            
            permutations(newStr, ans+curr);

        }

    }

    public static void main(String args[]){
        permutations("abr", "");
    }
}

package backtracking;

public class subsets {
    public static void PrintSubsets(String str,String ans,int index){
        //base case
        if(index==str.length())
        {
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return; 
        }

        //recursio:
        
        PrintSubsets(str, ans+str.charAt(index), index+1);//Yes, character accepts to be in answer
        PrintSubsets(str, ans, index+1);//No
        
    }

    public static void main(String args[]){
        String ans = "" ;
        String str = "abc";
        PrintSubsets(str, ans, 0);
    }
}

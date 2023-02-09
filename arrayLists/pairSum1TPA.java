import java.util.ArrayList;

public class pairSum1TPA {
    
    
    //find if any pair given in the SORTED arraylist gives a target sum of 5?
    
    public static void TPA(ArrayList<Integer> elements,int targetSum){
        int right = elements.size()-1;
        int left=0;
        while(elements.get(right)>targetSum){
            right--;//because sorted

        }
        
        while(left<right){
            int sum = elements.get(left)+ elements.get(right) ; 
            if(sum == targetSum){
                System.out.println(left + " and " + right + " is the index "
                                 + "with numbers " + elements.get(left)+ " and "
                                 + elements.get(right)+" giving sum = "+ targetSum );  
                left++;
                right--;
                //to find any more possible solutions
            }
            else if(sum>targetSum){
                right--;
            }
            else if(sum<targetSum){
                left++;

            }
            
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(6);


        TPA(elements,5);
    }
}

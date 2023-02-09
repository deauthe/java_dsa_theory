import java.util.ArrayList;

public class CWMW{
    public static int maxWater(ArrayList<Integer> heights){
        int maxWaterStored = 0;
        for(int i=0;i<heights.size();i++){
            for(int j=i+1;j<heights.size();j++){
               int ht = Math.min(heights.get(i),heights.get(j));
               int width = j-i;
               int waterStored = ht*width ;
               maxWaterStored = Math.max(maxWaterStored, waterStored);
               
               
            }
        }
        return maxWaterStored; 
    }
    public static void main(String args[]){
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        int ans = maxWater(heights);
        System.out.print(ans);

    }
}
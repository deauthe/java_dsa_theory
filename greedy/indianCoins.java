package greedy;

import java.util.Arrays;
import java.util.Comparator;
//find the least amount of coins used to get the number needed.
public class indianCoins {
    public static void Denomination(int x,Integer coins[]){
        int count = 0;
        
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=x){
                while(coins[i]<=x){
                    x=x-coins[i] ; 
                    count++;
                }
            }
            

        }
        System.out.print(count);
    }
    public static void main(String args[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        int need = 590;
        for(int i=0;i<coins.length;i++){
            System.out.print(coins[i] + " ");
        }
        System.out.println(" ");
        Denomination(need,coins);
    }
}

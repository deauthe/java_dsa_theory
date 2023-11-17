package questions;

import java.util.Scanner;

public class reverseNumber {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int reverse = 0; 

        while(number>0){
            int LastDigit = number%10;
            reverse = (reverse*10) + LastDigit ; 
            number = number/10 ; 
        }
        System.out.println("the reverse number is :");
        System.out.print(reverse);
    }
    
}

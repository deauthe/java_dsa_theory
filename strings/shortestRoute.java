package strings;
import java.util.*;
public class shortestRoute {
    //given a path, find the shortest route to destination.
    public static void main(String args[]){
        String path = "WNEENESENNN";
        ShortestRoute(path);


    }
    public static int ShortestRoute(String str){
        int h =0;
        int v=0 ; 
        
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i)=='N'){
                v +=1 ;
            }
            if(str.charAt(i)=='S'){
                v-=1;
            }
            if(str.charAt(i)=='W'){
                h-=1;
            }
            if(str.charAt(i)=='E'){
                h+=1;
            }
        }
        System.out.println(v + "" + h);
        System.out.println("the shortest path to the dsetination is:") ; 
        if(v>0){
            for(int i =1;i<=v;i++){
            System.out.print("N");
            }
        }
        else if(v<0)
        {
            for(int i =1;i<=(-v);i++){
                System.out.print("S");
                }
        }
        if(h>0){
            for(int i =1;i<=h;i++){
            System.out.print("E");
            }
        }
        else if(h<0)
        {
            for(int i =1;i<=(-h);i++){
                System.out.print("W");
                }
        }
        

        return 0;
    }
}

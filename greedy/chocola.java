package greedy;

import java.util.Collections;
import java.util.*;

public class chocola {
    //the problem has the alternate name:cut board into squares:
    public static void main(String args[]){
        int n=4, m=6;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2}; //n-1

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp = 1; //pieces: the whole of the piece is a hp and a vp;
        int cost = 0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<= costHor[h]){//horizontal cut
                cost+= costHor[h]*vp;
                hp++;
                h++;
            }else{
                cost+= costVer[v]*hp;//vertical cut
                vp++;
                v++;
            }
        }
        //for left cuts;
        while(h<costHor.length){
            cost+= costHor[h]*vp;
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost+= costVer[v]*hp;
            vp++;
            v++;
        }

        System.out.println("minimum cost of cutting the board is:" + cost);
    
    }
}

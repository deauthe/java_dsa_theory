import java.util.*;
public class operations{
    public static void PrintList(ArrayList list){
        System.out.print(list);
        System.out.println();
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>() ; 
        list.add(1);
        list.add(10);
        list.add(4);
        list.add(6);
        list.add(2);

        Collections.sort(list);
        PrintList(list);


        Collections.sort(list, Collections.reverseOrder()); //the order defining function here
                                                            //is called a comparator
        PrintList(list); 

        list.set(2, 88);
        PrintList(list);

    }
}

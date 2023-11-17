package bitmanipulation;

public class manipulation {
    public static int GetIthBit(int number,int place){
        //using left shift in 1 to get the desired index:
        
        int bitmask = 1<< place ; 
        if((number&bitmask)==0){
            return 0;
        }
        else{
            return 1 ;
        }
        
    }
    public static int SetIthBit(int number,int place){
         int bitmask = 1<<place ; 
         return number|bitmask ; 

    }
    public static int ClearIthBit(int number,int place){
        int bitmask =1<<place ;
        return number&(~(bitmask)) ; //observe

    }
    public static void UpdateIthBit(int number,int place,int newBit){
        if(newBit==0){
            ClearIthBit(number, place);

        }
        else{
            SetIthBit(number, place);
        }
    }
    public static int ClearIBits(int number,int place){
        int bitmask = ~0<<place ; 
        return number&bitmask;
        //learn this tild concept please
    }
    public static int ClearRangeOfBits(int start,int end){
        //continue bitmanipulation from here,cant do this anymore.
        return 0 ;
    }
}
    

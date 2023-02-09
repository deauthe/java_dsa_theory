import java.util.* ;
public class typeCasting
{
    public static void main(String args[])
    {
        int a = 25 ; 
        float b = a ; //allowed since float is bigger than int
        a = (int)b ; //have to specify the type to convert in due to loss of data in coversion
        //since a is int and b is float
    }
}
//forcefully changing a bigger type size into a  smaller size data type
//for ex: an int to short
//the float turns to int by removing all the decimal numbers without rounding off.

/* 
similarly when operating on different types together the types are 
converted to the biggest in the expression.
so 
byte b = 5;
b = b* 2 ;  is not a right statement as when multiplying it with 2
            it got shifted to being an integer. 
so the right way to right it is 
b = (byte) (b*2);

*/
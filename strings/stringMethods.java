package strings;

public class stringMethods {
    /*comparing: 
    to compare two strings in java, we cannot use the ==
    as when we declare a string with the "new" keyword, only then
    it creates a new object and normally declaring a string will
    just omit an already existing string to the given content.
    when comparing with == operator it checks if the object is
    the same. however two strings with the exctly same content
    can be two different objects so it might return false.
    to compare two objects's contents we use:
    */
    public static void main(String args[]){
        String s1 = "tont" ; 
    String s2 = new String("tont") ;
    System.out.print(s1.equals(s2)) ;
        /*this is the reason that time complexity of a loop
         * where we constantly change a string is not just
         * depending on the loop iterations, but also on the 
         * string length as the object is being copied and being pointed to a different 
         * string content rather than creating a string.
         * for example:
         */
    for(int i=0;i<=10; i++){
        s1 += i ; 
    }
    //this would give tont1,tont12,tont123... and so on
    //with s1 pointing to the new string content without a new object being created
    //so the time complexity becomes: 0(x*n)
    //where x=stringLength and n = loop iterations.
    //so as to avoid this poor time complexity,we use String builder.
    /*concatination in strings can be done just like with 
      variables.

     */
    s1.compareTo(s2) ;
    //this function gives three types of outputs:
    //0: if strings are same
    //<0: if s1<s2
    //>0: if s1>s2
    //the comparing part is not on the basis of size but
    //on the basis of characters like in a dictionary.
    //a<b ; 

    }
    //read about "intern() method that creates a copy of the content existing in heap
    //stack to the string constant pool, if one is already in the pool,the new reference
    //will be called instead, this helps to save space"
}   
/*read about stringbuffer, 
 *  It is identical to StringBuilder except for one important difference: it is not synchronized,
 *  which means that it is not thread-safe. The advantage of StringBuilder is
 *  faster performance. However, in cases in which you are using 
 * multithreading,  you must use StringBuffer rather than StringBuilder.
*/

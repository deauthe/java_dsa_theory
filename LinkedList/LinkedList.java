package LinkedList;

import java.lang.module.FindException;

public class LinkedList {
    public static class Node{
        int data;
        Node Next;

        public Node(int data){
            this.data= data; 
            this.Next = null; //assumption for every next
        }
    }   
    public static int size = 0;
    public static Node Head;
    public static Node Tail;

    public void addFirst(int data){ //didnt add "static here for a reason"
        Node newNode = new Node(data);
        if(Head==null){
            Head = Tail = newNode;
            return;
        }
        newNode.Next = Head;
        Head = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(Head==null){
            Head=Tail=newNode;
            return;

        }
        Tail.Next= newNode;
        Tail = newNode;
        size++;
        
    }

    public void Print(){
        if(isCycle()){
            removeCycles();
            Print();
            System.out.println("with a cycle at index:"+ NodeForCycle().data);
            return;
        }
        if(Head == null){
            System.out.print("empty");
        }
        Node temp = Head;
        
        while(temp!=null){
            System.out.print(temp.data);
            temp = temp.Next;
            if(temp!=null){
                System.out.print("->");
            }
        }
        System.out.println();
        return;
    }

    public void Add(int data,int index){
        Node newNode = new Node(data);
        Node temp = Head;
        int i = 0; 
        while(i<index-1){
            temp = temp.Next; 
            i++;

        }
        newNode.Next = temp.Next ; 
        temp.Next = newNode; 
        size++;

    }
    public void Remove(int index){
        Node temp = Head;
        int i= 0;
        while(i<index-1){
            temp = temp.Next;
            i++;

        }
        temp.Next = temp.Next.Next;
        size--;
    }
    public Node NodeForCycle(){
        if(isCycle()){
            Node slow = Head;
            Node fast = Head;
            while(fast!=null && fast.Next!=null){
                slow = slow.Next;
                fast = fast.Next.Next;
                if(slow==fast){
                    slow = Head;
                    while(slow!=fast){ //to make them meet at the node where cycle originates
                        slow = slow.Next;
                        fast = fast.Next;
                    }//prev become the node where cycle ends
                    
                }
                
            }
        
            return slow;
        }
        else{
            return null;
        }

    } 
    public void RemoveLast(){
        Node temp = Head; 
        if(size==0){
            System.out.println("list is empty rn");
            return;
        }
        if(size==1){
            Head=Tail=null;
        }
        else{
            for(int i=0;i<=size-2;i++){
                temp= temp.Next;
            }
        }
        temp.Next = null;
        Tail = temp ;
        size--;
        
    }
    public void RemoveFirst(){
        Head = Head.Next; 
        size--;//adding this line somehow is not printing proper sequence-> TODO
    }   
    public void Size(){
        System.out.println(size+1);
        
    }
    public void LinearSearch(int data){
        Node temp = Head ; 
        int i =0;
        while(temp!=null){
            if(temp.data == data){
                System.out.println("yes this exists on index:" + i);
                return;
            }
            temp = temp.Next;
            i++;
        }
        System.out.println("not here!");
        return;

    }
    public int Helper(Node Head,int key){  //helper for recursive search
        if(Head==null){
            return -1;
        }
        if(Head.data == key){
            return 0 ;
        }
        int idx = Helper(Head.Next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;

    }
    public void RecSearch(int key){  //didnt just use helper to avoid writing head as an argument everytime

        System.out.println( Helper(Head,key));
    }
    public void ReverseLL(){        //ideally just learn this by heart also understand
        Node curr = Tail=Head;
        Node prev = null;
        Node next;

        while(curr!=null){     
            next = curr.Next;
            curr.Next = prev;
            prev = curr;
            curr= next;
        }
        Head = prev;  //pretty important step
    }
    public void RemoveNthFromEnd(int n){ 
        Node temp = Head;
        int i=0;
        if(n==1){
            RemoveLast();   
            return;
        }
        if(n==size+1){ //because size() = size+1
            RemoveFirst();
            return;
        }
        //n>0
        while(i<(size-n)){            //because size() = size+1 and we needed the element before size+1-n
            temp = temp.Next;
            i++;
            System.out.println("i is now:"+ i); //debug line
        }

        temp.Next = temp.Next.Next;
        size--;

    }
    public Node findMidNode(Node Head){  //slow fast concept:
        Node slow = Head;
        Node fast= Head;
        while(fast!=null && fast.Next!=null){
            slow = slow.Next;
            fast = fast.Next.Next;
        }
        return slow; //slow is the midnode (first node of right part or exactly middle)
    }
    public boolean CheckPalindrome(){
        if(Head==null|| Head.Next==null){
            return true;
        }

        //find mid
        Node mid = findMidNode(Head);

        //reverse 2nd part:
        Node curr = mid;
        Node prev = null;
        Node next ;
        while(curr!=null){
            next= curr.Next;
            curr.Next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = Head;
        //check if equal:
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left = left.Next;
            right = right.Next;
        }
        return true;
    }
    public boolean isCycle(){
        Node slow = Head;
        Node fast = Head;
        while(fast!=null && fast.Next!=null){
            slow= slow.Next;
            fast = fast.Next.Next ; 
            if(slow == fast){ //ever
                return true;//cycle exists
            }
        }
        return false;
    }
    public void removeCycles(){
        if(isCycle()){
            Node slow = Head;
            Node fast = Head;
            while(fast!=null && fast.Next!=null){
                slow = slow.Next;
                fast = fast.Next.Next;
                if(slow==fast){
                    slow = Head;
                    Node prev = null;
                    while(slow!=fast){ //to make them meet at the node where cycle originates
                        slow = slow.Next;
                        prev = fast;
                        fast = fast.Next;
                    }//prev become the node where cycle ends
                    prev.Next = null; // cycle breaking line
                }
            }
        }
    }
    public void createCycle(int start){
        Node temp1 = Head;
        Node temp2 = Head;
        int i=0;
        while(i<start){
            temp1 = temp1.Next;
            i++;
        }
        i=0;
        while(temp2.Next!=null){
            temp2 = temp2.Next;
        } 
        temp2.Next = temp1;
    }
    public Node merge(Node LeftHead,Node RightHead){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL ; 
        while(LeftHead!=null && RightHead!=null){
            if(LeftHead.data>=RightHead.data){
                temp.Next= LeftHead;
                LeftHead = LeftHead.Next;
                temp= temp.Next;
            }
            else{
                temp.Next = RightHead;
                RightHead = RightHead.Next;
                temp = temp.Next ;
            }
        } 
        while(LeftHead!=null){
            temp.Next= LeftHead;
            LeftHead = LeftHead.Next;
            temp= temp.Next;
        }
        while(RightHead!=null){
            temp.Next = RightHead;
            RightHead = RightHead.Next;
            temp = temp.Next ;
        }
        return mergedLL.Next ; //.next because -1 was our dummy initialization 

    }
    public Node MergeSort(Node head){
        if(head==null || head.Next == null){
            return head;
        }
        //find mid
        Node mid = findMidNode(Head);
        
        //apply merge sort on left and right parts
        Node temp = Head;
        while(temp.Next!=mid){
            temp = temp.Next ; 
        }
        mid = temp;  //normally method gives us first node of right part,
                    //but for this we wanted last node of left part, so this shit was to get the prev element.
        Node RightHead = mid.Next;
        Node LeftHead = head;
        mid.Next = null; //to separate the left and right parts, wanted this particular node as mid for this line.
        Node newLeft = MergeSort(LeftHead);
        Node newRight = MergeSort(RightHead);

        //merge:
        return merge(newLeft,newRight);
    }
    public void convertToZigZag(Node Head){
        //1->n->2->(n-1)->3->(n-2).....
        //same as comparing left and reversed second part in palindrome, but instead of comparing we join
        //find mid:
        Node mid = findMidNode(Head);
        //reverse 2nd part:
        Node curr = mid;
        Node prev = null;
        Node next ;
        while(curr!=null){
            next= curr.Next;
            curr.Next = prev;
            prev = curr;
            curr = next;
        }
        Node RightH = prev;
        Node LeftH = Head;
        //join zigzag parts:
        while(RightH!=null && LeftH!=null){
            Node nextL = LeftH.Next;//code for zigzag
            LeftH.Next = RightH;
            Node nextR = RightH.Next;
            RightH.Next = nextL;

            LeftH = nextL;//update
            RightH = nextR;

        }
    }
    public void question3(int key1,int key2){
        //swapping keys by changing links not data:
        Node Prev1 = null,Curr1 = Head;
        Node Prev2 = null,Curr2= Head ; 
        while(Curr1!=null && Curr1.data!=key1){
            Prev1 = Curr1;
            Curr1 = Curr1.Next;
        }
        while(Curr2!=null && Curr2.data!=key2){
            Prev2 = Curr2;
            Curr2 = Curr2.Next;
        }
        if(Curr1==null||Curr2==null){
            return;
        }
        if(Prev1!=null){
            Prev1.Next = Curr2;
        }
        else{
            Head = Curr2;
        }
        if(Prev2!=null){
            Prev2.Next = Curr1;
        }
        else{
            Head = Curr1;
        }
        Node temp = Curr1.Next;
        Curr1.Next = Curr2.Next;
        Curr2.Next = temp;
        
        
    }
    public void question4(){
        Node EvenHead = null;
        Node OddHead = null;
        Node e= null;
        Node o = null;
        Node temp = Head;
        while(temp!=null){
            if(temp.data%2==0){
                if(EvenHead == null){
                    EvenHead = temp;
                    e = temp;         //no update
                }
                else{
                    e.Next = temp;
                    e = e.Next; //update
                }
            }
            else{
                if(OddHead==null){
                    OddHead = temp;
                    o =temp;//no update here
                }
                else{
                    o.Next = temp;
                    o = o.Next; //update
                }
            }
            temp = temp.Next; //update 
        }
        if(OddHead!=null){
            o.Next = null;
        }
        if(EvenHead!=null){
            e.Next = OddHead;
            Head = EvenHead; //this line modifies the ll, otherwise everything would've been just a useless task
            
            return ;
        }
        
        }

    
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.Print();
        ll.question3(3, 2 );
        ll.question4();
        ll.Print();
        
        
        
        

 //TODO: 1)cycle codes arent working properly, probably including the one mentioned in the print function.       
//       2) check palindrome function is removing nodes from the end.

}
}


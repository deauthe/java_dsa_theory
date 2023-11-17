package LinkedList;

public class DoublyLL {
    public static class Node{
        int data;
        Node Next;
        Node Prev;

        public Node(int data){
            this.data = data;
            this.Next= null;
            this.Prev = null;
        }
    }
    public static int size = 0;
    public static Node Head;
    public static Node Tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(Head==null){
            Head=Tail=newNode;
            return;
        }
        newNode.Next = Head;
        newNode.Prev = null;
        Head.Prev = newNode;
        Head = newNode;
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(Head==null){
            Head=Tail=newNode;
            return;
        }
        newNode.Prev = Tail;
        Tail.Next = newNode;
        Tail = newNode;
        size++;
    }
    public void removeFirst(){
        if(Head==null){
            return;
        }
        if(Head==Tail){
            Head =Tail = null;
            return;
        }
        Head = Head.Next;
        Head.Prev = null; //removed backward link
        Head.Prev.Next = null; //removed forward link
    }
    public void Print(){
        if(Head==null){
            System.out.println("empty");
            return;
        }
        Node temp = Head;
        while(temp!=null){
            System.out.print(temp.data);
            
            if(temp.Next!=null){
                System.out.print("<->");
            }
            temp = temp.Next;
        }
        System.out.println();
        return;
    }


    public static void main(String args[]){
        DoublyLL ll = new DoublyLL();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(2);
        ll.addLast(3);
        ll.Print();
    }
}

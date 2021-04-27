public class Node
{
    public String data;
    public Node next;
    
    //Insert to end
    public Node(String a)
    {this.data=a;}

    //Insert
    public Node(String a, Node n)
    { data=a;
      next=n;
    }
    
}

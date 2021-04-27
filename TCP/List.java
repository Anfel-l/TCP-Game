
import javax.swing.JOptionPane;

public class List
{   protected Node start, end;

    public List()
    {   start=null;
        end=null;
    }

    //EmptyList

    public Boolean isEmpty()
    {   if (start==null) 
        {return true;}
        return false;
    }

    //AddtoStart
    public void addtoStart(String s)
    {   //Create Node
        start = new Node(s, start);
        if (end==null) 
        { end=start;
        } 
    }

    //toString
    public void printList()
    {   Node a = start;
        String chain="";
        while(a != null)
        {   chain= chain+a.data + "\n";
            a=a.next;
        }
        JOptionPane.showMessageDialog(null, chain, "Received Messages", JOptionPane.CLOSED_OPTION);
    }

   

    


}
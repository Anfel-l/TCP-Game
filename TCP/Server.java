import java.net.*;
import javax.swing.JOptionPane;
import java.io.*;



public class Server 
{
    public static void main(String[] args) throws Exception
    {
        //Start socket on port 5000
        ServerSocket server = new ServerSocket (5000);

        //Message to client
        String msg = ("Hello client, I´m talking to you from server side \n");

        //Data received buffer
        byte[] data = new byte [256];
        System.out.println("Server starting..");

        List list1 = new List();

        try {
            
            Socket socket;
            DataInputStream dis;
            DataOutputStream dos;

            while(true)
            {   System.out.println("Server started, waiting for a client.. \n");

                //Accepting client and stablish comunication
                socket = server.accept();

                //Enable input client flow
                dis = new DataInputStream(socket.getInputStream());

                //Enable output client flow
                dos = new DataOutputStream(socket.getOutputStream());

                //Capture client's message
                String message = dis.readUTF();
                

                    if (message.equals("Ended")) 
                    {   
                        JOptionPane.showMessageDialog(null, "Server will be closed", "Warning", JOptionPane.CLOSED_OPTION);
                        System.exit(0);   
                    }
                    
                    else 
                    {   //Showing client's message
                        JOptionPane.showMessageDialog(null, "A client has been detencted", "Warning!", JOptionPane.CLOSED_OPTION);            
                        JOptionPane.showMessageDialog(null, "Client says: " + message , "Warning!", JOptionPane.CLOSED_OPTION);
                        JOptionPane.showMessageDialog(null, "Sending response: " + msg + "..." , "Warning!", JOptionPane.CLOSED_OPTION);
                        
                        list1.addtoStart(message);
                        list1.printList();


                        //Sending response
                        dos.writeUTF(msg);
                        //Closing input and output flow
                        dis.close();
                        dos.close();

                        //Closing socket
                        socket.close();
                    }     
            }
        } 
        catch (Exception e) 
        { JOptionPane.showMessageDialog(null, e.getMessage(), "Warning!",JOptionPane.CLOSED_OPTION);
        }   
    }
}

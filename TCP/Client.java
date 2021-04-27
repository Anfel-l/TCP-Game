import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;


public class Client
{
    public static void main(String[] args) throws Exception 
    {

        //Stablish a buffer with received data 
        byte [] data = new byte [256];

        //var where IP address is storaged
        String dirIP;

        
            try 
            {
            String msg;
                do {           
                    //Enable input label and capture IP server
                    System.out.println("Please enter IP address");
                    BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in)) ;
                    dirIP = rdr.readLine();

                    //message
                    msg = JOptionPane.showInputDialog(null, "Enter your message");
                    //Initialize comunication with server on port 5000
                    Socket socket = new Socket(dirIP, 5000);
                
                    //Enable input flow for the server on socket
                    DataInputStream din = new DataInputStream (socket.getInputStream());

                    //Enable output flow for the server on socket
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Sending message: " + msg);

                    //Send message converted into bytes
                    dos.writeUTF(msg);

                    //Read server message and convert it into a message chain
                    din.read(data, 0, data.length);
                    String message = new String(data);
                    JOptionPane.showMessageDialog(null, message, "Server Response", JOptionPane.CLOSED_OPTION);

                    
                
                } while (!msg.startsWith("Ended"));
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Warning!",JOptionPane.CLOSED_OPTION);
            }
               
    }
}
/*
Name: Joshua Honeycutt
File: Sever File
*/
import java.util.*;
import java.net.*;
import java.io.*;

class Server {
   
   public static void main(String[] args) throws Exception {
      
      // Setup sever, on port number 8090
      ServerSocket serverSocket = new ServerSocket(8090);
      Socket socket = serverSocket.accept();
      double number1, number2, sum;
      
      // Socket to send data to the client
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
      
      // Socket to get data from the client
      DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
      
      // numbers recieved from client
      number1= inFromClient.readDouble();   
      number2 = inFromClient.readDouble();
      
      // add the numbers
      sum = (number1 + number2);
      
      // send number out to the client
      outputToClient.writeDouble(sum);
      
      socket.close();
      
   }
}

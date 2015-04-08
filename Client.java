/*
Class: ITCS 3166
Name: Joshua Honeycutt
Program: Midterm project
File: Client File
*/
import java.io.*;
import java.net.*;
import java.util.*;
 
public class Client {

    public static void main(String[] args)throws Exception{
        
        // Setup the socket, localhost, and port number for server
        Socket socket = new Socket("localhost" , 8090 );
        double number1, number2;
        Scanner scan = new Scanner(System.in);
        
        // Socket to send data to the server
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        
        // Socket to get data from the server
        DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
        
        // Take input from user for the two numbers
        System.out.println("Enter a integer to send to the server: ");
        number1 = scan.nextDouble();
        System.out.println("Enter a second integer to send to the server: ");
        number2 = scan.nextDouble();
        
        // Send both numbers to the server
        outToServer.writeDouble(number1);
        outToServer.writeDouble(number2);
        
        // Get output from the sever and print it
        System.out.println("Sum of the numbers from server "+inFromServer.readDouble());
        
        socket.close();
    }
}
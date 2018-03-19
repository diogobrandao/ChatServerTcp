package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int portNumber = 5000;

        ServerSocket serverSocket = null;
        Socket clientSocket = null;



        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Listening on port: " + 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            clientSocket = serverSocket.accept();
            System.out.println("Connected: " + clientSocket.isBound());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //while(clientSocket.isBound()) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String message = in.readLine();
                System.out.println("Message:" + message);

            } catch (IOException e) {
                e.printStackTrace();
            }





    }
}

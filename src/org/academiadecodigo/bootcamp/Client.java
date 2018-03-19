package org.academiadecodigo.bootcamp;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException {
    }

    public static void main(String[] args) {

        String hostName;
        int port;
        String message;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Hostname: ");
        hostName = scanner.next();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter port: ");
        port = scanner1.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Message: ");
        message = scanner2.next();


        hostName = "localhost";
        port = 5000;

        Socket clientSocket = null;
        try {
            clientSocket = new Socket(hostName, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(message);
        //in.print();

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();

    }








}

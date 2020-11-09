package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Airport;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ClientServer {

    Airport airport = new Airport();

    public static void main(String[] args) {
        new ClientServer().launch();
    }

    public void launch() {

        try (ServerSocket server = new ServerSocket(7777)) {

            System.out.println("Server launched");

            while (true) {
                Socket clientSocket = server.accept();
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class ClientHandler implements Runnable {
        Socket clientSocket;
        BufferedReader reader;

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                reader = new BufferedReader(isr);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        @Override
        public void run() {
            System.out.println("new connection");

            String firstName = "";
            String lastName = "";
            String age = "";

            try {
                firstName = reader.readLine();
                lastName = reader.readLine();
                age = reader.readLine();

                Client cl = new Client(firstName, lastName, Integer.parseInt(age));
                airport.getRegistry().addClient(cl);
                System.out.println(cl);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}


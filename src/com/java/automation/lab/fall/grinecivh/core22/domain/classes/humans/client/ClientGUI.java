package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientGUI {
    JTextField firstNameField;
    JTextField lastNameField;
    JTextField ageField;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args){
        new ClientGUI().launch();
    }

    public void launch(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        ageField = new JTextField(15);

        JLabel firstNameLabel = new JLabel("First name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel ageLabel = new JLabel("Age");

        JButton sendButton = new JButton("Create");
        sendButton.addActionListener(new SendButtonListener());

        fieldPanel.add(firstNameLabel);
        fieldPanel.add(firstNameField);
        fieldPanel.add(lastNameLabel);
        fieldPanel.add(lastNameField);
        fieldPanel.add(ageLabel);
        fieldPanel.add(ageField);
        mainPanel.add(fieldPanel);
        mainPanel.add(sendButton);

        setUpNetwork();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(200,300);
        frame.setVisible(true);
    }

    private void setUpNetwork(){
        try {
            sock = new Socket("127.0.0.1", 7777);
            writer = new PrintWriter(sock.getOutputStream());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(firstNameField.getText());
                writer.println(lastNameField.getText());
                writer.println(ageField.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            firstNameField.setText("");
            firstNameField.requestFocus();
            lastNameField.setText("");
            ageField.setText("");
        }
    }

}

package com.mygame;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MyGame extends JFrame {

    JLabel heading, clockLabel;
    Font font = new Font("",Font.BOLD,40);
    JPanel mainPanel;
    JButton[] btns= new JButton[9];

    public MyGame() {
        System.out.println("MyGame Class");
        setTitle("Play Tic-Tac-Toe");
        setSize(500,500);
        ImageIcon icon = new ImageIcon("src/img/title.png");
        setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }

    private void createGUI(){
       // String BackgroundColor= String.valueOf(Color.LIGHT_GRAY);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        heading= new JLabel("Tic-Tac-Toe");
        heading.setIcon(new ImageIcon("src/img/title.png"));
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.add(heading, BorderLayout.NORTH);

        // creating object of JLabel for clock

        clockLabel= new JLabel("Clock");

        clockLabel.setFont(font);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setForeground(Color.WHITE);
        this.add(clockLabel, BorderLayout.SOUTH);

        Thread t= new Thread(){
            public void run(){
                try{
                    while(true){
                        String dateTime= new Date().toLocaleString();

                        clockLabel.setText(dateTime);

                        Thread.sleep(1000);
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();

        // Panel Section

        mainPanel= new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));

        for(int i=1; i<=9 ; i++) {
            JButton btn= new JButton();
            btn.setIcon(new ImageIcon("src/img/0.png"));
            btn.setBackground(Color.WHITE);
            btn.setFont(font);
            mainPanel.add(btn);
            btns[i-1]= btn;
        }
        this.add(mainPanel,BorderLayout.CENTER);
    }
}

package com.company;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
     setTitle("Snake");
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setSize(335,365);
     setLocation(400,400);
     Game game = new Game();
     add(game);
     addKeyListener(game);
     setVisible(true);
     setFocusable(true);
    }
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow();
    }
}

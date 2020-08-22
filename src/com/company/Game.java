package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Random;

import static java.awt.Font.BOLD;

public class Game extends JPanel implements ActionListener , KeyListener {
    int dots = 3;
    int SIZE = 20;
    int beginX = 120;
    int beginY = 120;
    int appleX;
    int appleY;
    Timer timer;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = true;
    private Image snake;
    private Image apple;
    private Image Background;
    boolean appleIsSet = true;
    int[] counterX = new int[255];
    int[] counterY = new int[255];
    boolean game = true;


    Game() {
        setImage();
setDots();

    }

    private void setImage() {
        ImageIcon pic = new ImageIcon("Snake.png");
        snake = pic.getImage();
        ImageIcon pic1 = new ImageIcon("apple.png");
        apple = pic1.getImage();
        ImageIcon picBack = new ImageIcon("Back.png");
        Background = picBack.getImage();
    }

    public void setDots(){
        for(int i = 0 ; i<dots;i++){
          counterX[i] = beginX-(i*SIZE);
          counterY[i] = beginY;
        }
     timer = new Timer(150,this);
     timer.start();
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Background,0,0,this);

       /* g.setColor(Color.black);
        g.drawLine(SIZE,0,SIZE,435);
        g.drawLine(SIZE*2,0,SIZE*2,435);
        g.drawLine(SIZE*3,0,SIZE*3,435);
        g.drawLine(SIZE*4,0,SIZE*4,435);
        g.drawLine(SIZE*5,0,SIZE*5,435);
        g.drawLine(SIZE*6,0,SIZE*6,435);
        g.drawLine(SIZE*7,0,SIZE*7,435);
        g.drawLine(SIZE*8,0,SIZE*8,435);
        g.drawLine(SIZE*9,0,SIZE*9,435);
        g.drawLine(SIZE*10,0,SIZE*10,435);
        g.drawLine(SIZE*11,0,SIZE*11,435);
        g.drawLine(SIZE*12,0,SIZE*12,435);
        g.drawLine(SIZE*13,0,SIZE*13,435);
        g.drawLine(SIZE*14,0,SIZE*14,435);
        g.drawLine(SIZE*15,0,SIZE*15,435);
        g.drawLine(SIZE*16,0,SIZE*16,435);
        g.drawLine(SIZE*17,0,SIZE*17,435);
        g.drawLine(0,SIZE,340,SIZE);
        g.drawLine(0,SIZE*2,340,SIZE*2);
        g.drawLine(0,SIZE*3,340,SIZE*3);
        g.drawLine(0,SIZE*4,340,SIZE*4);
        g.drawLine(0,SIZE*5,340,SIZE*5);
        g.drawLine(0,SIZE*6,340,SIZE*6);
        g.drawLine(0,SIZE*7,340,SIZE*7);
        g.drawLine(0,SIZE*8,340,SIZE*8);
        g.drawLine(0,SIZE*9,340,SIZE*9);
        g.drawLine(0,SIZE*10,340,SIZE*10);
        g.drawLine(0,SIZE*11,340,SIZE*11);
        g.drawLine(0,SIZE*12,340,SIZE*12);
        g.drawLine(0,SIZE*13,340,SIZE*13);
        g.drawLine(0,SIZE*14,340,SIZE*14);
        g.drawLine(0,SIZE*15,340,SIZE*15);
        g.drawLine(0,SIZE*16,340,SIZE*16);
        g.drawLine(0,SIZE*17,340,SIZE*17);*/

        g.setColor(Color.RED);
        g.drawImage(apple,appleX,appleY,this);
        g.setColor(Color.GREEN);
        for(int i = 0;i<dots;i++) {
            g.fillRect(counterX[i], counterY[i], SIZE, SIZE);
        }
        if(appleY == counterY[0]&& appleX==counterX[0]){
          appleIsSet = true;
          dots+=1;
        }
        if(counterY[0]< 0 ||counterY[0]>315 || counterX[0]< 0 || counterX[0] >310 ){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", BOLD, 30));
            g.drawString("Game Over",85,170);
            g.setFont(new Font("Arial", BOLD, 15));
            g.drawString("Press F to restart",102,200);
            game=false;
        }
        for(int i = 1; i<= dots;i++){
            if(counterX[0]== counterX[i] && counterY[0]==counterY[i]) {
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", BOLD, 30));
                g.drawString("Game Over",85,170);
                g.setFont(new Font("Arial", BOLD, 15));
                g.drawString("Press F to restart",102,200);
                game = false;
            }}


    }
    public void creatApple(){
        if(appleIsSet) {
            appleX = new Random().nextInt(16) * SIZE;
            appleY = new Random().nextInt(16) * SIZE;
            appleIsSet = false;
        }
    }
public void creatPlayse(){
        creatApple();
    for(int i = dots ;i > 0 ;i--) {
    counterY[i] = counterY[i-1];
    counterX[i] = counterX[i-1];
    }
        if (right) {
            counterX[0] += SIZE;
        }
        if (left) {
            counterX[0]  -= SIZE;
        }
        if (up) {
            counterY[0]  -= SIZE;
        }
        if (down) {
            counterY[0]  += SIZE;
        }

        repaint();

}
    @Override
    public void keyPressed(KeyEvent e) {
int key = e.getKeyCode();
if(key==KeyEvent.VK_F){
    dots = 3;
    for(int i = 0 ; i<dots;i++){
        counterX[i] = beginX-(i*SIZE);
        counterY[i] = beginY;
    }
    right = true;
    left = false;
    up = false;
    down = false;
    game = true;
}
if(key == KeyEvent.VK_RIGHT){
    if(left==true) {
    }else{
right = true;
up=false;
down=false;
left=false;
}}
if(key == KeyEvent.VK_LEFT) {
if(right==true){

}else{
    left = true;
    right = false;
    up=false;
    down=false;

}}
if(key == KeyEvent.VK_UP){
    if(down==true){

    }else {
        up = true;
        right = false;
        down = false;
        left = false;
    }
}
if(key == KeyEvent.VK_DOWN){
    if(up==true){

    }else{
    down = true;
    right = false;
    up=false;
    left=false;
}}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(game==false){
        }else {
            creatPlayse();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}

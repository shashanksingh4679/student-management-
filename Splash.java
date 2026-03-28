package student.managment.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {

        setSize(1000,700);
        setLocation(200,50);
        ImageIcon i1 = new ImageIcon("src/icons/third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);



        setVisible(true);

        t = new Thread(this);
        t.start();

        int x = 1;

        for(int i=1;i<=600;i+=4){
            setLocation(600-((i+x)/2),350-(i/2));
            setSize(i+3*x,(i+x)/2);

            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
    }


    public void run(){

        try{
            Thread.sleep(4000);
            setVisible(false);
            new Login();


        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(){

        new Splash();

    }
}





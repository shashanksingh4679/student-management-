package student.managment.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton Login, Back;

    Login() {
        JLabel labelName = new JLabel("user name");
        labelName.setBounds(40, 20, 100, 20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        add(textFieldName);

        JLabel labelPass = new JLabel("Password");
        labelPass.setBounds(40, 70, 100, 20);
        add(labelPass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        add(passwordField);

        Login = new JButton("Login");
        Login.setBounds(40, 140, 150, 20);
        Login.setBackground(Color.black);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Back = new JButton("Back");
        Back.setBounds(180, 140, 150, 20);
        Back.setBackground(Color.black);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);


        ImageIcon i1 = new ImageIcon("src/icons/second.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon("src/icons/loginback.png");
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 300);
        add(image);


        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
        setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            String username = textFieldName.getText();
            String password = passwordField.getText();
            if (username.equals("shashanksingh") && password.equals("sh@nki96")) {
                new Addstudent();
                setVisible(false);
            } else {
                JOptionPane.showConfirmDialog(rootPane, "Invalid username or password");
            }
        }
            else if (e.getSource() ==Back) {
                setVisible(false);
            }
        }



    public static void main(String[] args) {
        new Login();
    }
}





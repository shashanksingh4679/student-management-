package student.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addstudent extends JFrame implements ActionListener {

    JTextField textName, textFatherName, textMotherName, textContactNumber, textEmail, textAddress, textM10, textM12, textRollnumber, textdob;
    JButton submit, cancel;

    JComboBox<String> courseBox, departmentBox;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    public Addstudent() {

        setLayout(null);
        getContentPane().setBackground(new Color(166, 164, 252));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("Serif", Font.BOLD, 20));
        add(fname);

        textFatherName = new JTextField();
        textFatherName.setBounds(600, 150, 150, 30);
        add(textFatherName);

        JLabel mname = new JLabel("Mother's Name");
        mname.setBounds(50, 200, 200, 30);
        mname.setFont(new Font("Serif", Font.BOLD, 20));
        add(mname);

        textMotherName = new JTextField();
        textMotherName.setBounds(200, 200, 150, 30);
        add(textMotherName);

        JLabel contact = new JLabel("Contact Number");
        contact.setBounds(400, 200, 200, 30);
        contact.setFont(new Font("Serif", Font.BOLD, 20));
        add(contact);

        textContactNumber = new JTextField();
        textContactNumber.setBounds(600, 200, 150, 30);
        add(textContactNumber);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 250, 200, 30);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 250, 150, 30);
        add(textEmail);

        JLabel address = new JLabel("Address");
        address.setBounds(400, 250, 200, 30);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(600, 250, 150, 30);
        add(textAddress);

        JLabel m10 = new JLabel("10th Marks");
        m10.setBounds(50, 300, 200, 30);
        m10.setFont(new Font("Serif", Font.BOLD, 20));
        add(m10);

        textM10 = new JTextField();
        textM10.setBounds(200, 300, 150, 30);
        add(textM10);

        JLabel m12 = new JLabel("12th Marks");
        m12.setBounds(400, 300, 200, 30);
        m12.setFont(new Font("Serif", Font.BOLD, 20));
        add(m12);

        textM12 = new JTextField();
        textM12.setBounds(600, 300, 150, 30);
        add(textM12);

        JLabel roll = new JLabel("Roll Number");
        roll.setBounds(50, 350, 200, 30);
        roll.setFont(new Font("Serif", Font.BOLD, 20));
        add(roll);

        textRollnumber = new JTextField();
        textRollnumber.setBounds(200, 350, 150, 30);
        add(textRollnumber);

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(400, 350, 200, 30);
        dobLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(dobLabel);

        textdob = new JTextField();
        textdob.setBounds(600, 350, 150, 30);
        add(textdob);

        JLabel courseLabel = new JLabel("Course");
        courseLabel.setBounds(50, 400, 200, 30);
        courseLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(courseLabel);
        String courses[] = {"B.Tech", "BBA", "BCA", "MBA", "MCA"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(200, 400, 150, 30);
        add(courseBox);

        JLabel department = new JLabel("Department");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("Serif", Font.BOLD, 20));
        add(department);
        String departments[] = {"Computer Science", "Electrical", "Mechanical", "Electronics", "Civil", "IT"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(600, 400, 150, 30);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(200, 500, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370, 500, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String fatherName = textFatherName.getText();
            String motherName = textMotherName.getText();
            String contact = textContactNumber.getText();
            String email = textEmail.getText();
            String address = textAddress.getText();
            String m10 = textM10.getText();
            String m12 = textM12.getText();
            String roll = textRollnumber.getText();
            String dobText = textdob.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.connection.prepareStatement(query);
                ps.setString(1, String.valueOf(f4));
                ps.setString(2, name);
                ps.setString(3, fatherName);
                ps.setString(4, motherName);
                ps.setString(5, contact);
                ps.setString(6, email);
                ps.setString(7, address);
                ps.setString(8, m10);
                ps.setString(9, m12);
                ps.setString(10, roll);
                ps.setString(11, dobText);
                ps.setString(12, course);
                ps.setString(13, department);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Details inserted successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addstudent();
    }
}
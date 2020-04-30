package film;

import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Login extends JFrame{
    JLabel ljudul,lusername,lpassword;
    JTextField txusername;
    JPasswordField txpassword;
    JButton login;
    
    public Login(){
        setTitle("LOGIN");
        
        ljudul = new JLabel("LOGIN ADMIN");
        lusername = new JLabel("Username");  
        lpassword = new JLabel("Password");
        
        txusername = new JTextField("");
        txpassword = new JPasswordField("");
        
        login = new JButton("LOGIN");
        
        setLayout(null);
        add(ljudul);
        add(lusername);
        add(lpassword);
        add(txusername);
        add(txpassword);
        add(login);
        
        ljudul.setBounds(100, 20, 80, 23);
        
        lusername.setBounds(25, 60, 80, 23);
        txusername.setBounds(130, 60, 120, 23);
        
        lpassword.setBounds(25, 100, 80, 23);
        txpassword.setBounds(130, 100, 120, 23);
        
        login.setBounds(100, 150, 70, 23);
        
        setSize(300,250); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        login.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txusername.getText().equals("admin") && txpassword.getText().equals("admin")){
                    FilmMVC mvc = new FilmMVC();
                    dispose();
                }
                else{
                    System.out.println("Username dan password salah!");
                    JOptionPane.showMessageDialog(null, "Masukkan username dan password!");
                }
            }
        });
    }
}

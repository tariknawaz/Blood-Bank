import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LogIn extends JFrame {
	private JPanel panel;
	private JLabel labelUserName, labelPassword;
	private JTextField textUserName, textPassword;
	private JButton buttonConfirm;
	
	public LogIn() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents(){
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("LogIn");
		this.setSize(450, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.labelUserName = new JLabel("User Name");
		this.labelUserName.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelUserName);
		
		this.labelPassword = new JLabel("Password");
		this.labelPassword.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelPassword);
		
		this.textUserName = new JTextField();
		this.textUserName.setBounds(210, 50, 180, 20);
		this.panel.add(this.textUserName);
		
		this.textPassword = new JTextField();
		this.textPassword.setBounds(210, 80, 180, 20);
		this.panel.add(this.textPassword);
		
		this.buttonConfirm = new JButton("Confirm");
		this.buttonConfirm.setBounds(160, 205, 140, 30);
		this.panel.add(this.buttonConfirm);
		
		this.add(this.panel);
		
		this.buttonConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String un, pw;
				un = textUserName.getText();
				pw = textPassword.getText();
				String u="n";
				
		
		DBAccess db = new DBAccess();
		
		
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

			Statement stmt = (Statement) con.createStatement();
			String query = "SELECT * FROM DONATORS";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
            
			while(rs.next()){
				String UserName = rs.getString("USERNAME");
				String Password = rs.getString("PASSWORD");
				
				if(un.equals(UserName) && pw.equals(Password) && un.equals("admin"))
				{
					
					new Admin(db.getDatas(u));
					new Approval();
					
				}
				else if(un.equals(UserName) && pw.equals(Password))
				{
					
					new UserForm(UserName);
					
				}
			}
		    
		}
		catch (SQLException err) {
			System.out.println(err.getMessage());
				}
		
			}
			
		});
	}
}
	
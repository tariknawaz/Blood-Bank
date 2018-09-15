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

public class UserForm extends JFrame{
	private JPanel panel;
	private JLabel labelUserName, labelPassword, labelMob, labelEmail, labelAge, labelAdrs, labelBlood, labelName;
	private JLabel viewUserName, viewPassword, viewMob, viewEmail, viewAge, viewAdrs, viewBlood, viewName;
	private JButton buttonConfirm;
	String UN;
	
	
	public UserForm(String UN) {
		this.UserForm();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.UN=UN;
		this.dbData(UN);
		
	}
	
	private void UserForm(){
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("User Info");
		this.setSize(550, 450);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.labelUserName = new JLabel("UserName");
		this.labelUserName.setBounds(150, 30, 150, 20);
		this.panel.add(this.labelUserName);

		this.viewUserName = new JLabel();
		this.viewUserName.setBounds(250, 30, 150, 20);
		this.panel.add(this.viewUserName);
		
		this.labelPassword = new JLabel("Password");
		this.labelPassword.setBounds(150, 50, 60, 20);
		this.panel.add(this.labelPassword);

		this.viewPassword = new JLabel();
		this.viewPassword.setBounds(250, 50, 60, 20);
		this.panel.add(this.viewPassword);
		
		this.labelName = new JLabel("Name");
		this.labelName.setBounds(150, 70, 60, 20);
		this.panel.add(this.labelName);

		this.viewName = new JLabel();
		this.viewName.setBounds(250, 70, 60, 20);
		this.panel.add(this.viewName);
		
		this.labelMob = new JLabel("Mobile");
		this.labelMob.setBounds(150, 90, 60, 20);
		this.panel.add(this.labelMob);

		this.viewMob = new JLabel();
		this.viewMob.setBounds(250, 90, 60, 20);
		this.panel.add(this.viewMob);
		
		this.labelEmail = new JLabel("Email");
		this.labelEmail.setBounds(150, 110, 60, 20);
		this.panel.add(this.labelEmail);

		this.viewEmail = new JLabel();
		this.viewEmail.setBounds(250, 110, 150, 20);
		this.panel.add(this.viewEmail);
		
		this.labelAge = new JLabel("Age");
		this.labelAge.setBounds(150, 130, 60, 20);
		this.panel.add(this.labelAge);

		this.viewAge = new JLabel();
		this.viewAge.setBounds(250, 130, 60, 20);
		this.panel.add(this.viewAge);
		
		this.labelAdrs = new JLabel("Adress");
		this.labelAdrs.setBounds(150, 150, 60, 20);
		this.panel.add(this.labelAdrs);

		this.viewAdrs = new JLabel();
		this.viewAdrs.setBounds(250, 150, 60, 20);
		this.panel.add(this.viewAdrs);
		
		this.labelBlood = new JLabel("Blood Group");
		this.labelBlood.setBounds(150, 170, 120, 20);
		this.panel.add(this.labelBlood);

		this.viewBlood = new JLabel();
		this.viewBlood.setBounds(270, 170, 120, 20);
		this.panel.add(this.viewBlood);
		
		this.buttonConfirm = new JButton("Edit");
		this.buttonConfirm.setBounds(60, 205, 140, 30);
		this.panel.add(this.buttonConfirm);
		
		this.add(this.panel);
		
		this.buttonConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditUser(UN);
			}
		});
	}

	public void dbData(String U){
		
		DBAccess db = new DBAccess();		
		
		try 
		{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

		Statement stmt = (Statement) con.createStatement();
		String query = "SELECT * FROM DONATORS";
		stmt.executeQuery(query);
		ResultSet rs = stmt.getResultSet();
            
			while (rs.next())
			{
				String User = rs.getString("USERNAME");
			
				if (U.equals(User))
				{
				viewUserName.setText(rs.getString("USERNAME"));
				viewPassword.setText(rs.getString("PASSWORD"));
				viewName.setText(rs.getString("NAME"));
				viewMob.setText(rs.getString("MOB"));
				viewEmail.setText(rs.getString("EMAIL"));
				viewAge.setText(rs.getString("AGE"));
				viewAdrs.setText(rs.getString("ADRS"));
				viewBlood.setText(rs.getString("B_GROUP"));
				
				break;
				}
			}

            
		}
		catch (SQLException err) 
		{
			System.out.println(err.getMessage());
		}
		
	}

}
	
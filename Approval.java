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

class Approval extends JFrame{
	
	private JPanel panel;
	private JLabel label;
	private JButton buttonApprove,buttonDeny;
	
	public Approval() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents(){
		
	this.panel = new JPanel();
	this.panel.setLayout(null);
	this.setTitle("Decision");
	this.setSize(400, 160);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	this.label = new JLabel("Select action");
	this.label.setBounds(150, 10, 150, 20);
	this.panel.add(this.label);
	
	this.buttonApprove = new JButton("Approve");
	this.buttonApprove.setBounds(90, 50, 100, 30);
	this.panel.add(this.buttonApprove);
	
	this.buttonDeny = new JButton("Deny");
	this.buttonDeny.setBounds(200, 50, 100, 30);
	this.panel.add(this.buttonDeny);
		
	this.add(this.panel);
	
	this.buttonApprove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				DBAccess db = new DBAccess();
				db.addToDN();
				db.addToDNY();
			}
		});
		
	this.buttonDeny.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DBAccess db = new DBAccess();
				db.addToDNY();
			}
		});
	}
		
	
		
}
	
	
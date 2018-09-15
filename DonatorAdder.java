import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DonatorAdder extends JFrame {

	private JPanel panel;
	private JLabel labelForm, labelMob, labelName, labelAge, labelBlood, labelEmail, labelAdrs, labelArea, labelun, labelpw;
	private JTextField textMob, textName, textEmail, textAge, textAdrs, textun, textpw;
	private JComboBox comboBlood, comboArea;
	private JButton buttonAdd;
	
	public DonatorAdder() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents(){
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("Add New Donator");
		this.setSize(450, 550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.labelForm = new JLabel("Donator Details");
		this.labelForm.setBounds(150, 10, 250, 20);
		this.panel.add(this.labelForm);
		
		this.labelMob = new JLabel("Mobile Number");
		this.labelMob.setBounds(20, 50, 180, 20);
		this.panel.add(this.labelMob);
		
		this.textMob = new JTextField();
		this.textMob.setBounds(200, 50, 180, 20);
		this.panel.add(this.textMob);
		
		this.labelName = new JLabel("Name");
		this.labelName.setBounds(20, 80, 180, 20);
		this.panel.add(this.labelName);
		
		this.textName = new JTextField();
		this.textName.setBounds(200, 80, 180, 20);
		this.panel.add(this.textName);
		
		this.labelEmail = new JLabel("Email");
		this.labelEmail.setBounds(20, 110, 180, 20);
		this.panel.add(this.labelEmail);
		
		this.textEmail = new JTextField();
		this.textEmail.setBounds(200, 110, 180, 20);
		this.panel.add(this.textEmail);
		
		this.labelAge = new JLabel("Age");
		this.labelAge.setBounds(20, 140, 180, 20);
		this.panel.add(this.labelAge);
		
		this.textAge = new JTextField();
		this.textAge.setBounds(200, 140, 180, 20);
		this.panel.add(this.textAge);
		
		/*this.labelAdrs = new JLabel("Address");
		this.labelAdrs.setBounds(20, 170, 180, 20);
		this.panel.add(this.labelAdrs);
		
		this.textAdrs = new JTextField();
		this.textAdrs.setBounds(200, 170, 180, 20);
		this.panel.add(this.textAdrs);*/
		
		this.labelAdrs = new JLabel("Address");
		this.labelAdrs.setBounds(20, 170, 180, 20);
		this.panel.add(this.labelAdrs);
		
		String area[] = new String[] {"Choose Area","Banani", "Baridhara", "Gulshan", "Khilgaon","Uttara","Old Dhaka", "Dhanmondi" };
		this.comboArea = new JComboBox(area);
		this.comboArea.setBounds(200, 170, 180, 20);
		this.panel.add(this.comboArea);

		this.labelBlood = new JLabel("Blood Group");
		this.labelBlood.setBounds(20, 210, 180, 20);
		this.panel.add(this.labelBlood);

		String dept[] = new String[] {"Choose BloodGroup","A +ve", "A -ve", "B +ve", "B -ve", "O +ve", "O -ve", "AB +ve", "AB -ve"};
		this.comboBlood = new JComboBox(dept);
		this.comboBlood.setBounds(200, 210, 180, 20);
		this.panel.add(this.comboBlood);
		
		this.labelun = new JLabel("UserName");
		this.labelun.setBounds(20, 250, 180, 20);
		this.panel.add(this.labelun);
		
		this.textun = new JTextField();
		this.textun.setBounds(200, 250, 180, 20);
		this.panel.add(this.textun);
		
		this.labelpw = new JLabel("Password");
		this.labelpw.setBounds(20, 280, 180, 20);
		this.panel.add(this.labelpw);
		
		this.textpw = new JTextField();
		this.textpw.setBounds(200, 280, 180, 20);
		this.panel.add(this.textpw);		
		
		
		this.buttonAdd = new JButton("Register");
		this.buttonAdd.setBounds(150, 380, 150, 30);
		this.panel.add(this.buttonAdd);
		
		this.add(this.panel);
		
		this.buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String mob,name, email, age, adrs, b_group, username, password, approval;
				
				
				mob = textMob.getText();
				name = textName.getText();
				email = textEmail.getText();
				age = textAge.getText();
				adrs = comboArea.getSelectedItem().toString();
				b_group = comboBlood.getSelectedItem().toString();
				username=textun.getText();
				password=textpw.getText();
				approval="n";
				
				DBAccess db = new DBAccess();
				db.addToDB( mob, name, email, age, adrs, b_group, username, password, approval);
			}
		});
	}
}


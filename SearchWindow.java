import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchWindow extends JFrame {
	
	private JPanel panel;
	private JLabel labelForm, labelSearch, labelArea;
	private JComboBox comboBlood,comboArea;
	private JButton buttonSearch, buttonAdd, buttonLogIn;
	
	public SearchWindow() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents(){
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("Search Blood Donator");
		this.setSize(550, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.labelForm = new JLabel("Search With Blood Group");
		this.labelForm.setBounds(200, 110, 250, 20);
		this.panel.add(this.labelForm);
		
		this.labelSearch = new JLabel("Blood Group");
		this.labelSearch.setBounds(100, 160, 180, 20);
		this.panel.add(this.labelSearch);

		String dept[] = new String[] {"Choose BloodGroup","A +ve", "A -ve", "B +ve", "B -ve", "O +ve", "O -ve", "AB +ve", "AB -ve"};
		
		this.comboBlood = new JComboBox(dept);
		this.comboBlood.setBounds(200, 160, 180, 20);
		this.panel.add(this.comboBlood);

		
		this.buttonAdd = new JButton("Register as donater");
		this.buttonAdd.setBounds(310, 55, 200, 30);
		this.panel.add(this.buttonAdd);
		
		this.buttonLogIn = new JButton("LogIn");
		this.buttonLogIn.setBounds(20, 55, 140, 30);
		this.panel.add(this.buttonLogIn);
		
		this.buttonSearch  = new JButton("Search");
		this.buttonSearch.setBounds(230, 200, 100, 40);
		this.panel.add(this.buttonSearch);
		
		this.add(this.panel);
		
		this.buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DonatorAdder();
			}
		});
		
		this.buttonLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogIn();
			}
		});
		
		this.buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBAccess db = new DBAccess();
				new SearchResult(db.getData(comboBlood.getSelectedItem().toString()));
			}
		});
	}
}


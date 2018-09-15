import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame {
	
	JTable table;
	JPanel panel;
	JButton buttonApprove;
	DefaultTableModel model;
	JScrollPane scroll;
	Vector<Vector<String>> vss;
	
	public Admin() {
	if(vss.isEmpty()) {
			return;
		}
		this.vss = vss;
		initComps();
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.buttonApprove = new JButton("Register");
		this.buttonApprove.setBounds(180, 400, 60, 60);
		this.panel.add(this.buttonApprove);
		
		this.add(this.panel);
	}
	
	public Admin(Vector<Vector<String>> vss) {
		if(vss.isEmpty()) {
			return;
		}
		this.vss = vss;
		initComps();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initComps() {
		this.setTitle("Admin");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 500);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Mobile");
		columnNames.add("Name");
		columnNames.add("Email");
		columnNames.add("Age");
		columnNames.add("Address");
		columnNames.add("Blood Group");
		columnNames.add("Username");
		columnNames.add("Password");
		columnNames.add("Approved");
		
		
		
		model = new DefaultTableModel(vss, columnNames);
		
		table = new JTable(model);
		
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}
	
	
}

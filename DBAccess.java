import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DBAccess {
	
	String query;
	Connection con;
	Statement st;
	ResultSet rs;
	String UN;
	
	public DBAccess() {
		createTable();
	}
	
	public DBAccess(String UN) {
		this.UN=UN;
	}
	public void connectToDB()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
			st = con.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createTable()
	{
		connectToDB();
		query = "SELECT * FROM 	dba_tables where table_name = 'ADMIN'";
		try {
			rs = st.executeQuery(query);
			if(rs.next()) {
			}
			else {
				query = "CREATE TABLE ADMIN"
					  + "(MOB			VARCHAR2(50),"
					  + "NAME			VARCHAR2(50),"
					  + "EMAIL			VARCHAR2(50),"
					  + "AGE			VARCHAR2(50),"
					  + "ADRS			VARCHAR2(50),"
					  + "B_GROUP		VARCHAR2(50))"
					  + "USERNAME		VARCHAR2(30))"
					  + "PASSWORD		VARCHAR2(30))"
					  + "APPROVED		VARCHAR2(30))";
					
				st.executeUpdate(query);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void addToDB(String mob, String name, String email, String age, String adrs, String b_group, String un, String pw,String a) {
		connectToDB();
		try {
			a="n";
			query = "INSERT INTO `admin` (`MOB`, `NAME`, `EMAIL`, `AGE`, `ADRS`, `B_GROUP`, `USERNAME`, `PASSWORD`, `APPROVED`)"
						+ "VALUES ('"+mob+"', '"+name+"', '"+email+"', '"+age+"', '"+adrs+"', '"+b_group+"','"+un+"','"+pw+"','"+a+"')";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Donator Added for approval.", "Success", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addToDN() {
		connectToDB();
		try {
			query = "INSERT INTO DONATORS SELECT * FROM ADMIN";
			
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Approved all.", "Success.", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addToDNY() {
		connectToDB();
		try {
			query = "TRUNCATE TABLE ADMIN";
			
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "List Cleared", "Done.", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vector<Vector<String>> getDatas(String aprv) {
		Vector<Vector<String>> vss = new Vector<Vector<String>>();
		connectToDB();
		try {
			query = "SELECT * FROM ADMIN WHERE APPROVED = '"+aprv+"'";
			rs = st.executeQuery(query);
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "Nothing Found!", "Empty", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				rs.close();
				rs = st.executeQuery(query);
				while(rs.next()) {
					Vector<String> vc = new Vector<String>();
					for(int i=1; i<=9; i++) {
						vc.add(rs.getString(i));
					}
					vss.add(vc);
				}
			}
		} catch (Exception e) {
		}
		return vss;
	}
	
	public Vector<Vector<String>> getData(String b_group) {
		Vector<Vector<String>> vss = new Vector<Vector<String>>();
		connectToDB();
		try {
			query = "SELECT * FROM DONATORS WHERE B_GROUP = '"+b_group+"'";
			rs = st.executeQuery(query);
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "No Donator Found!", "Empty", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				rs.close();
				rs = st.executeQuery(query);
				while(rs.next()) {
					Vector<String> vc = new Vector<String>();
					for(int i=1; i<=6; i++) {
						vc.add(rs.getString(i));
					}
					vss.add(vc);
				}
			}
		} catch (Exception e) {
		}
		return vss;
	}
	
	public void chkUser(String UN, String PW){
		String UserName;
		String Password;
		connectToDB();
		query = "SELECT * FROM DONATORS";
		try{
			rs = st.getResultSet();
			
			while(rs.next()){
				UserName = rs.getString("USERNAME");
				Password = rs.getString("PASSWORD");
				
				if(UN.equals(UserName) && PW.equals(Password))
				{
					new UserForm(UserName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}

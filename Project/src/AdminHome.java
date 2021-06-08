import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



@SuppressWarnings("serial")
class AdminHome extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnReset, btnShow;
	private JLabel title;
	private JPanelTest win;

	public AdminHome(JPanelTest win) {
		this.win = win;
		setLayout(null);
		JLabel title = new JLabel("Admin Mode");

		JButton btn1 = new JButton("Professor");
		JButton btn2 = new JButton("Student");
		JButton btn3 = new JButton("Department");
		JButton btn4 = new JButton("Lecture");
		JButton btn5 = new JButton("Course");
		JButton btn6 = new JButton("Club");
		JButton btn7 = new JButton("Club Member");
		JButton btn8 = new JButton("Tuition");
		JButton btnReset = new JButton("Reset Database");
		JButton btnShow = new JButton("Show Tables");
		
		title.setBounds(460, 5, 200, 50);
		
		btn1.setBounds(125, 200, 150, 100);
		btn2.setBounds(325, 200, 150, 100);
		btn3.setBounds(525, 200, 150, 100);
		btn4.setBounds(725, 200, 150, 100);
		btn5.setBounds(125, 350, 150, 100);
		btn6.setBounds(325, 350, 150, 100);
		btn7.setBounds(525, 350, 150, 100);
		btn8.setBounds(725, 350, 150, 100);
		btnReset.setBounds(200, 570, 200, 50);
		btnShow.setBounds(600, 570, 200, 50);
		

		add(title);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btnReset);
		add(btnShow);

		btn1.addActionListener(new MyActionListener());
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelOfAddStudent");
			}
		});
		btn3.addActionListener(new MyActionListener());
		
		btnReset.addActionListener(new ActionListener() { // need to be fixed
			@Override
			public void actionPerformed(ActionEvent e) {			
				
				try {
					ScriptRunner runner=new ScriptRunner(JPanelTest.con, false, false);
					InputStreamReader reader = new InputStreamReader(new FileInputStream("sejong.sql"));
					System.out.println("Resetting data...");
					Statement stmt;
				    stmt = JPanelTest.con.createStatement();
					runner.runScript(reader);
				    reader.close();
					System.out.println("Reset Completed!");
				}
				catch (Exception e2) {
					System.out.println("Reset Failed! :" + e2);
				}
//				win.change("adminHome");
			}
		});
		btnShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				win.change("tableView");
			}
		});
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.setSize(100, 40);
		btn_logout.setLocation(10, 10);
		add(btn_logout);
		btn_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.change("jpanel01");
			}
		});
		
		
	}


	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
}

class TableView extends JPanel { 
	private JTextArea table;
	private JPanelTest win;
	private Font f;
	ResultSet rs;
	

	public TableView(JPanelTest win) {
		setLayout(null);
		this.win = win;

		table = new JTextArea();
		table.setBounds(50, 100, 900, 500);
		table.setEditable(false);
		
		f = new Font("Dialog", Font.PLAIN,10);
		
//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);
		
		String query = "SELECT * FROM STUDENT";
		try {
			Statement stmt;
			stmt = JPanelTest.con.createStatement();
		    table.setText("");
		    table.setText("\n\n   ID\tNAME    ADDRESS \t PHONE \t\t EMAIL \t\t DEPT_ID \t SUBDEPT_ID \t PROF_ID \t ACCOUNT\n");
		    rs = stmt.executeQuery(query);
		    while (rs.next()) {
		    	String str = rs.getInt(1) + "\t"
		    			  + rs.getString(2) + " "
		    			  + rs.getString(3) + "\t"
		    			  + rs.getString(4) + "\t"
		    			  + rs.getString(5) + "\t"
		    			  + rs.getInt(6) + "\t"
		    			  + rs.getInt(7) + "\t"
		    			  + rs.getInt(8) + "\t"
		    			  + rs.getString(9) + "\n";
		    	table.append(str);
		      }
		  }
		  catch (Exception e2) {
			  System.out.println("쿼리 읽기 실패 :" + e2);
/* 			  } finally {
				try {
		            if (rs != null)
		               rs.close();
		            if (stmt != null)
		               stmt.close();
		            if (con != null)
		               con.close();
		        } catch (Exception e3) {
		            // TODO: handle exception
		        }
*/
		  }
	   
		JButton btn_home = new JButton("Back");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("adminHome");
			}
		});
	}

	class MyActionListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}
}


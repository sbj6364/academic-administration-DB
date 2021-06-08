import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class StudentHome  extends JPanel {

	private JButton btn1, btn2, btn3, btn4;
	private JPanelTest win;
	private JLabel title;

	public StudentHome(JPanelTest win) {
		this.win = win;
		setLayout(null);

		JLabel title = new JLabel("Student Mode");
		JButton btn1 = new JButton("My Lectures");
		JButton btn2 = new JButton("My Clubs");
		JButton btn3 = new JButton("Report Card");		
		JButton btn4 = new JButton("Time Table");
		
		title.setBounds(460, 5, 200, 50);
		btn1.setBounds(125, 250, 150, 100);
		btn2.setBounds(325, 250, 150, 100);
		btn3.setBounds(525, 250, 150, 100);
		btn4.setBounds(725, 250, 150, 100);

		add(title);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);

		
		btn1.addActionListener(new MyActionListener());
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelOfAddStudent");
			}
		});
		btn3.addActionListener(new MyActionListener());
		btn4.addActionListener(new MyActionListener());
		
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
//
//class PLectureView extends JPanel { 
//	private JTextArea table;
//	private JPanelTest win;
//	private Font f;
//	ResultSet rs;
//	
//
//	public PLectureView(JPanelTest win) {
//		setLayout(null);
//		this.win = win;
//
//		table = new JTextArea();
//		table.setBounds(50, 100, 900, 500);
//		table.setEditable(false);
//		
//		f = new Font("Dialog", Font.PLAIN,10);
//		
////		JScrollPane scrollPane = new JScrollPane(table);
//		table.setFont(f);
//		add(table);
////		add("North", scrollPane);
//		
//
//		try {
//			Statement stmt;
//			stmt = JPanelTest.con.createStatement();
//		    String query = "SELECT * FROM STUDENT";
//		    table.setText("");
//		    table.setText("\n\n   ID\tNAME    ADDRESS \t PHONE \t\t EMAIL \t\t DEPT_ID \t SUBDEPT_ID \t PROF_ID \t ACCOUNT\n");
//		    rs = stmt.executeQuery(query);
//		    while (rs.next()) {
//		    	String str = rs.getInt(1) + "\t"
//		    			  + rs.getString(2) + " "
//		    			  + rs.getString(3) + "\t"
//		    			  + rs.getString(4) + "\t"
//		    			  + rs.getString(5) + "\t"
//		    			  + rs.getInt(6) + "\t"
//		    			  + rs.getInt(7) + "\t"
//		    			  + rs.getInt(8) + "\t"
//		    			  + rs.getString(9) + "\n";
//		    	table.append(str);
//		      }
//		  }
//		  catch (Exception e2) {
//			  System.out.println("쿼리 읽기 실패 :" + e2);
///* 			  } finally {
//				try {
//		            if (rs != null)
//		               rs.close();
//		            if (stmt != null)
//		               stmt.close();
//		            if (con != null)
//		               con.close();
//		        } catch (Exception e3) {
//		            // TODO: handle exception
//		        }
//*/
//		  }
//	   
//		JButton btn_home = new JButton("Back");
//		btn_home.setSize(120, 40);
//		btn_home.setLocation(10, 10);
//		add(btn_home);
//		btn_home.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				win.change("adminHome");
//			}
//		});
//	}
//
//	class MyActionListener implements ActionListener { 
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			win.change("jpanel01");
//		}
//	}
//}
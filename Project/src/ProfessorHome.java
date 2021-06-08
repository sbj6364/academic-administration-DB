import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class ProfessorHome extends JPanel {

	private JButton btn1, btn2, btn3, btn4;
	private JPanelTest win;
	private JLabel title;

	public ProfessorHome(JPanelTest win) {
		this.win = win;
		setLayout(null);

		JLabel title = new JLabel("Professor Mode");
		JButton btn1 = new JButton("My Lectures");
		JButton btn2 = new JButton("My Students");
		JButton btn3 = new JButton("My Department");		
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

		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("pLectureView");
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelOfAddStudent");
			}
		});
		btn3.addActionListener(new MyActionListener());
		
		JButton btn_home = new JButton("Logout");
		btn_home.setSize(100, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {

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
			win.change("jpanel02");
		}
	}
}
	

class PLectureView extends JPanel { 
	private JTextArea table;
	private JPanelTest win;
	private Font f;
	JLabel l1, l2, l3, title;
	JTextField f1, f2, f3;
	ResultSet rs;
	JButton btn;
	
	
	public PLectureView(JPanelTest win) {
		setLayout(null);
		this.win = win;

		table = new JTextArea();
		table.setBounds(50, 100, 900, 500);
		table.setEditable(false);
		
		title = new JLabel("My Lectures");
		title.setBounds(450, 5, 200, 50);
		btn = new JButton("Search");
		btn.setBounds(750, 50, 80, 30);
		add(title);
		add(btn);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int profid = 130000;
				int year = 2021;
				int semester = 1;
				
				String s1 = String.valueOf(f1.getText());
				String s2 = String.valueOf(f2.getText());
				String s3 = String.valueOf(f3.getText());
				
				profid = Integer.parseInt(s1);
				year = Integer.parseInt(s2);
				semester = Integer.parseInt(s3);
				
				String query = "SELECT * FROM LECTURE WHERE `prof_id` = "
						+ profid + " and `year` = " + year + " and `semester` = " + semester;
				
				
				try {
					Statement stmt;
					stmt = JPanelTest.con.createStatement();
				    table.setText("");
				    table.setText("\n\n   ID    CLASS_ID    PROF_ID \t NAME \t DAY \t PERIOD \t CREDIT \t TIME \t DEPT_ID \t ROOM \t YEAR\t SEMESTER\n");
//				    PreparedStatement pstat = JPanelTest.con.prepareStatement(query);


				    rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	String str = rs.getInt(1) + "        "
				    			  + rs.getInt(2) + "\t   "
				    			  + rs.getInt(3) + "\t"
				    			  + rs.getString(4) + "\t"
				    			  + rs.getString(5) + "\t"
				    			  + rs.getInt(6) + "\t"
				    			  + rs.getInt(7) + "\t"
				    			  + rs.getInt(8) + "\t"
				    			  + rs.getInt(9) + "\t"
				    			  + rs.getString(10) + "\t"
				    			  + rs.getInt(11) + "\t"
				    			  + rs.getInt(12) + "\t";
				    	table.append(str);
				      }
				  }
				  catch (Exception e2) {
					  System.out.println("쿼리 읽기 실패 :" + e2);
				  }
			}
		});
		
		
		
		f = new Font("Dialog", Font.PLAIN,10);
		
//		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(f);
		add(table);
		
		l1 = new JLabel("prof_id");
		l2 = new JLabel("year");
		l3 = new JLabel("semester");
		
		f1 = new JTextField(5);
		f2 = new JTextField(5);
		f3 = new JTextField(5);
		
		f1.setText("130001");
		f2.setText("2021");
		f3.setText("1");
		
		add(l1);
		add(l2);
		add(l3);
		
		add(f1);
		add(f2);
		add(f3);
		
		l1.setBounds(150, 50, 100, 30);
		l2.setBounds(360, 50, 100, 30);
		l3.setBounds(530, 50, 100, 30);
		
		f1.setBounds(200, 50, 100, 30);
		f2.setBounds(400, 50, 100, 30);
		f3.setBounds(600, 50, 100, 30);
//		add("North", scrollPane);
		
	   
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





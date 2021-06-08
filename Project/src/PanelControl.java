import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class JPanelOfAddStudent extends JPanel {
	private HashMap<String, JTextField> textFieldMap;
	private JPasswordField passwordField;
	private JPanelTest win;
	private JLabel title;

	public JPanelOfAddStudent(JPanelTest win) {
		setLayout(null);
		this.win = win;
		addDefaultLabel();
		addDefaultEditText();
		
		JLabel title = new JLabel("Student Management");

		JButton btn = new JButton("Save");
		
		title.setBounds(450, 5, 200, 50);
		btn.setSize(100, 30);
		btn.setLocation(230, 470);
		add(title);
		add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String key : textFieldMap.keySet()) {
					System.out.print(key + ": \t");
					System.out.println(textFieldMap.get(key).getText().toString());
					
				}
				
				int id;
				String name;
				String adrs;
				String phone;
				String email;
				int dept_id;
				int sub_id;
				int prof_id;
				String acnt;
				
				String s1 = textFieldMap.get("id").getText();
				String s2 = textFieldMap.get("name").getText();
				String s3 = textFieldMap.get("address").getText();
				String s4 = textFieldMap.get("phone").getText();
				String s5 = textFieldMap.get("email").getText();
				String s6 = textFieldMap.get("dept_id").getText();
				String s7 = textFieldMap.get("subdept_id").getText();
				String s8 = textFieldMap.get("prof_id").getText();
				String s9 = textFieldMap.get("account").getText();
				if (true) {
					id = Integer.parseInt(s1);
					name = s2;
					adrs = s3;
					phone = s4;
					email = s5;
					dept_id = Integer.parseInt(s6);
					if (!s7.equals(""))
						sub_id = Integer.parseInt(s7);
					else
						sub_id = -1;
					prof_id = Integer.parseInt(s8);
					acnt = s9;
				}
				String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?);";
				
				try {
					System.out.println("Inserting data...");
					Statement stmt;
				    stmt = JPanelTest.con.createStatement();
//					txtResult.setText("");
//					txtResult.setText("\n\nInserting data...\n.\n.\n.\n");
					PreparedStatement pstat = JPanelTest.con.prepareStatement(sql);
					pstat.setInt(1, id);
					pstat.setString(2, name);
					pstat.setString(3, adrs);
					pstat.setString(4, phone);
					pstat.setString(5, email);
					pstat.setInt(6, dept_id);
					if (sub_id != -1)
						pstat.setInt(7, sub_id);
					else
						pstat.setNull(7, 0);
					pstat.setInt(8, prof_id);
					pstat.setString(9, acnt);

					pstat.executeUpdate();
//					txtResult.append("Insert Completed!\n");
					System.out.println("Insert Completed!");
				}
				catch (Exception e2) {
//					txtResult.append("Inserting Failed!\n"
//					  				+ "Please try again with proper values.");
					System.out.println("쿼리 읽기 실패 :" + e2);
				}
			}
			
			
		});
		
		JButton btn_home = new JButton("Admin Home");
		btn_home.setSize(120, 40);
		btn_home.setLocation(10, 10);
		add(btn_home);
		btn_home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.change("JPanelOfAdminMain");
			}
		});

	}

	private void addDefaultLabel() {
		ArrayList<String> infoList = new ArrayList<>();
		infoList.add("* Student ID");
		infoList.add("* Name");
		infoList.add("* Address");
		infoList.add("* Phone");
		infoList.add("* Email");
		infoList.add("* Department ID");
		infoList.add("  Subdepartment ID");
		infoList.add("* Professor ID");
		infoList.add("* Account");

		int x = 50, y = 100, m = 130, n = 30;
		int increasedY = 40;
		for (String item : infoList) {
			JLabel label = new JLabel(item);
			label.setBounds(x, y, m, n);
			y = y + increasedY;
			add(label);
		}

	}

	private void addDefaultEditText() {
		textFieldMap = new HashMap<>();
		String[] keys = { "id", "name", "address", "phone", "email", "dept_id", "subdept_id", "prof_id", "account" };
		int x = 180, y = 100, m = 150, n = 30;
		int increasedY = 40;

		for (int idx = 0; idx < 9; idx++) {
			JTextField textField = new JTextField();
			textField.setBounds(x, y, m, n);
			y += increasedY;
			textFieldMap.put(keys[idx], textField);
			add(textField);
			textField.setColumns(10);
		}
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}

}

// Log in
@SuppressWarnings("serial")
class JPanel01 extends JPanel { 

	private JButton jButton1;
	private JButton btn1, btn2, btn3;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JPanelTest win;
	private JLabel title;

// private JLabel title;
// JLabel title = new JLabel("Home - Access Mode");
// title.setBounds(450, 5, 200, 50);
// add(title);
	public JPanel01(JPanelTest win) {
		this.win = win;
		setLayout(null);
		
		JLabel title = new JLabel("Login - Access Mode");

		JButton btn1 = new JButton("Admin");
		JButton btn2 = new JButton("Professor");
		JButton btn3 = new JButton("Student");

		title.setBounds(430, 5, 200, 50);
		
		btn1.setBounds(100, 250, 200, 100);
		btn2.setBounds(400, 250, 200, 100);
		btn3.setBounds(700, 250, 200, 100);

		add(title);
	
		add(btn1);
		add(btn2);
		add(btn3);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("adminHome");
			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("professorHome");
			}
		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("studentHome");
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

@SuppressWarnings("serial")
class JPanel02 extends JPanel { 
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanelTest win;

	public JPanel02(JPanelTest win) {
		setLayout(null);
		this.win = win;
		JLabel lblLbl = new JLabel("panel2:");
		lblLbl.setBounds(31, 40, 67, 15);
		add(lblLbl);

		textField = new JTextField();
		textField.setBounds(123, 40, 116, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblLbl_1 = new JLabel("OOO");
		lblLbl_1.setBounds(31, 84, 67, 15);
		add(lblLbl_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(123, 84, 116, 21);
		add(passwordField);

		JButton btn = new JButton("OOO");
		btn.setSize(70, 20);
		btn.setLocation(10, 10);
		add(btn);
		btn.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("jpanel01");
		}
	}
}

@SuppressWarnings("serial")
class JPanelTest extends JFrame {

	JTextArea txtStatus;

	static Connection con;
	Statement stmt;
	ResultSet rs;
	String Driver = "";
	String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
	String userid = "madang";
	String pwd = "madang";

	void conDB() {
    	
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver Load Success");
           txtStatus.append("Driver Load Success...\n");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        
        try { /* Database 연결 과정 */
            System.out.println("Database 연결 준비...");
            txtStatus.append("Database connecting...\n");		
            con = DriverManager.getConnection(url, userid, pwd);
            System.out.println("Database 연결 성공 !");
            txtStatus.append("Database connected!\n");
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
    }

	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;
	public AdminHome adminHome = null;
	public ProfessorHome professorHome = null;
	public StudentHome studentHome = null;
//	public AdminStudent adminStudent = null;
//	public AdminProfessor adminProfessor = null;
//	public AdminStudent adminStudent = null;
//	public AdminStudent adminStudent = null;
//	public AdminStudent adminStudent = null;
//	public AdminStudent adminStudent = null;
//	public AdminStudent adminStudent = null;
	public JPanelOfAddStudent jpanelOfAddStudent = null;
	public TableView tableView = null;
	public PLectureView pLectureView = null;
	


	JPanelTest(){
		txtStatus = new JTextArea(5,20);
		txtStatus.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtStatus);
		
//		add(scrollPane);
		conDB();
	}

	public void change(String panelName) { 

		if (panelName.equals("jpanel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		} else if (panelName.equals("jpanel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		} else if (panelName.equals("adminHome")) {
			getContentPane().removeAll();
			getContentPane().add(adminHome);
			revalidate();
			repaint();
		} else if (panelName.equals("professorHome")) {
			getContentPane().removeAll();
			getContentPane().add(professorHome);
			revalidate();
			repaint();
		} else if (panelName.equals("studentHome")) {
			getContentPane().removeAll();
			getContentPane().add(studentHome);
			revalidate();
			repaint();
		} else if (panelName.equals("jpanelOfAddStudent")) {
			System.out.println("start");
			getContentPane().removeAll();
			System.out.println("remove");
			getContentPane().add(jpanelOfAddStudent);
			System.out.println("add");
			revalidate();
			repaint();
		} else if (panelName.equals("tableView")) {
			getContentPane().removeAll();
			getContentPane().add(tableView);
			revalidate();
			repaint();
		} else if (panelName.equals("pLectureView")) {
			getContentPane().removeAll();
			getContentPane().add(pLectureView);
			revalidate();
			repaint();
		} else if (panelName.equals("tableView")) {
			getContentPane().removeAll();
			getContentPane().add(tableView);
			revalidate();
			repaint();
		} else if (panelName.equals("tableView")) {
			getContentPane().removeAll();
			getContentPane().add(tableView);
			revalidate();
			repaint();
		} else if (panelName.equals("tableView")) {
			getContentPane().removeAll();
			getContentPane().add(tableView);
			revalidate();
			repaint();
		} else {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		}
	}

}

package sejong.DB.Byeongjoon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public JPanelOfAddStudent(JPanelTest win) {
		setLayout(null);
		this.win = win;
		addDefaultLabel();
		addDefaultEditText();

		JButton btn = new JButton("버튼");
		btn.setSize(70, 20);
		btn.setLocation(10, 10);
		add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String key : textFieldMap.keySet()) {
					System.out.print(key + ": \t");
					System.out.println(textFieldMap.get(key).getText().toString());
				}
			}
		});

		JButton btn_print = new JButton("정보 출력");
		btn.setSize(70, 20);
		btn.setLocation(30, 10);
		add(btn_print);
		btn_print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String key : textFieldMap.keySet()) {
					System.out.print(key + ": \t");
					System.out.println(textFieldMap.get(key).getText().toString());
				}
			}
		});

	}

	private void addDefaultLabel() {
		ArrayList<String> infoList = new ArrayList<>();
		infoList.add("학번");
		infoList.add("이름");
		infoList.add("주소");
		infoList.add("번호");
		infoList.add("메인");
		infoList.add("학과");
		infoList.add("부전공");
		infoList.add("교수");
		infoList.add("계좌");

		int x = 31, y = 40, m = 67, n = 15;
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
		int x = 123, y = 40, m = 116, n = 21;
		int increasedY = 35;

		for (int idx = 0; idx < 9; idx++) {
			JTextField textField = new JTextField();
			textField.setBounds(x, y, m, n);
			y += increasedY;
			textFieldMap.put(keys[idx], textField);
			add(textField);
			textField.setColumns(10);
		}
	}

	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 1번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}

}

@SuppressWarnings("serial")
class JPanelOfAdminMain extends JPanel { // 1번째 패널

	private JButton btn1, btn2, btn3;
	private JPanelTest win;

	public JPanelOfAdminMain(JPanelTest win) {
		this.win = win;
		setLayout(null);

		JButton btn1 = new JButton("교수 관리");
		JButton btn2 = new JButton("학생 관리");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelOfAddStudent");
			}
		});
		JButton btn3 = new JButton("수업 관리");
		// ★ 버튼 위치와 크기 설정
		btn1.setBounds(30, 170, 122, 30);
		btn2.setBounds(182, 170, 122, 30);
		btn3.setBounds(354, 170, 122, 30);

		add(btn1);
		add(btn2);
		add(btn3);

		btn1.addActionListener(new MyActionListener());
		btn3.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 2번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
}

@SuppressWarnings("serial")
class JPanel01 extends JPanel { // 1번째 패널

	private JButton jButton1;
	private JButton btn1, btn2, btn3;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JPanelTest win;

	public JPanel01(JPanelTest win) {
		this.win = win;
		setLayout(null);

		JButton btn1 = new JButton("관리자");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("JPanelOfAdminMain");
			}
		});
		JButton btn2 = new JButton("교수");
		JButton btn3 = new JButton("학생");
		// ★ 버튼 위치와 크기 설정
		btn1.setBounds(30, 170, 122, 30);
		btn2.setBounds(182, 170, 122, 30);
		btn3.setBounds(354, 170, 122, 30);

		add(btn1);
		add(btn2);
		add(btn3);

		btn2.addActionListener(new MyActionListener());
		btn3.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 2번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
}

@SuppressWarnings("serial")
class JPanel02 extends JPanel { // 2번째 패널
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanelTest win;

	public JPanel02(JPanelTest win) {
		setLayout(null);
		this.win = win;
		JLabel lblLbl = new JLabel("아이디:");
		lblLbl.setBounds(31, 40, 67, 15);
		add(lblLbl);

		textField = new JTextField();
		textField.setBounds(123, 40, 116, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblLbl_1 = new JLabel("암호:");
		lblLbl_1.setBounds(31, 84, 67, 15);
		add(lblLbl_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(123, 84, 116, 21);
		add(passwordField);

		JButton btn = new JButton("버튼");
		btn.setSize(70, 20);
		btn.setLocation(10, 10);
		add(btn);
		btn.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 1번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}
}

@SuppressWarnings("serial")
class JPanelTest extends JFrame {

	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;
	public JPanelOfAdminMain jpanelOfAdminMain = null;
	public JPanelOfAddStudent jpanelOfAddStudent = null;

	public void change(String panelName) { // 패널 1번과 2번 변경 후 재설정

		if (panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		} else if (panelName.equals("JPanelOfAdminMain")) {
			getContentPane().removeAll();
			getContentPane().add(jpanelOfAdminMain);
			revalidate();
			repaint();
		} else if (panelName.equals("jpanelOfAddStudent")) {
			getContentPane().removeAll();
			getContentPane().add(jpanelOfAddStudent);
			revalidate();
			repaint();
		} else {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		}
	}

}

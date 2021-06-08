import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
class AdminHome extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
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
		
		title.setBounds(460, 5, 200, 50);
		
		btn1.setBounds(125, 200, 150, 100);
		btn2.setBounds(325, 200, 150, 100);
		btn3.setBounds(525, 200, 150, 100);
		btn4.setBounds(725, 200, 150, 100);
		btn5.setBounds(125, 350, 150, 100);
		btn6.setBounds(325, 350, 150, 100);
		btn7.setBounds(525, 350, 150, 100);
		btn8.setBounds(725, 350, 150, 100);
		

		add(title);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);

		btn1.addActionListener(new MyActionListener());
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Hello");
				win.change("jpanelOfAddStudent");
			}
		});
		btn3.addActionListener(new MyActionListener());
		
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
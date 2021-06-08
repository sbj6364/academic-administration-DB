import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
package sejong.DB.Byeongjoon;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		JPanelTest win = new JPanelTest();

		win.setTitle("frame test");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.jpanelOfAdminMain = new JPanelOfAdminMain(win);
		win.jpanelOfAddStudent = new JPanelOfAddStudent(win);

		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(540, 400);
		win.setVisible(true);
		
	}

}

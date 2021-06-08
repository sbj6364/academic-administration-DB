import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		JPanelTest win = new JPanelTest();


		win.setTitle("17011806 Seo Byeong Jun");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.adminHome = new AdminHome(win);
		win.professorHome = new ProfessorHome(win);
		win.studentHome = new StudentHome(win);
		win.jpanelOfAddStudent = new JPanelOfAddStudent(win);
		win.tableView = new TableView(win);
		win.pLectureView = new PLectureView(win);

		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setBounds(150, 100, 1000, 700);
		win.setVisible(true);
		
	}

}


import java.awt.BorderLayout;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class JC17011806M1 extends JFrame implements ActionListener {
   JButton btnInput, btnBook, btnOrders, btnCustomer, btn1, btn2, btn3, btnClear, btnResetAll;
   JTextField f1, f2, f3, f4, f5;
   JTextArea txtResult, txtStatus;
   JPanel pn1, pn2, pn3;

   static Connection con;
   Statement stmt;
   ResultSet rs;
   String Driver = "";
   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
   String userid = "madang";
   String pwd = "madang";

   public JC17011806M1() {
      super("Sejong Academic Information Plaza");
      layInit();
      conDB();
      setVisible(true);
      setBounds(100, 100, 1200, 900); //가로위치, 세로위치, 가로길이, 세로길이
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void layInit() {
	  
//      JPanel MainContainer = new JPanel();
//      setContentPane(MainContainer);

	  
      btnInput = new JButton("Input");
      btnBook = new JButton("1");
      btnOrders = new JButton("2");
      btnCustomer = new JButton("3");
      btn1 = new JButton("4");
      btn2 = new JButton("5");
      btn3 = new JButton("6");
	  btnResetAll = new JButton("Reset");
      btnClear = new JButton("Clear");
      txtResult = new JTextArea();
      txtStatus = new JTextArea(5,20);
      
      pn1 = new JPanel();
      pn1.add(btnBook);
      pn1.add(btnOrders);
      pn1.add(btnCustomer);
      pn1.add(btn1);
      pn1.add(btn2);
      pn1.add(btn3);
      pn1.add(btnClear);
      pn1.add(btnResetAll);
      
      pn2 = new JPanel();
      pn2.setBounds(100, 100, 600, 50);
	  f1 = new JTextField(5);
	  f2 = new JTextField(5);
	  f3 = new JTextField(5);
	  f4 = new JTextField(5);
	  f5 = new JTextField(10);
	  
	  f1.setText("orderid");
	  f2.setText("custid");
	  f3.setText("bookid");
	  f4.setText("saleprice");
	  f5.setText("orderdate");
	  
	  
	  pn2.add(f1);
	  pn2.add(f2);
	  pn2.add(f3);
	  pn2.add(f4);
	  pn2.add(f5);
	  pn2.add(btnInput);
	   
	  f1.setBounds(30, 170, WIDTH, HEIGHT);
	  f2.setBounds(30, 200, WIDTH, HEIGHT);
      
	  pn3 = new JPanel();
	  pn3.add(btnBook);
	  
      
      txtResult.setEditable(false);
      txtStatus.setEditable(false);
      
      JScrollPane scrollPane = new JScrollPane(txtResult);
      JScrollPane scrollPane2 = new JScrollPane(txtStatus);
      
//      add("North", pn1);
//      add("South", pn2);
      add("North", pn1);
      add("South", pn2);
      add("Center", scrollPane);
      add("Center", pn3);
      add("South", scrollPane2);
      
      btnInput.addActionListener(this);
      btnBook.addActionListener(this);
      btnOrders.addActionListener(this);
      btnCustomer.addActionListener(this);
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      btnClear.addActionListener(this);
      btnResetAll.addActionListener(this);
      
      
      txtResult.setText("[17011806 / Seo Byeong Jun]\n\nWelcome to madang database!\n\n\n"
	  		   	+ "------------Button Description------------\n"
	   			+ "  (1)   Book table\n\n"
    			+ "  (2)   Orders table\n\n"
    			+ "  (3)   Customer table\n\n"
    			+ "  (4)   Name of the books that Park Ji-sung didn't buy\n\n"
    			+ "  (5)   Number of book publishers purchased by Park Ji-sung\n\n"
    			+ "  (6)   Number of books purchased by Park Ji-sung\n\n"
    			+ "(Clear) Clearing console window\n\n"
    			+ "(Reset) Reset order table\n"
    			+ "--------------------------------------\n\n"
    			
       		+ "Please be aware that the contents below"
       		+ " should be followed when inserting data into database.\n\n"
       		+ "- orderid(int): primary key, not null. Do not insert values which already exists.\n"
       		+ "- custid(int): customer's id from Customer table.\n"
       		+ "- bookid(int): book's id from Book table.\n"
       		+ "- saleprice(int): saleprices.\n"
       		+ "- orderdate(date): date of the order.\n\n");
   }

   public void conDB() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         //System.out.println("Driver Load Success");
         txtStatus.append("Driver Load Success...\n");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      
      try { /* Database 연결 과정 */
          //System.out.println("Database 연결 준비...");
    	  txtStatus.append("Database connecting...\n");
          con = DriverManager.getConnection(url, userid, pwd);
          //System.out.println("Database 연결 성공...");
          txtStatus.append("Database connected!\n");
       } catch (SQLException e1) {
          e1.printStackTrace();
       }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   // search book
	   
	   if (e.getSource() == btnInput) {
////		   new inputWindow();
//		   
//		   
//		   
		   int orderid = 11;
		   int custid = 1;
		   int bookid = 8;
		   int saleprice = 10000;
		   String orderdate = "2021-04-20";
//		   
//		   
////		   if(!isNumeric(t1)){
////			   showErrorMsg(f1,"Input numbers!");
////		    return;
////		   }else{
////			   orderid = Integer.parseInt(t1);
////		   }

//
		   String s1 = String.valueOf(f1.getText());
		   String s2 = String.valueOf(f2.getText());
		   String s3 = String.valueOf(f3.getText());
		   String s4 = String.valueOf(f4.getText());
		   String s5 = String.valueOf(f5.getText());
//		   
		   orderid = Integer.parseInt(s1);
		   custid = Integer.parseInt(s2);
		   bookid = Integer.parseInt(s3);
		   saleprice = Integer.parseInt(s4);
		   orderdate = s5;

		   
		   String sql = "INSERT INTO Orders VALUES (?,?,?,?,?);";
		   try {
			   System.out.println("입력받는중...");
			   stmt = con.createStatement();
			   txtResult.setText("");
			   txtResult.setText("\n\nInserting data...\n.\n.\n.\n");
			   PreparedStatement pstat = con.prepareStatement(sql);
			   pstat.setInt(1, orderid);
			   pstat.setInt(2, custid);
			   pstat.setInt(3, bookid);
			   pstat.setInt(4, saleprice);
			   pstat.setString(5, orderdate);

			   pstat.executeUpdate();
			   txtResult.append("Insert Completed!\n");
			  }
			  catch (Exception e2) {
				  txtResult.append("Inserting Failed!\n"
				  				+ "Please try again with proper values.");
				  System.out.println("쿼리 읽기 실패 :" + e2);

/* 		   } finally {
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
	   }
	   
	   //search1
	   else if (e.getSource() == btnBook) {
		  try {
			  stmt = con.createStatement();
		      String query = "SELECT * FROM Book";
		      txtResult.setText("");
		      txtResult.setText("\n\nBOOKNO \t BOOK NAME \t PUBLISHER \t PRICE\n");
		      rs = stmt.executeQuery(query);
		      while (rs.next()) {
		    	  String str = rs.getInt(1) + "\t"
		    			  + rs.getString(2) + "\t"
		    			  + rs.getString(3) + "\t"
		    			  + rs.getInt(4) + "\n";
		          txtResult.append(str);
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
	   }
	   
	   // search2
	   else if (e.getSource() == btnOrders) {
		   try {
			   stmt = con.createStatement();
			   String query = "SELECT * FROM Orders";
			   txtResult.setText("");
			   txtResult.setText("\n\nORDER_ID \t CUST_ID \t BOOK_ID \t SALE_PRICE \t ORDERDATE\n");
			   rs = stmt.executeQuery(query);
			   while (rs.next()) {
				   String str = rs.getInt(1) + "\t"
						   + rs.getInt(2) + "\t"
						   + rs.getInt(3) + "\t"
						   + rs.getInt(4) + "\t" 
						   + rs.getDate(5) + "\n";
				   txtResult.append(str);
			   }
		   }
		   catch (Exception e2) {
			   System.out.println("쿼리 읽기 실패 :" + e2);
		   }
	   }
	   
	   // search3
	   else if (e.getSource() == btnCustomer) {
		   try {
			   stmt = con.createStatement();
			   String query = "SELECT * FROM Customer";
			   txtResult.setText("");
			   txtResult.setText("\n\nCUST_ID \t NAME \t ADDRESS \t PHONE\n");
			   rs = stmt.executeQuery(query);
			   while (rs.next()) {
				   String str = rs.getInt(1) + "\t"
						   + rs.getString(2) + "\t"
						   + rs.getString(3) + "\t"
						   + rs.getString(4) + "\n";
				   txtResult.append(str);
			   }
		   }
		   catch (Exception e2) {
			   System.out.println("쿼리 읽기 실패 :" + e2);
		   }
	   }
	   
	   // search4
	   else if (e.getSource() == btn1) {
		   try {
			   stmt = con.createStatement();
			   String query = "select B.bookname from Book B where B.bookid in"
					   			+ "(select bookid from Orders O where O.custid in"
						   			+ "(select C.custid from Customer C where name != '박지성'))";
			   txtResult.setText("");
			   txtResult.setText("\n\nBOOKNAME\n");
			   rs = stmt.executeQuery(query);
			   while (rs.next()) {
				   String str = rs.getString(1) + "\n";
				   txtResult.append(str);
			   }
		   }
		   catch (Exception e2) {
			   System.out.println("쿼리 읽기 실패 :" + e2);
		   }
	   }
	   
	   // search5
	   else if (e.getSource() == btn2) {
		   try {
			   stmt = con.createStatement();
			   String query = "select count(distinct publisher) from Book B where B.bookid in"
			   					+ "(select bookid from Orders O where O.custid in"
			   						+ "(select C.custid from Customer C where name = '박지성'))";
			   txtResult.setText("");
			   txtResult.setText("\n\nTotal publishers\n");
			   rs = stmt.executeQuery(query);
			   while (rs.next()) {
				   String str = rs.getInt(1) + "\n";
				   txtResult.append(str);
			   }
		   }
		   catch (Exception e2) {
			   System.out.println("쿼리 읽기 실패 :" + e2);
		   }
	   }
	   
	   // search6
	   else if (e.getSource() == btn3) {
		   try {
			   stmt = con.createStatement();
			   String query = "select count(*) from Book B where B.bookid in"
			   					+ "(select bookid from Orders O where O.custid in"
			   						+ "(select C.custid from Customer C where name = '박지성'))";
			   txtResult.setText("");
			   txtResult.setText("\n\nTotal books\n");
			   rs = stmt.executeQuery(query);
			   while (rs.next()) {
				   String str = rs.getInt(1) + "\n";
				   txtResult.append(str);
			   }
		   }
		   catch (Exception e2) {
			   System.out.println("쿼리 읽기 실패 :" + e2);
		   }
	   }

	   /* madang DB 자료 생성 */
	   /* 이후 실습은 MySQL Workbench에서 초기화면에서 +를 눌러 madang connection을 만들어 접속하여 사용한다. */
	    


//
//	   INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
//	   INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');  
//	   INSERT INTO Customer VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001');
//	   INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
//	   INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전',  NULL);

	   // reset
	   else if (e.getSource() == btnResetAll) {
		   int[] b_bookid = {1,2,3,4,5,6,7,8,9,10};
		   String[] bookname = {"축구의 역사","축구아는 여자","축구의 이해","골프 바이블","피겨 교본",
				   				"역도 단계별기술","야구의 추억","야구를 부탁해","올림픽 이야기","Olympic Champions"};
		   String[] publisher = {"굿스포츠","나무수","대한미디어","대한미디어","굿스포츠",
	   							"굿스포츠","이상미디어","이상미디어","삼성당","Pearson"};
		   int[] price = {7000,13000,22000,35000,8000,6000,20000,13000,7500,13000};
		   int[] c_custid = {1,2,3,4,5};
		   String[] name = {"박지성","김연아","장미란","추신수","박세리"};
		   String[] address = {"영국 맨체스타","대한민국 서울","대한민국 강원도","미국 클리블랜드","대한민국 대전"};
		   String[] phone = {"000-5000-0001","000-6000-0001","000-7000-0001","000-8000-0001",null};
		   
		   
		   
		   int[] orderid = {1,2,3,4,5,6,7,8,9,10};
		   int[] custid = {1,1,2,3,4,1,4,3,2,3};
		   int[] bookid = {1,3,5,6,7,2,8,10,10,8};
		   int[] saleprice = {6000,21000,8000,6000,
				   			20000,12000,13000,
				   			12000,7000,13000};
		   String[] orderdate = {"2014-07-01","2014-07-03",
				   				"2014-07-03","2014-07-04",
				   				"2014-07-05","2014-07-07",
				   				"2014-07-07","2014-07-08",
				   				"2014-07-09","2014-07-10"};
		   String sql = "DELETE FROM Book;";
		   String sql2 = "DELETE FROM Customer;";
		   String sql3 = "DELETE FROM Orders;";
		   String query1 = "INSERT INTO Book VALUES (?, ?, ?, ?);";
		   String query2 = "INSERT INTO Customer VALUES (?, ?, ?, ?);";
		   String query3 = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?);";
		   try {
			   stmt = con.createStatement();
			   
			   txtResult.setText("");
			   txtResult.setText("\n\nDeleting all data...\n.\n.\n");
			   PreparedStatement pstat00 = con.prepareStatement(sql3);
			   pstat00.executeUpdate();
			   PreparedStatement pstat0 = con.prepareStatement(sql2);
			   pstat0.executeUpdate();
			   PreparedStatement pstat = con.prepareStatement(sql);
			   pstat.executeUpdate();

			   txtResult.append("Successfully deleted!\n\n\n");
			   
			   txtResult.append("Inserting madang data...\n.\n.\n");
			   
			   PreparedStatement pstat2 = con.prepareStatement(query1);
			   for(int i=0;i<10;i++) {
				   pstat2.setInt(1, b_bookid[i]);
				   pstat2.setString(2, bookname[i]);
				   pstat2.setString(3, publisher[i]);
				   pstat2.setInt(4, price[i]);
				   pstat2.executeUpdate();
			   }
			   
			   PreparedStatement pstat3 = con.prepareStatement(query2);
			   for(int i=0;i<5;i++) {
				   pstat3.setInt(1, c_custid[i]);
				   pstat3.setString(2, name[i]);
				   pstat3.setString(3, address[i]);
				   pstat3.setString(4, phone[i]);
				   pstat3.executeUpdate();
			   }
			   
			   PreparedStatement pstat4 = con.prepareStatement(query3);
			   for(int i=0;i<10;i++) {
				   pstat4.setInt(1, orderid[i]);
				   pstat4.setInt(2, custid[i]);
				   pstat4.setInt(3, bookid[i]);
				   pstat4.setInt(4, saleprice[i]);
				   pstat4.setString(5, orderdate[i]);
				   pstat4.executeUpdate();
			   }
			   txtResult.append("Successfully inserted!\n\n\nDatabase Reset Complete");
			   
		   }
		   catch (Exception e2) {
			   System.out.println("\n\nReset Failed. :" + e2);
		   }
	   }
	   
	  
	   else if (e.getSource() == btnClear) {
           txtResult.setText("[17011806 / Seo Byeong Jun]\n\n"
        		   	+ "Welcome to madang database!\n\n\n"
        		   	+ "------------Button Description------------\n"
         			+ "  (1)   Book table\n\n"
          			+ "  (2)   Orders table\n\n"
          			+ "  (3)   Customer table\n\n"
          			+ "  (4)   Name of the books that Park Ji-sung didn't buy\n\n"
          			+ "  (5)   Number of book publishers purchased by Park Ji-sung\n\n"
          			+ "  (6)   Number of books purchased by Park Ji-sung\n\n"
          			+ "(Clear) Clearing console window\n\n"
          			+ "(Reset) Reset order table\n"
          			+ "----------------------------------------\n\n"
          			
             		+ "Please be aware that the contents below"
             		+ " should be followed when inserting data into database.\n\n"
             		+ "- orderid(int): primary key, not null. Do not insert values which already exists.\n"
             		+ "- custid(int): customer's id from Customer table.\n"
             		+ "- bookid(int): book's id from Book table.\n"
             		+ "- saleprice(int): saleprices.\n"
             		+ "- orderdate(date): date of the order.\n\n");
           f1.setText("");
           f2.setText("");
           f3.setText("");
           f4.setText("");
           f5.setText("");
	   }

   }
   

   public static void main(String[] args) {
      JC17011806M1 BLS = new JC17011806M1();
      
      //BLS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      //BLS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      BLS.addWindowListener(new WindowAdapter() {
    	  public void windowClosing(WindowEvent we) {
    		try {
    			con.close();
    		} catch (Exception e4) { 	}
    		System.out.println("프로그램 완전 종료 !");
    		System.exit(0);
    	  }
    	});
   }
	
}

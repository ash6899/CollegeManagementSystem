import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener,ItemListener
{
	private JLabel username,password,authenticationtype,heading;
	private JTextField user;
	private JComboBox authoritytype;
	private JButton login,reset,exit;
	private JPasswordField pass;
	private String s;
	public Login()
	{
		setSize(700,500);
		setTitle("College Management System");
		username = new JLabel("UserName");
		password = new JLabel("Password");
		authenticationtype = new JLabel("Authentication Type");
		heading = new JLabel("COLLEGE MANAGEMENT SYSTEM");
		user = new JTextField(20);
		authoritytype = new JComboBox();
		authoritytype.addItem("Select");
		authoritytype.addItem("Student");
		authoritytype.addItem("Faculty");
		authoritytype.addItem("Admin");
		login = new JButton("Login");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		pass = new JPasswordField();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		//setContentPane(new JLabel(new ImageIcon("cms.jpg")));
		heading.setBounds(120,50,400,50);
		username.setBounds(100,150,200,20);
		user.setBounds(300,150,200,20);
		password.setBounds(100,200,200,20);
		pass.setBounds(300,200,200,20);
		authenticationtype.setBounds(100,250,200,20);
		authoritytype.setBounds(300,250,200,20);
		login.setBounds(100,350,100,20);
		reset.setBounds(250,350,100,20);
		exit.setBounds(400,350,100,20);
		add(heading);
		add(username);
		add(user);
		add(password);
		add(pass);
		add(authenticationtype);
		add(authoritytype);
		add(login);
		add(reset);
		add(exit);
		heading.setFont(new Font("Courier", Font.BOLD,27));
		authoritytype.addItemListener(this);
		login.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == login)
		{
			if(s.equals("Admin"))
			{
				String adminid = user.getText().trim();
				String adminpass = pass.getText().trim();
										try
												{
													DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
													Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
													Statement stmt=con.createStatement();
													String query="select* from admindetail where ID='"+adminid+"'";
													ResultSet rst=stmt.executeQuery(query);
													if(rst.next())
													{
														String adminpassword=rst.getString(2);
														if(adminpassword.equals(adminpass))
														{	dispose();
															WelcomeAdmin obj = new WelcomeAdmin();
														}
														else
														{
															JOptionPane.showMessageDialog(this,"The Password is Wrong.");
														}
													}
													else
														JOptionPane.showMessageDialog(this,"The Record is NOT Found.");
												}
										catch(Exception exp)
											{
												System.out.println("ERROR:"+exp);
											}
			}
			else if(s.equals("Faculty"))
			{
				String facultyid = user.getText().trim();
				String facultypass = pass.getText().trim();
										try
												{
													DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
													Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
													Statement stmt=con.createStatement();
													String query="select* from facultydetail where ID='"+facultyid+"'";
													ResultSet rst=stmt.executeQuery(query);
													if(rst.next())
													{
														String facultypassword=rst.getString(9);
														if(facultypassword.equals(facultypass))
														{	dispose();
															WelcomeFaculty obj = new WelcomeFaculty();
														}
														else
														{
															JOptionPane.showMessageDialog(this,"The Password is Wrong.");
														}
													}
													else
														JOptionPane.showMessageDialog(this,"The Record is NOT Found.");
												}
										catch(Exception exp)
											{
												System.out.println("ERROR:"+exp);
											}
			}
			else if(s.equals("Student"))
			{
				String studentid = user.getText().trim();
				String studentpass = pass.getText().trim();
										try
												{
													DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
													Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
													Statement stmt=con.createStatement();
													String query="select* from studentdetail where ID='"+studentid+"'";
													ResultSet rst=stmt.executeQuery(query);
													if(rst.next())
													{
														String studentpassword=rst.getString(8);
														if(studentpassword.equals(studentpass))
														{	dispose();
															WelcomeStudent obj = new WelcomeStudent(studentid);
														}
														else
														{
															JOptionPane.showMessageDialog(this,"The Password is Wrong.");
														}
													}
													else
														JOptionPane.showMessageDialog(this,"The Record is NOT Found.");
												}
										catch(Exception exp)
											{
												System.out.println("ERROR:"+exp);
											}
			}
		}
		else if(e.getSource() == reset)
		{
			user.setText("");
			pass.setText("");
			user.requestFocus();
		}
		else if(e.getSource() == exit)
		{
			System.exit(1);
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == authoritytype)
		{
			 s = (String)authoritytype.getSelectedItem();
			
		}
	}

}
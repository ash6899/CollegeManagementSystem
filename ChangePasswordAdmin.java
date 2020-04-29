import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ChangePasswordAdmin extends JFrame implements ActionListener
{
	private JLabel oldpassword,newpassword;
	private JButton update,reset,goback;
	private JPasswordField oldpass,newpass;
	public ChangePasswordAdmin()
	{
		setSize(700,500);
		setTitle("Change Password Admin");
		oldpassword = new JLabel("Old Password");
		newpassword = new JLabel("New Password");
		oldpass = new JPasswordField(20);
		update = new JButton("Update");
		reset = new JButton("Reset");
		goback = new JButton("Go Back");
		newpass = new JPasswordField();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		oldpassword.setBounds(100,100,200,20);
		oldpass.setBounds(300,100,200,20);
		newpassword.setBounds(100,150,200,20);
		newpass.setBounds(300,150,200,20);
		update.setBounds(100,300,100,20);
		reset.setBounds(250,300,100,20);
		goback.setBounds(400,300,100,20);
		add(oldpassword);
		add(oldpass);
		add(newpassword);
		add(newpass);
		add(update);
		add(reset);
		add(goback);
		update.addActionListener(this);
		reset.addActionListener(this);
		goback.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == update)
		{
			String old = oldpass.getText().trim();
										try
												{
													DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
													Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
													Statement stmt=con.createStatement();
													String query="select* from admindetail where PASSWORD='"+old+"'";
													ResultSet rst=stmt.executeQuery(query);
													if(rst.next())
													{
														try
															{
																
																String recent=newpass.getText().trim();
									
																String query1="update admindetail Set PASSWORD='"+recent+"' where PASSWORD='"+old+"'";
																long ans=stmt.executeUpdate(query1);
																if(ans==0)
																	JOptionPane.showMessageDialog(this,"The Record is not Updated.");
																else{
																	JOptionPane.showMessageDialog(this,"The Record is Successfully Updated.");
																	newpass.setText("");
																	oldpass.setText("");
													
																	oldpass.requestFocus();

																}
															}
															catch(Exception exp)
															{
																System.out.println("ERROR:"+exp);
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
		else if(e.getSource() == reset)
		{
			oldpass.setText("");
			newpass.setText("");
			oldpass.requestFocus();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeAdmin obj = new WelcomeAdmin();
		}
	}

}
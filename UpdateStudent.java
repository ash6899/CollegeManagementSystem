import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateStudent extends JFrame implements ActionListener
{
	private JLabel cid,cname,branchs,sem,dob,phoneno,email;
	private JTextField id,name,branch,semester,dateofbirth,phone,emailid;
	private JButton search,clear,goback,update;
	public UpdateStudent()
	{
		setSize(700,500);
		setTitle("Update Student");
		cid = new JLabel("ID");
		cname = new JLabel("Name");
		branchs = new JLabel("Branch");
		dob = new JLabel("Date Of Birth");
		sem = new JLabel("Semester");
		phoneno = new JLabel("Phone No.");
		email = new JLabel("Email");
		id = new JTextField(20);
		name = new JTextField(20);
		branch = new JTextField(20);
		dateofbirth = new JTextField(20);
		semester = new JTextField(20);
		phone = new JTextField(20);
		emailid = new JTextField(20);
		search = new JButton("Search");
		clear = new JButton("Clear");
		goback = new JButton("Go Back");
		update = new JButton("Update");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		cid.setBounds(100,20,200,20);
		cname.setBounds(100,60,200,20);
		branchs.setBounds(100,100,200,20);
		sem.setBounds(100,140,200,20);
		dob.setBounds(100,180,200,20);
		phoneno.setBounds(100,220,200,20);
		email.setBounds(100,260,200,20);
		id.setBounds(300,20,200,20);
		name.setBounds(300,60,200,20);
		branch.setBounds(300,100,200,20);
		semester.setBounds(300,140,200,20);
		dateofbirth.setBounds(300,180,200,20);
		phone.setBounds(300,220,200,20);
		emailid.setBounds(300,260,200,20);
		search.setBounds(550,20,100,20);
		clear.setBounds(100,320,100,20);
		goback.setBounds(250,320,100,20);
		update.setBounds(400,320,100,20);
		add(cid);
		add(cname);
		add(branchs);
		add(dob);
		add(sem);
		add(phoneno);
		add(email);
		add(id);
		add(name);
		add(branch);
		add(dateofbirth);
		add(semester);
		add(phone);
		add(emailid);
		add(search);
		add(clear);
		add(goback);
		add(update);
		update.addActionListener(this);
		search.addActionListener(this);
		clear.addActionListener(this);
		goback.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == search)
		{
			try
			{
				DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement stmt=con.createStatement();
				String studentid=id.getText().trim();
				String query="select* from studentdetail where ID='"+studentid+"'";
				ResultSet rst=stmt.executeQuery(query);
				if(rst.next())
				{
					id.setText(rst.getString(1));
					name.setText(rst.getString(2));
					branch.setText(rst.getString(3));
					semester.setText(rst.getString(4));
					dateofbirth.setText(rst.getString(5));
					phone.setText(rst.getString(6));
					emailid.setText(rst.getString(7));
				}
				else
				JOptionPane.showMessageDialog(this,"The Record is NOT Found.");
			}
			catch(Exception exp)
			{
				System.out.println("ERROR:"+exp);
			}
		}
		else if(e.getSource() == clear)
		{
			id.setText("");
			name.setText("");
			branch.setText("");
			semester.setText("");
			dateofbirth.setText("");
			phone.setText("");
			emailid.setText("");
			id.requestFocus();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeAdmin obj = new WelcomeAdmin();
		}
		else if(e.getSource() == update)
		{
			try
			{
				DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement stmt=con.createStatement();
				String studentid=id.getText().trim();
				String studentname=name.getText().trim();
				String studentbranch=branch.getText().trim();
				String studentsem=semester.getText().trim();
				String studentdob=dateofbirth.getText().trim();
				String studentphone=phone.getText().trim();
				String studentemail=emailid.getText().trim();
				String query="update studentdetail Set NAME='"+studentname+"',BRANCH='"+studentbranch+"',SEMESTER='"+studentsem+"',DATEOFBIRTH='"+studentdob+"',PHONENO='"+studentphone+"',EMAIL='"+studentemail+"' where ID='"+studentid+"'";
				long ans=stmt.executeUpdate(query);
				if(ans==0)
					JOptionPane.showMessageDialog(this,"The Record is not Updated.");
				else{
					JOptionPane.showMessageDialog(this,"The Record is Successfully Updated.");
					id.setText("");
					name.setText("");
					branch.setText("");
					semester.setText("");
					dateofbirth.setText("");
					phone.setText("");
					emailid.setText("");
					id.requestFocus();

				}
			}
			catch(Exception exp)
			{
				System.out.println("ERROR:"+exp);
			}
		}
	}
}
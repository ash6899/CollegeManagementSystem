import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateMarks extends JFrame implements ActionListener
{
	private JLabel cid,cname,branchs,sem,sub1,sub2,sub3;
	private JTextField id,name,branch,semester,subject1,subject2,subject3;
	private JButton search,clear,goback,update;
	public UpdateMarks()
	{
		setSize(700,500);
		setTitle("Update Marks");
		cid = new JLabel("ID");
		cname = new JLabel("Name");
		branchs = new JLabel("Branch");
		sub1 = new JLabel("Subject 1");
		sem = new JLabel("Semester");
		sub2 = new JLabel("Subject 2");
		sub3 = new JLabel("Subject 3");
		id = new JTextField(20);
		name = new JTextField(20);
		branch = new JTextField(20);
		subject1 = new JTextField(20);
		semester = new JTextField(20);
		subject2 = new JTextField(20);
		subject3 = new JTextField(20);
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
		sub1.setBounds(100,180,200,20);
		sub2.setBounds(100,220,200,20);
		sub3.setBounds(100,260,200,20);
		id.setBounds(300,20,200,20);
		name.setBounds(300,60,200,20);
		branch.setBounds(300,100,200,20);
		semester.setBounds(300,140,200,20);
		subject1.setBounds(300,180,200,20);
		subject2.setBounds(300,220,200,20);
		subject3.setBounds(300,260,200,20);
		search.setBounds(550,20,100,20);
		clear.setBounds(100,320,100,20);
		goback.setBounds(250,320,100,20);
		update.setBounds(400,320,100,20);
		add(cid);
		add(cname);
		add(branchs);
		add(sub1);
		add(sem);
		add(sub2);
		add(sub3);
		add(id);
		add(name);
		add(branch);
		add(subject1);
		add(semester);
		add(subject2);
		add(subject3);
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
					subject1.setText(rst.getString(9));
					subject2.setText(rst.getString(10));
					subject3.setText(rst.getString(11));
				}
				else
				JOptionPane.showMessageDialog(this,"The Record is NOT Found.");
			}
			catch(Exception exp)
			{
				System.out.println("ERROR:"+exp);
			}
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
				String studentsub1=subject1.getText().trim();
				String studentsub2=subject2.getText().trim();
				String studentsub3=subject3.getText().trim();
				String query="update studentdetail Set NAME='"+studentname+"',BRANCH='"+studentbranch+"',SEMESTER='"+studentsem+"',MARKS1='"+studentsub1+"',MARKS2='"+studentsub2+"',MARKS3='"+studentsub3+"' where ID='"+studentid+"'";
				long ans=stmt.executeUpdate(query);
				if(ans==0)
					JOptionPane.showMessageDialog(this,"The Record is not Saved.");
				else{
					JOptionPane.showMessageDialog(this,"The Record is Successfully Saved.");
					id.setText("");
					name.setText("");
					branch.setText("");
					semester.setText("");
					subject1.setText("");
					subject2.setText("");
					subject3.setText("");
					id.requestFocus();

				}
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
			subject1.setText("");
			subject2.setText("");
			subject3.setText("");
			id.requestFocus();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeAdmin obj = new WelcomeAdmin();
		}
	}
}
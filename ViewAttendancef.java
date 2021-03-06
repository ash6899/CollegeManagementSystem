import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ViewAttendancef extends JFrame implements ActionListener
{
	private JLabel cid,cname,branchs,sem,sub1,sub2,sub3;
	private JTextField id,name,branch,semester,subject1,subject2,subject3;
	private JButton search,clear,goback;
	public ViewAttendancef()
	{
		setSize(700,500);
		setTitle("View Attendance");
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
		goback.setBounds(300,320,100,20);
		add(goback);
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
		goback.addActionListener(this);
		search.addActionListener(this);
		clear.addActionListener(this);
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
					subject1.setText(rst.getString(12));
					subject2.setText(rst.getString(13));
					subject3.setText(rst.getString(14));
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
			subject1.setText("");
			subject2.setText("");
			subject3.setText("");
			id.requestFocus();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeFaculty obj = new WelcomeFaculty();
		}
	}
}
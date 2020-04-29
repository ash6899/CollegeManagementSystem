import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateFaculty extends JFrame implements ActionListener
{
	private JLabel fid,fname,dept,datejoin,dob,skills,phoneno,email;
	private JTextField id,name,department,dateofjoin,dateofbirth,skill,phone,emailid;
	private JButton search,clear,goback,update;
	public UpdateFaculty()
	{
		setSize(700,500);
		setTitle("Update Faculty");
		fid = new JLabel("ID");
		fname = new JLabel("Name");
		dept = new JLabel("Department");
		datejoin = new JLabel("Date Of Joining");
		dob = new JLabel("Date Of Birth");
		skills = new JLabel("Skills");
		phoneno = new JLabel("Phone No.");
		email = new JLabel("Email");
		id = new JTextField(20);
		name = new JTextField(20);
		department = new JTextField(20);
		dateofjoin = new JTextField(20);
		dateofbirth = new JTextField(20);
		skill = new JTextField(20);
		phone = new JTextField(20);
		emailid = new JTextField(20);
		search = new JButton("Search");
		clear = new JButton("Clear");
		goback = new JButton("Go Back");
		update = new JButton("Update");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		fid.setBounds(100,20,200,20);
		fname.setBounds(100,60,200,20);
		dept.setBounds(100,100,200,20);
		datejoin.setBounds(100,140,200,20);
		dob.setBounds(100,180,200,20);
		skills.setBounds(100,220,200,20);
		phoneno.setBounds(100,260,200,20);
		email.setBounds(100,300,200,20);
		id.setBounds(300,20,200,20);
		name.setBounds(300,60,200,20);
		department.setBounds(300,100,200,20);
		dateofjoin.setBounds(300,140,200,20);
		dateofbirth.setBounds(300,180,200,20);
		skill.setBounds(300,220,200,20);
		phone.setBounds(300,260,200,20);
		emailid.setBounds(300,300,200,20);
		search.setBounds(550,20,100,20);
		clear.setBounds(100,400,100,20);
		goback.setBounds(250,400,100,20);
		update.setBounds(400,400,100,20);
		add(fid);
		add(fname);
		add(dept);
		add(datejoin);
		add(dob);
		add(skills);
		add(phoneno);
		add(email);
		add(id);
		add(name);
		add(department);
		add(dateofjoin);
		add(dateofbirth);
		add(skill);
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
			String facultyid=id.getText().trim();
			String query="select* from facultydetail where ID='"+facultyid+"'";
			ResultSet rst=stmt.executeQuery(query);
			if(rst.next())
			{
				id.setText(rst.getString(1));
				name.setText(rst.getString(2));
				department.setText(rst.getString(3));
				dateofjoin.setText(rst.getString(4));
				dateofbirth.setText(rst.getString(5));
				skill.setText(rst.getString(6));
				phone.setText(rst.getString(7));
				emailid.setText(rst.getString(8));
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
			department.setText("");
			dateofjoin.setText("");
			dateofbirth.setText("");
			skill.setText("");
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
				String facultyid=id.getText().trim();
				String facultyname=name.getText().trim();
				String facultydept=department.getText().trim();
				String facultydoj=dateofjoin.getText().trim();
				String facultydob=dateofbirth.getText().trim();
				String facultyskill=skill.getText().trim();
				String facultyphone=phone.getText().trim();
				String facultyemail=emailid.getText().trim();
				String query="update facultydetail Set NAME='"+facultyname+"',DEPARTMENT='"+facultydept+"',DATEOFJOIN='"+facultydoj+"',DATEOFBIRTH='"+facultydob+"',SKILLS='"+facultyskill+"',PHONENO='"+facultyphone+"',EMAIL='"+facultyemail+"' where ID='"+facultyid+"'";
				long ans=stmt.executeUpdate(query);
				if(ans==0)
					JOptionPane.showMessageDialog(this,"The Record is not Updated.");
				else{
					JOptionPane.showMessageDialog(this,"The Record is Successfully Updated.");
					id.setText("");
					name.setText("");
					department.setText("");
					dateofjoin.setText("");
					dateofbirth.setText("");
					skill.setText("");
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
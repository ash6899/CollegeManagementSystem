import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddStudent extends JFrame implements ActionListener
{
	private JLabel cid,cname,branchs,sem,dob,phoneno,email,password;
	private JTextField id,name,branch,semester,dateofbirth,phone,emailid,pass;
	private JButton save,cancel,goback;
	public AddStudent()
	{
		setSize(700,500);
		setTitle("Add New Student");
		cid = new JLabel("ID");
		cname = new JLabel("Name");
		branchs = new JLabel("Branch");
		dob = new JLabel("Date Of Birth");
		sem = new JLabel("Semester");
		phoneno = new JLabel("Phone No.");
		email = new JLabel("Email");
		password = new JLabel("Password");
		id = new JTextField(20);
		name = new JTextField(20);
		branch = new JTextField(20);
		dateofbirth = new JTextField(20);
		semester = new JTextField(20);
		phone = new JTextField(20);
		emailid = new JTextField(20);
		pass = new JTextField(20);
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		goback = new JButton("Go Back");
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
		password.setBounds(100,300,200,20);
		id.setBounds(300,20,200,20);
		name.setBounds(300,60,200,20);
		branch.setBounds(300,100,200,20);
		semester.setBounds(300,140,200,20);
		dateofbirth.setBounds(300,180,200,20);
		phone.setBounds(300,220,200,20);
		emailid.setBounds(300,260,200,20);
		pass.setBounds(300,300,200,20);
		save.setBounds(100,350,100,20);
		cancel.setBounds(250,350,100,20);
		goback.setBounds(400,350,100,20);
		add(goback);
		add(cid);
		add(cname);
		add(branchs);
		add(dob);
		add(sem);
		add(phoneno);
		add(email);
		add(password);
		add(id);
		add(name);
		add(branch);
		add(dateofbirth);
		add(semester);
		add(phone);
		add(emailid);
		add(pass);
		add(save);
		add(cancel);
		save.addActionListener(this);
		cancel.addActionListener(this);
		goback.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == save)
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
					String studentpass=pass.getText().trim();
					if(studentpass.equals("") || studentemail.equals("") || studentphone.equals("") || studentdob.equals("") || studentsem.equals("") || studentbranch.equals("") || studentname.equals("") || studentid.equals(""))
					{
						JOptionPane.showMessageDialog(this,"Please!! Fill All the Fields..");
					}
					else
					{
					String query="insert into studentdetail(ID,NAME,BRANCH,SEMESTER,DATEOFBIRTH,PHONENO,EMAIL,PASSWORD,ATTENDANCE1,ATTENDANCE2,ATTENDANCE3) values('"+studentid+"','"+studentname+"','"+studentbranch+"','"+studentsem+"','"+studentdob+"','"+studentphone+"','"+studentemail+"','"+studentpass+"','"+0+"','"+0+"','"+0+"')";
					long ans=stmt.executeUpdate(query);
					if(ans==0)
						JOptionPane.showMessageDialog(this,"The Record is NOT Recorded.");
					else{
						JOptionPane.showMessageDialog(this,"The Record is Successfully Recorded.");
						id.setText("");
						name.setText("");
						branch.setText("");
						semester.setText("");
						dateofbirth.setText("");
						phone.setText("");
						emailid.setText("");
						pass.setText("");
						id.requestFocus();
					}}
				}
		catch(Exception exp)
		{
			System.out.println("ERROR:"+exp);
		}
		}
		else if(e.getSource() == cancel)
		{
			this.dispose();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeAdmin obj = new WelcomeAdmin();
		}
	}
}
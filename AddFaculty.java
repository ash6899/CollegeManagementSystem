import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddFaculty extends JFrame implements ActionListener
{
	private JLabel fid,fname,dept,datejoin,dob,skills,phoneno,email,password;
	private JTextField id,name,department,dateofjoin,dateofbirth,skill,phone,emailid,pass;
	private JButton save,cancel,goback;
	public AddFaculty()
	{
		setSize(700,500);
		setTitle("Add New Faculty");
		fid = new JLabel("ID");
		fname = new JLabel("Name");
		dept = new JLabel("Department");
		datejoin = new JLabel("Date Of Joining");
		dob = new JLabel("Date Of Birth");
		skills = new JLabel("Skills");
		phoneno = new JLabel("Phone No.");
		email = new JLabel("Email");
		password = new JLabel("Password");
		id = new JTextField(20);
		name = new JTextField(20);
		department = new JTextField(20);
		dateofjoin = new JTextField(20);
		dateofbirth = new JTextField(20);
		skill = new JTextField(20);
		phone = new JTextField(20);
		emailid = new JTextField(20);
		pass = new JTextField(20);
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		goback = new JButton("Go Back");
		setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		fid.setBounds(100,20,200,20);
		fname.setBounds(100,60,200,20);
		dept.setBounds(100,100,200,20);
		datejoin.setBounds(100,140,200,20);
		dob.setBounds(100,180,200,20);
		skills.setBounds(100,220,200,20);
		phoneno.setBounds(100,260,200,20);
		email.setBounds(100,300,200,20);
		password.setBounds(100,340,200,20);
		id.setBounds(300,20,200,20);
		name.setBounds(300,60,200,20);
		department.setBounds(300,100,200,20);
		dateofjoin.setBounds(300,140,200,20);
		dateofbirth.setBounds(300,180,200,20);
		skill.setBounds(300,220,200,20);
		phone.setBounds(300,260,200,20);
		emailid.setBounds(300,300,200,20);
		pass.setBounds(300,340,200,20);
		save.setBounds(100,400,100,20);
		cancel.setBounds(250,400,100,20);
		goback.setBounds(400,400,100,20);
		add(fid);
		add(fname);
		add(dept);
		add(datejoin);
		add(dob);
		add(skills);
		add(phoneno);
		add(email);
		add(password);
		add(id);
		add(name);
		add(department);
		add(dateofjoin);
		add(dateofbirth);
		add(skill);
		add(phone);
		add(emailid);
		add(pass);
		add(save);
		add(cancel);
		add(goback);
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
			String facultyid=id.getText().trim();
			String facultyname=name.getText().trim();
			String facultydept=department.getText().trim();
			String facultydoj=dateofjoin.getText().trim();
			String facultydob=dateofbirth.getText().trim();
			String facultyskill=skill.getText().trim();
			String facultyphone=phone.getText().trim();
			String facultyemail=emailid.getText().trim();
			String facultypass=pass.getText().trim();
			if((facultyid.equals("")) || (facultyname.equals("")) || (facultydept.equals("")) || (facultydoj.equals("")) || (facultydob.equals("")) || (facultyskill.equals("")) || (facultyphone.equals("")) || (facultyemail.equals("")) || (facultypass.equals("")) )
			{
				JOptionPane.showMessageDialog(this,"Please!! Fill all the Fields");
			}
			else
			{
				String query="insert into facultydetail(ID,NAME,DEPARTMENT,DATEOFJOIN,DATEOFBIRTH,SKILLS,PHONENO,EMAIL,PASSWORD) values('"+facultyid+"','"+facultyname+"','"+facultydept+"','"+facultydoj+"','"+facultydob+"','"+facultyskill+"','"+facultyphone+"','"+facultyemail+"','"+facultypass+"')";
			long ans=stmt.executeUpdate(query);
			if(ans==0)
				JOptionPane.showMessageDialog(this,"The Record is NOT Recorded.");
			else{
				JOptionPane.showMessageDialog(this,"The Record is Successfully Recorded.");
				id.setText("");
				name.setText("");
				department.setText("");
				dateofjoin.setText("");
				dateofbirth.setText("");
				skill.setText("");
				phone.setText("");
				emailid.setText("");
				pass.setText("");
				id.requestFocus();
			}	
			}
			
		}
		catch(Exception exp)
		{
			System.out.println("ERROR:"+exp);
		}
		}
		else if(e.getSource() == cancel)
		{
			id.setText("");
				name.setText("");
				department.setText("");
				dateofjoin.setText("");
				dateofbirth.setText("");
				skill.setText("");
				phone.setText("");
				emailid.setText("");
				pass.setText("");
				id.requestFocus();
		}
		else if(e.getSource() == goback)
		{	dispose();
			WelcomeAdmin obj = new WelcomeAdmin();
		}
	}
}
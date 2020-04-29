import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomeFaculty extends JFrame implements ActionListener
{
	private JMenuBar facultymb;
	private JMenu student,marks,attendance,changepass,logout;
	private JMenuItem viewstudent,addstudent;
	private JMenuItem viewmarks,addmarks,viewattendance,addattendance,changepassword,log;
	private JLabel heading;
	public WelcomeFaculty()
	{
		setSize(700,500);
		setTitle("Welcome Faculty");
		facultymb = new JMenuBar();
		student = new JMenu("Student");
		marks = new JMenu("Marks");
		attendance = new JMenu("Attendance");
		changepass = new JMenu("Change Pass");
		logout = new JMenu("LogOut");
		addstudent = new JMenuItem("Add");
		viewstudent = new JMenuItem("View");
		viewmarks = new JMenuItem("View");
		addmarks = new JMenuItem("Add");
		viewattendance = new JMenuItem("View");
		addattendance = new JMenuItem("Add");
		changepassword = new JMenuItem("Change Password");
		log = new JMenuItem("LogOut");
		heading = new JLabel("HELLO FACULTY");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		heading.setBounds(200,100,400,50);
		add(heading);
		heading.setFont(new Font("Courier", Font.BOLD,27));
		student.add(addstudent);
		student.add(viewstudent);
		marks.add(addmarks);
		marks.add(viewmarks);
		attendance.add(addattendance);
		attendance.add(viewattendance);
		changepass.add(changepassword);
		logout.add(log);
		facultymb.add(student);
		facultymb.add(marks);
		facultymb.add(attendance);
		facultymb.add(changepass);
		facultymb.add(logout);
		setJMenuBar(facultymb);
		addstudent.addActionListener(this);
		viewstudent.addActionListener(this);
		addmarks.addActionListener(this);
		viewmarks.addActionListener(this);
		addattendance.addActionListener(this);
		viewattendance.addActionListener(this);
		changepassword.addActionListener(this);
		log.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addstudent)
		{	dispose();
			AddStudentf obj = new AddStudentf();
		}
		else if(e.getSource()==viewstudent)
		{	dispose();
			ViewStudentf obj = new ViewStudentf();
		}
		else if(e.getSource()==viewmarks)
		{	dispose();
			ViewMarksf obj = new ViewMarksf();
		}
		else if(e.getSource()==addmarks)
		{	dispose();
			AddMarks obj = new AddMarks();
		}
		else if(e.getSource()==viewattendance)
		{	dispose();
			ViewAttendancef obj = new ViewAttendancef();
		}
		else if(e.getSource()==addattendance)
		{	dispose();
			AddAttendance obj = new AddAttendance();
		}
		else if(e.getSource()==changepassword)
		{	dispose();
			ChangePasswordFaculty obj = new ChangePasswordFaculty();
		}
		else if(e.getSource()==log)
		{
			System.exit(1);
		}
	}
}
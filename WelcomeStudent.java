import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomeStudent extends JFrame implements ActionListener
{
	private JMenuBar studentmb;
	private JMenu marks,attendance,changepass,logout;
	private JMenuItem viewmarks,viewattendance,changepassword,log;
	private String collegeid;
	private JLabel heading;
	public WelcomeStudent(String a)
	{
		setSize(700,500);
		setTitle("Welcome Student");
		studentmb = new JMenuBar();
		marks = new JMenu("Marks");
		attendance = new JMenu("Attendance");
		changepass = new JMenu("Change Pass");
		logout = new JMenu("LogOut");
		viewmarks = new JMenuItem("View");
		viewattendance = new JMenuItem("View");
		changepassword = new JMenuItem("Change Password");
		log = new JMenuItem("LogOut");
		marks.add(viewmarks);
		attendance.add(viewattendance);
		changepass.add(changepassword);
		logout.add(log);
		studentmb.add(marks);
		studentmb.add(attendance);
		studentmb.add(changepass);
		studentmb.add(logout);
		setJMenuBar(studentmb);
		viewmarks.addActionListener(this);
		viewattendance.addActionListener(this);
		changepassword.addActionListener(this);
		log.addActionListener(this);
		collegeid = a;
		heading = new JLabel("HELLO STUDENT");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		heading.setBounds(200,100,400,50);
		add(heading);
		heading.setFont(new Font("Courier", Font.BOLD,27));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==viewmarks)
		{	dispose();
			ViewStudentMarks obj = new ViewStudentMarks(collegeid);
		}
		else if(e.getSource()==viewattendance)
		{	dispose();
			ViewStudentAttendance obj = new ViewStudentAttendance(collegeid);
		}
		else if(e.getSource()==changepassword)
		{	dispose();
			ChangePasswordStudent obj = new ChangePasswordStudent(collegeid);
		}
		else if(e.getSource()==log)
		{
			System.exit(1);
		}
	}
}
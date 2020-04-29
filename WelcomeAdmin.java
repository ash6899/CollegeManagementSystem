import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomeAdmin extends JFrame implements ActionListener
{
	private JMenuBar adminmb;
	private JMenu faculty,student,marks,attendance,changepass,logout;
	private JMenuItem addfaculty,viewfaculty,updatefaculty,deletefaculty,viewstudent,updatestudent,addstudent,deletestudent;
	private JMenuItem viewmarks,updatemarks,viewattendance,updateattendance,changepassword,log;
	private JLabel heading;
	public WelcomeAdmin()
	{
		setSize(700,500);
		setTitle("Welcome Admin");
		adminmb = new JMenuBar();
		faculty = new JMenu("Faculty");
		student = new JMenu("Student");
		marks = new JMenu("Marks");
		attendance = new JMenu("Attendance");
		changepass = new JMenu("Change Pass");
		logout = new JMenu("LogOut");
		addfaculty = new JMenuItem("Add");
		viewfaculty = new JMenuItem("View");
		updatefaculty = new JMenuItem("Update");
		deletefaculty = new JMenuItem("Delete");
		addstudent = new JMenuItem("Add");
		viewstudent = new JMenuItem("View");
		updatestudent = new JMenuItem("Update");
		deletestudent = new JMenuItem("Delete");
		viewmarks = new JMenuItem("View");
		updatemarks = new JMenuItem("Update");
		viewattendance = new JMenuItem("View");
		updateattendance = new JMenuItem("Update");
		changepassword = new JMenuItem("Change Password");
		log = new JMenuItem("LogOut");
		heading = new JLabel("HELLO ADMIN");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(null);
		heading.setBounds(200,100,400,50);
		add(heading);
		heading.setFont(new Font("Courier", Font.BOLD,27));
		faculty.add(addfaculty);
		faculty.add(viewfaculty);
		faculty.add(updatefaculty);
		faculty.add(deletefaculty);
		student.add(addstudent);
		student.add(viewstudent);
		student.add(updatestudent);
		student.add(deletestudent);
		marks.add(viewmarks);
		marks.add(updatemarks);
		attendance.add(viewattendance);
		attendance.add(updateattendance);
		changepass.add(changepassword);
		logout.add(log);
		adminmb.add(faculty);
		adminmb.add(student);
		adminmb.add(marks);
		adminmb.add(attendance);
		adminmb.add(changepass);
		adminmb.add(logout);
		setJMenuBar(adminmb);
		addfaculty.addActionListener(this);
		viewfaculty.addActionListener(this);
		updatefaculty.addActionListener(this);
		deletefaculty.addActionListener(this);
		addstudent.addActionListener(this);
		viewstudent.addActionListener(this);
		updatestudent.addActionListener(this);
		deletestudent.addActionListener(this);
		viewmarks.addActionListener(this);
		updatemarks.addActionListener(this);
		viewattendance.addActionListener(this);
		updateattendance.addActionListener(this);
		changepassword.addActionListener(this);
		log.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addfaculty)
		{	dispose();
			AddFaculty obj = new AddFaculty();
		}
		else if(e.getSource()==viewfaculty)
		{	dispose();
			ViewFaculty obj = new ViewFaculty();
		}
		else if(e.getSource()==updatefaculty)
		{	dispose();
			UpdateFaculty obj = new UpdateFaculty();
		}
		else if(e.getSource()==deletefaculty)
		{	dispose();
			DeleteFaculty obj = new DeleteFaculty();
		}
		else if(e.getSource()==addstudent)
		{	dispose();
			AddStudent obj = new AddStudent();
		}
		else if(e.getSource()==viewstudent)
		{	dispose();
			ViewStudent obj = new ViewStudent();
		}
		else if(e.getSource()==updatestudent)
		{	dispose();
			UpdateStudent obj = new UpdateStudent();
		}
		else if(e.getSource()==deletestudent)
		{	dispose();
			DeleteStudent obj = new DeleteStudent();
		}
		else if(e.getSource()==viewmarks)
		{	dispose();
			ViewMarks obj = new ViewMarks();
		}
		else if(e.getSource()==updatemarks)
		{	dispose();
			UpdateMarks obj = new UpdateMarks();
		}
		else if(e.getSource()==viewattendance)
		{	dispose();
			ViewAttendance obj = new ViewAttendance();
		}
		else if(e.getSource()==updateattendance)
		{	dispose();
			UpdateAttendance obj = new UpdateAttendance();
		}
		else if(e.getSource()==changepassword)
		{	dispose();
			ChangePasswordAdmin obj = new ChangePasswordAdmin();
		}
		else if(e.getSource()==log)
		{
			System.exit(1);
		}
	}
}
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
class Splash extends JFrame implements Runnable
{   Thread t;
    public Splash()
    {   
        setSize(700,500);
        setVisible(true);
        t.start();
    }
    public void run()
    {
        try
        {
            
            setTitle("College Management System");
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            setContentPane(new JLabel(new ImageIcon("cms.jpg")));
            t.sleep(2000);
        }
        catch(Exception exp)
        {
            System.out.println(exp);
        }
        // try
        // {
        //     Login obj = new Login();
        // }
        // catch(Exception exp)
        // {
        //     System.out.println(exp);
        // }
        
    }
}
class Demo
{
    public static void main(String[] args) {
        Splash ob = new Splash();
        Login obj = new Login();
    }
}
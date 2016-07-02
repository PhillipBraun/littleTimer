import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Date;
import java.util.Calendar;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.06.2016
  * @author 
  */

public class test extends JFrame {
  // Anfang Attribute
  public JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  private JTextField jTextField1 = new JTextField();
  // Ende Attribute
  
  
  
  
  public test(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 171;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(8, 8, 270, 52);
    jLabel1.setText(labelText);
    cp.add(jLabel1);
    jButton1.setBounds(192, 88, 75, 25);
    jButton1.setText("jButton1");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextField1.setBounds(16, 88, 150, 20);
    cp.add(jTextField1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public test
  
  public static String labelText = "";
  
  // Anfang Methoden
  
  public static void main(String[] args) 
  {
    new test("test");
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) 
  {  
    setText();
  }
  
  public void setText()
  {
    Countdown countDown1;
    countDown1 = new Countdown(jTextField1.getText());
    for (int i = 0; i < 1000; i++) 
    {
      jLabel1.setText(countDown1.getCountdown());
      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    } 
    
  } 
  // Ende Methoden
} // end of class test

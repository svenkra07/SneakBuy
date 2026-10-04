import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Gibt es nur bei korrektem Passwort Zugang zur GuiBesitzer.
 *
 * @version 1.0 vom 27.04.2026
 * @author
 */

public class owner_login extends JFrame {
  // start attributes
  private JButton bLogin = new JButton();
  private JPasswordField jPasswordField1 = new JPasswordField();
  private JButton bZurueck = new JButton();
  // end attributes
  
  public owner_login() { 
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 349; 
    int frameHeight = 156;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Einloggen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(new Color(0xC0C0C0));
    // start components
    
    bLogin.setBounds(168, 48, 81, 33);
    bLogin.setText("Login");
    bLogin.setMargin(new Insets(2, 2, 2, 2));
    bLogin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLogin_ActionPerformed(evt);
      }
    });
    bLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    bLogin.setForeground(new Color(0x800000));
    cp.add(bLogin);
    jPasswordField1.setBounds(40, 48, 113, 33);
    jPasswordField1.setText("");
    jPasswordField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jPasswordField1);
    bZurueck.setBounds(280, 8, 49, 17);
    bZurueck.setText("Zurück");
    bZurueck.setMargin(new Insets(2, 2, 2, 2));
    bZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck_ActionPerformed(evt);
      }
    });
    bZurueck.setForeground(new Color(0x800000));
    bZurueck.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
    cp.add(bZurueck);
    // end components
    
    setVisible(true);
  }
  
  // start methods
  
  public static void main(String[] args) {
    new owner_login(); //Erstellt ein neues owner_login Fenster und startet damit das Programm
  }
  
  //Login-Button: Passwort prüfen.
  public void bLogin_ActionPerformed(ActionEvent evt) {
    //Char-Array-> String umwandeln
    String eingabe = new String(jPasswordField1.getPassword());
    
    if (eingabe.equals("1234")) {
      JOptionPane.showMessageDialog(this, "Hallo Sven!");
      GuiBesitzer besitzer_gui = new GuiBesitzer();
      besitzer_gui.setVisible(true);
      this.dispose();
    } else {
      JOptionPane.showMessageDialog(this, "Falsches Passwort!");
    }
  }

  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    GuiKundeLogin kunde_login_gui=new GuiKundeLogin();
    kunde_login_gui.setVisible(true);
    this.dispose();
  } // end of bZurueck_ActionPerformed

  // end methods
} // end of class owner_login
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.font.TextAttribute;

/**
 *
 * @version 1.0 vom 14.04.2026
 * @author
 */

public class GuiKundeLogin extends JFrame {
  // start attributes
  private String eingeloggterKundeID = null;
  private JLabel lID = new JLabel();
  private JLabel lName = new JLabel();
  private JLabel lVorname = new JLabel();
  private JLabel lSchuhgroesse = new JLabel();
  private JLabel lRegistrieren = new JLabel();
  private JNumberField jNumberField2 = new JNumberField();
  private JTextField jTextField4 = new JTextField();
  private JTextField jTextField5 = new JTextField();
  private JNumberField jNumberField3 = new JNumberField();
  private JLabel lBenutzername1 = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JTextField jTextField7 = new JTextField();
  private JButton bHinzufuegen = new JButton();
  private JLabel lLogin = new JLabel();
  private JLabel lBenutzername2 = new JLabel();
  private JLabel lPasswort1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton bLogin = new JButton();
  private JPasswordField jPasswordField1 = new JPasswordField();
  private JPasswordField jPasswordField2 = new JPasswordField();
  private JButton bOwner1 = new JButton();
  private JSeparator jSeparator1 = new JSeparator();
  // end attributes
  
  public GuiKundeLogin() { 
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 619; 
    int frameHeight = 473;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Anmelden");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(new Color(0xC0C0C0));
    // start components
    
    lID.setBounds(48, 56, 56, 48);
    lID.setText("-ID-");
    lID.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lID);
    lName.setBounds(48, 104, 56, 48);
    lVorname.setBounds(48, 160, 63, 40);
    lSchuhgroesse.setBounds(48, 208, 79, 48);
    lRegistrieren.setBounds(136, 8, 137, 33);
    jNumberField2.setBounds(144, 64, 89, 32);
    jTextField4.setBounds(144, 112, 89, 33);
    jTextField5.setBounds(144, 168, 89, 33);
    jNumberField3.setBounds(144, 216, 89, 32);
    lBenutzername1.setBounds(40, 264, 93, 33);
    lPasswort.setBounds(48, 312, 89, 41);
    jTextField7.setBounds(144, 264, 89, 33);
    bHinzufuegen.setBounds(136, 384, 104, 41);
    lLogin.setBounds(440, 120, 137, 33);
    lBenutzername2.setBounds(312, 176, 93, 33);
    lPasswort1.setBounds(312, 224, 89, 41);
    jTextField1.setBounds(424, 176, 89, 33);
    bLogin.setBounds(416, 272, 105, 41);
    lName.setText("-Name-");
    lName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lName);
    lVorname.setText("-Vorname-");
    lVorname.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lVorname);
    lSchuhgroesse.setText("-Schuhgröße-");
    lSchuhgroesse.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lSchuhgroesse);
    lRegistrieren.setText("-Registrieren-");
    lRegistrieren.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    cp.add(lRegistrieren);
    jNumberField2.setFont(new Font("Dialog", Font.PLAIN, 11));
    jNumberField2.setText("Nicht ausfüllbar");
    cp.add(jNumberField2);
    jTextField4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField4);
    jTextField5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField5);
    jNumberField3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField3);
    lBenutzername1.setText("-Benutzername-");
    lBenutzername1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lBenutzername1);
    lPasswort.setText("-Passwort-");
    lPasswort.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lPasswort);
    jTextField7.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField7);
    bHinzufuegen.setText("Hinzufügen");
    bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bHinzufuegen_ActionPerformed(evt);
      }
    });
    bHinzufuegen.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bHinzufuegen.setForeground(new Color(0x800000));
    bHinzufuegen.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(bHinzufuegen);
    lLogin.setText("-Login-");
    lLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    cp.add(lLogin);
    lBenutzername2.setText("-Benutzername-");
    lBenutzername2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lBenutzername2);
    lPasswort1.setText("-Passwort-");
    lPasswort1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lPasswort1);
    jTextField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField1);
    bLogin.setText("Login");
    bLogin.setMargin(new Insets(2, 2, 2, 2));
    bLogin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLogin_ActionPerformed(evt);
      }
    });
    bLogin.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bLogin.setForeground(new Color(0x800000));
    bLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(bLogin);
    jPasswordField1.setBounds(424, 224, 89, 33);
    jPasswordField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jPasswordField1);
    jPasswordField2.setBounds(144, 320, 89, 33);
    jPasswordField2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jPasswordField2);
    bOwner1.setBounds(512, 8, 81, 33);
    bOwner1.setText("-Owner-");
    bOwner1.setMargin(new Insets(2, 2, 2, 2));
    bOwner1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bOwner1_ActionPerformed(evt);
      }
    });
    bOwner1.setForeground(new Color(0x800000));
    bOwner1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(bOwner1);
    jSeparator1.setBounds(280, 0, 8, 432);
    jSeparator1.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator1.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator1);
    // end components
    jNumberField2.setEnabled(false); // * ID-Feld deaktivieren – wird automatisch vergeben
    setVisible(true);
  }
  
  // start methods
  
  public static void main(String[] args) {
    new GuiKundeLogin(); // * Startpunkt des gesamten Programms
  }
  

  //Registrieren-Button: Neuen Kunden in der DB anlegen.
  //Liest alle Felder aus und ruft Kunden_anlegen() auf.
  public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
    SneakerShop shop = new SneakerShop();
    
    String name        = jTextField4.getText();
    String vorname     = jTextField5.getText();
    int schuhgroesse   = jNumberField3.getInt();
    String benutzername = jTextField7.getText();
    String passwort    = new String(jPasswordField2.getPassword());
    
    shop.Kunden_anlegen(name, vorname, schuhgroesse, benutzername, passwort);
    JOptionPane.showMessageDialog(this, "Kunde wurde erstellt!");
  }

  
  //Login-Button: Benutzername + Passwort prüfen.
  //Bei Erfolg -> GuiKunde öffnen und KundenID übergeben.
  //Bei Misserfolg -> Fehlermeldung.
  public void bLogin_ActionPerformed(ActionEvent evt) {
    SneakerShop shop    = new SneakerShop();
    String benutzername = jTextField1.getText();
    String passwort     = new String(jPasswordField1.getPassword());
    
    if (SneakerShop.login_pruefen(benutzername, passwort)) {
      //Kunden-ID holen und an GuiKunde übergeben (wird z.B. für Warenkorb benötigt)
      String kundenID = shop.getID_Login(benutzername, passwort);
      JOptionPane.showMessageDialog(this, "Erfolgreich eingeloggt!");
      GuiKunde weiterleitung = new GuiKunde(benutzername, kundenID);
      weiterleitung.setVisible(true);
      this.dispose();
    } else {
      JOptionPane.showMessageDialog(this, "Falscher Benutzername oder Passwort!");
    }
  }

  
  //Owner-Button: Zum Besitzer-Login wechseln.
  public void bOwner1_ActionPerformed(ActionEvent evt) {
    owner_login zum_owner_login = new owner_login();
    zum_owner_login.setVisible(true);
    this.dispose();
  }

  // end methods
} // end of class GuiKundeLogin
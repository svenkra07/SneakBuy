import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.font.TextAttribute;

/**
 * GuiBesitzer – Verwaltungsfenster für den Shop-Besitzer.
 * Funktionen: Kunden suchen/erstellen/ändern, Schuhe hinzufügen/nachfüllen,
 *             Lager anzeigen, Bestellungen suchen.
 *
 * @version 1.0 vom 12.03.2026
 * @author
 */
public class GuiBesitzer extends JFrame {

  // start attributes
  private JLabel      lKundensuchen   = new JLabel();
  private JButton     bSuchen1        = new JButton();
  private JLabel      jLabel1         = new JLabel();
  private JLabel      jLabel2         = new JLabel();
  private JLabel      jLabel3         = new JLabel();
  private JLabel      lID             = new JLabel();
  private JLabel      lName           = new JLabel();
  private JLabel      lVorname        = new JLabel();
  private JLabel      lSchuhgroesse   = new JLabel();
  private JLabel      lKundenaendern1 = new JLabel();
  private JNumberField jNumberField5  = new JNumberField();
  private JNumberField jNumberField4  = new JNumberField();
  private JTextField  jTextField2     = new JTextField();
  private JTextField  jTextField9     = new JTextField();
  private JButton     bBestaetigen    = new JButton();
  private JLabel      lKundenerstellen = new JLabel();
  private JNumberField jNumberField2  = new JNumberField();
  private JTextField  jTextField4     = new JTextField();
  private JTextField  jTextField5     = new JTextField();
  private JNumberField jNumberField3  = new JNumberField();
  private JLabel      lBenutzername1  = new JLabel();
  private JTextField  jTextField7     = new JTextField();
  private JButton     bHinzufuegen    = new JButton();
  private JLabel      lSchuhehinzufuegen = new JLabel();
  private JLabel      lID1            = new JLabel();
  private JLabel      lModell         = new JLabel();
  private JLabel      lSchuhgroessevon = new JLabel();
  private JLabel      lSchuhgroessebis = new JLabel();
  private JLabel      lFarbe          = new JLabel();
  private JLabel      lPreis          = new JLabel();
  private JLabel      lBestand        = new JLabel();
  private JNumberField jNumberField6  = new JNumberField();
  private JTextField  jTextField3     = new JTextField();
  private JNumberField jNumberField7  = new JNumberField();
  private JNumberField jNumberField10 = new JNumberField();
  private JTextField  jTextField6     = new JTextField();
  private JNumberField jNumberField8  = new JNumberField();
  private JNumberField jNumberField9  = new JNumberField();
  private JButton     bHinzufuegen1   = new JButton();
  private JLabel      jLabel4         = new JLabel();
  private JTextField  jTextField11    = new JTextField();
  private JTextField  jTextField1     = new JTextField();
  private JLabel      lBestellnummer  = new JLabel();
  private JNumberField jNumberField1  = new JNumberField();
  private JButton     bSuchen         = new JButton();
  private JButton     babmelden       = new JButton();
  private ImageIcon   babmeldenIcon   = new ImageIcon(getClass().getResource("images/abmeldne.png"));
  private JSeparator  jSeparator1     = new JSeparator();
  private JSeparator  jSeparator2     = new JSeparator();
  private JSeparator  jSeparator3     = new JSeparator();
  private JSeparator  jSeparator4     = new JSeparator();
  private JNumberField jNumberField11 = new JNumberField();
  private JButton     bNachfuellen    = new JButton();
  private JSeparator  jSeparator5     = new JSeparator();
  private JLabel      lSchuheNachfuellen = new JLabel();
  private JSeparator  jSeparator6     = new JSeparator();
  private JLabel      lID2            = new JLabel();
  private JLabel      lBestandanschauen = new JLabel();
  private JButton     bLager          = new JButton();
  private JLabel lPasswort = new JLabel();
  private JTextField jTextField8 = new JTextField();
  private JTextField jTextField10 = new JTextField();
  private JButton bBestellungen = new JButton();
  private JSeparator jSeparator7 = new JSeparator();
  // end attributes

  public GuiBesitzer() {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1028; 
    int frameHeight = 745;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width  - getSize().width)  / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("SneakBuy - Besitzer");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(new Color(0xC0C0C0));
    setUndecorated(false);
    // start components
    lKundensuchen.setBounds(464, 16, 100, 33);
    lKundensuchen.setText("-Kunden suchen-");
    lKundensuchen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lKundensuchen);
    lID.setBounds(24, 64, 56, 48);
    lID.setText("-ID-");
    lID.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lID);
    bSuchen1.setBounds(600, 272, 96, 40);
    bSuchen1.setText("Suchen");
    bSuchen1.setMargin(new Insets(2, 2, 2, 2));
    bSuchen1.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bSuchen1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bSuchen1_ActionPerformed(evt); }
    });
    bSuchen1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    bSuchen1.setForeground(new Color(0x800000));
    cp.add(bSuchen1);
    lName.setBounds(24, 112, 56, 48);
    lName.setText("-Name-");
    lName.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lName);
    lVorname.setBounds(24, 168, 67, 40);
    lVorname.setText("-Vorname-");
    lVorname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lVorname);
    lSchuhgroesse.setBounds(24, 216, 83, 48);
    lSchuhgroesse.setText("-Schuhgröße-");
    lSchuhgroesse.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lSchuhgroesse);
    jLabel1.setBounds(464, 72, 89, 32);
    jLabel1.setText("");
    jLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jLabel1);
    jLabel3.setBounds(456, 224, 104, 32);
    jLabel3.setText("");
    jLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jLabel3);
    lKundenaendern1.setBounds(768, 16, 101, 33);
    lKundenaendern1.setText("-Kunden ändern-");
    lKundenaendern1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lKundenaendern1);
    jNumberField5.setBounds(760, 72, 96, 32);
    jNumberField5.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jNumberField5);
    jNumberField4.setBounds(760, 224, 96, 32);
    jNumberField4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jNumberField4);
    jTextField2.setBounds(760, 176, 96, 33);
    jTextField2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField2);
    jTextField9.setBounds(760, 272, 96, 33);
    jTextField9.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField9);
    bBestaetigen.setBounds(896, 312, 97, 41);
    bBestaetigen.setText("Bestätigen");
    bBestaetigen.setMargin(new Insets(2, 2, 2, 2));
    bBestaetigen.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bBestaetigen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bBestaetigen_ActionPerformed(evt); }
    });
    bBestaetigen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    bBestaetigen.setForeground(new Color(0x800000));
    cp.add(bBestaetigen);
    lKundenerstellen.setBounds(120, 16, 137, 33);
    lKundenerstellen.setText("-Kunden erstellen-");
    lKundenerstellen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lKundenerstellen);
    jNumberField2.setBounds(120, 72, 89, 32);
    jNumberField2.setText("Nicht ausfüllbar");
    jNumberField2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField2);
    jTextField5.setBounds(120, 176, 89, 33);
    jTextField5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField5);
    jNumberField3.setBounds(120, 224, 89, 32);
    jNumberField3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField3);
    lBenutzername1.setBounds(16, 272, 99, 33);
    lBenutzername1.setText("-Benutzername-");
    lBenutzername1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lBenutzername1);
    jTextField7.setBounds(120, 272, 89, 33);
    jTextField7.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField7);
    bHinzufuegen.setBounds(264, 312, 97, 41);
    bHinzufuegen.setText("Hinzufügen");
    bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bHinzufuegen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bHinzufuegen_ActionPerformed(evt); }
    });
    bHinzufuegen.setForeground(new Color(0x800000));
    bHinzufuegen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(bHinzufuegen);
    lSchuhehinzufuegen.setBounds(112, 416, 137, 33);
    lSchuhehinzufuegen.setText("Schuhe hinzufügen");
    lSchuhehinzufuegen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lSchuhehinzufuegen);
    lID1.setBounds(8, 464, 56, 48);
    lID1.setText("-ID-");
    lID1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lID1);
    jNumberField6.setBounds(112, 472, 88, 32);
    jNumberField6.setText("Nicht ausfüllbar");
    jNumberField6.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField6);
    lModell.setBounds(8, 512, 56, 48);
    lModell.setText("-Modell-");
    lModell.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lModell);
    jTextField3.setBounds(112, 520, 88, 33);
    jTextField3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField3);
    lSchuhgroessevon.setBounds(8, 568, 106, 40);
    lSchuhgroessevon.setText("-Schuhgröße von-");
    lSchuhgroessevon.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lSchuhgroessevon);
    jNumberField7.setBounds(112, 576, 88, 32);
    jNumberField7.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField7);
    lSchuhgroessebis.setBounds(8, 616, 104, 40);
    lSchuhgroessebis.setText("-Schuhgröße bis-");
    lSchuhgroessebis.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lSchuhgroessebis);
    jNumberField10.setBounds(112, 624, 89, 32);
    jNumberField10.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jNumberField10);
    lFarbe.setBounds(232, 464, 79, 48);
    lFarbe.setText("-Farbe-");
    lFarbe.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lFarbe);
    jTextField6.setBounds(336, 472, 89, 33);
    jTextField6.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField6);
    lPreis.setBounds(232, 520, 80, 32);
    lPreis.setText("-Preis-");
    lPreis.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lPreis);
    jNumberField8.setBounds(336, 520, 89, 32);
    jNumberField8.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jNumberField8);
    lBestand.setBounds(232, 560, 79, 40);
    lBestand.setText("-Bestand-");
    lBestand.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lBestand);
    jNumberField9.setBounds(336, 568, 89, 32);
    jNumberField9.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jNumberField9);
    bHinzufuegen1.setBounds(272, 616, 97, 41);
    bHinzufuegen1.setText("Hinzufügen");
    bHinzufuegen1.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen1.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bHinzufuegen1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bHinzufuegen1_ActionPerformed(evt); }
    });
    bHinzufuegen1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    bHinzufuegen1.setForeground(new Color(0x800000));
    cp.add(bHinzufuegen1);
    // * ID-Felder deaktivieren – werden von SQLite automatisch vergeben
    jNumberField2.setEnabled(false);
    jNumberField6.setEnabled(false);
    jNumberField5.setEnabled(false);
    jTextField4.setBounds(120, 120, 89, 33);
    jTextField4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField4);
    jLabel4.setBounds(456, 272, 104, 33);
    jLabel4.setText("");
    jLabel4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jLabel4);
    jTextField11.setBounds(456, 120, 105, 33);
    jTextField11.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField11);
    jTextField1.setBounds(760, 120, 96, 33);
    jTextField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField1);
    lBestellnummer.setBounds(816, 424, 137, 33);
    lBestellnummer.setText("Bestellnummer");
    lBestellnummer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lBestellnummer);
    jNumberField1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    jNumberField1.setBounds(816, 480, 72, 32);
    cp.add(jNumberField1);
    bSuchen.setBounds(904, 472, 88, 48);
    bSuchen.setText("Suchen");
    bSuchen.setMargin(new Insets(2, 2, 2, 2));
    bSuchen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { bSuchen_ActionPerformed(evt); }
    });
    bSuchen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    bSuchen.setForeground(new Color(0x800000));
    cp.add(bSuchen);
    babmelden.setBounds(896, 8, 104, 40);
    babmelden.setText("abmelden");
    babmelden.setMargin(new Insets(2, 2, 2, 2));
    babmelden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { babmelden_ActionPerformed(evt); }
    });
    babmelden.setIcon(babmeldenIcon);
    babmelden.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    babmelden.setForeground(new Color(0x800000));
    cp.add(babmelden);
    Color trennstrich = new Color(0x555555);
    jSeparator1.setBounds(392, 8, 8, 352);
    jSeparator1.setOrientation(SwingConstants.VERTICAL);
    jSeparator1.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator1.setForeground(trennstrich);
    jSeparator1.setBackground(trennstrich);
    cp.add(jSeparator1);
    jSeparator2.setBounds(720, 8, 8, 344);
    jSeparator2.setOrientation(SwingConstants.VERTICAL);
    jSeparator2.setForeground(trennstrich);
    jSeparator2.setBackground(trennstrich);
    jSeparator2.setFont(new Font("Dialog", Font.BOLD, 11));
    cp.add(jSeparator2);
    jSeparator3.setBounds(8, 384, 913, 8);
    jSeparator3.setForeground(trennstrich);
    jSeparator3.setBackground(trennstrich);
    jSeparator3.setFont(new Font("Dialog", Font.BOLD, 11));
    cp.add(jSeparator3);
    jSeparator4.setBounds(752, 400, 8, 288);
    jSeparator4.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator4.setBackground(trennstrich);
    jSeparator4.setForeground(trennstrich);
    jSeparator4.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator4);
    jNumberField11.setBounds(560, 472, 72, 32);
    jNumberField11.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField11);
    bNachfuellen.setBounds(640, 472, 77, 32);
    bNachfuellen.setText("Nachfüllen");
    bNachfuellen.setMargin(new Insets(2, 2, 2, 2));
    bNachfuellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { bNachfuellen_ActionPerformed(evt); }
    });
    bNachfuellen.setForeground(new Color(0x800000));
    bNachfuellen.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bNachfuellen.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(bNachfuellen);
    jSeparator5.setBounds(472, 400, 8, 288);
    jSeparator5.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator5.setBackground(trennstrich);
    jSeparator5.setForeground(trennstrich);
    jSeparator5.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator5);
    lSchuheNachfuellen.setBounds(552, 416, 137, 33);
    lSchuheNachfuellen.setText("Schuhe Nachfüllen");
    lSchuheNachfuellen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lSchuheNachfuellen);
    jSeparator6.setBounds(496, 544, 232, 8);
    jSeparator6.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator6.setBackground(trennstrich);
    jSeparator6.setForeground(trennstrich);
    cp.add(jSeparator6);
    lID2.setBounds(512, 464, 48, 48);
    lID2.setText("-ID-");
    lID2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lID2);
    lBestandanschauen.setBounds(560, 576, 137, 33);
    lBestandanschauen.setText("Bestand anschauen");
    lBestandanschauen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lBestandanschauen);
    bLager.setBounds(560, 624, 112, 41);
    bLager.setText("Lager");
    bLager.setMargin(new Insets(2, 2, 2, 2));
    bLager.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { bLager_ActionPerformed(evt); }
    });
    bLager.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bLager.setForeground(new Color(0x800000));
    bLager.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(bLager);
    lPasswort.setBounds(24, 320, 99, 33);
    lPasswort.setText("-Passwort-");
    lPasswort.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    cp.add(lPasswort);
    jTextField8.setBounds(120, 320, 89, 33);
    jTextField8.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    cp.add(jTextField8);
    jTextField10.setBounds(456, 176, 105, 33);
    jTextField10.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    cp.add(jTextField10);
    
    // Placeholder für jTextField11
    jTextField11.setText("Name");
    jTextField11.setForeground(Color.GRAY);
    jTextField11.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        if (jTextField11.getText().equals("Name")) {
            jTextField11.setText("");
            jTextField11.setForeground(Color.BLACK);
        }
    }
    public void focusLost(FocusEvent e) {
        if (jTextField11.getText().isEmpty()) {
            jTextField11.setText("Name");
            jTextField11.setForeground(Color.GRAY);
        }
    }
    });

    // Placeholder für jTextField10
    jTextField10.setText("Vorname");
    jTextField10.setForeground(Color.GRAY);
    jTextField10.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        if (jTextField10.getText().equals("Vorname")) {
            jTextField10.setText("");
            jTextField10.setForeground(Color.BLACK);
        }
    }
    public void focusLost(FocusEvent e) {
        if (jTextField10.getText().isEmpty()) {
            jTextField10.setText("Vorname");
            jTextField10.setForeground(Color.GRAY);
        }
    }
    });
    bBestellungen.setBounds(600, 328, 96, 40);
    bBestellungen.setText("Bestellungen");
    bBestellungen.setMargin(new Insets(2, 2, 2, 2));
    bBestellungen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBestellungen_ActionPerformed(evt);
      }
    });
    bBestellungen.setBorder(BorderFactory.createEtchedBorder(0, Color.BLACK, Color.BLACK));
    bBestellungen.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    bBestellungen.setForeground(new Color(0x800000));
    cp.add(bBestellungen);
    jSeparator7.setBounds(608, 320, 81, 8);
    jSeparator7.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator7.setBackground(Color.BLACK);
    jSeparator7.setForeground(new Color(0x333333));
    cp.add(jSeparator7);
    // end components
    setVisible(true);
  }

  public static void main(String[] args) {
    new GuiBesitzer(); //Nur zum schnellen Testen dieser Klasse
  }

  // start methods


  //Kunden-Suchen-Button: Sucht Kunden anhand des eingegebenen Namens.
  //Füllt sowohl die Anzeigefelder (jLabel) als auch die Änderungsfelder (jTextField/jNumberField).
  public void bSuchen1_ActionPerformed(ActionEvent evt) {
    SneakerShop Kunden = new SneakerShop();
    String name    = jTextField11.getText();   // Nachname
    String vorname = jTextField10.getText();  // Vorname

    jLabel1.setText(Kunden.getKunden_ID(name, vorname));
    jLabel3.setText(Kunden.getKunden_Groesse(name, vorname));
    jLabel4.setText(Kunden.getKunden_Benutzername(name, vorname));
    jNumberField5.setText(Kunden.getKunden_ID(name, vorname));
    jTextField1.setText(Kunden.getKunden_Name(name, vorname));
    jTextField2.setText(Kunden.getKunden_Vorname(name, vorname));
    jNumberField4.setText(Kunden.getKunden_Groesse(name, vorname));
    jTextField9.setText(Kunden.getKunden_Benutzername(name, vorname));
}


  //Bestätigen-Button: Geänderte Kundendaten in der DB speichern.
  //Liest alle Felder aus dem "Kunden ändern"-Bereich aus.
  public void bBestaetigen_ActionPerformed(ActionEvent evt) {
    int    id               = jNumberField5.getInt();
    String neuerName        = jTextField1.getText();
    String neuerVorname     = jTextField2.getText();
    int    neueGroesse      = jNumberField4.getInt();
    String neuerBenutzername = jTextField9.getText();
    String passwort         = SneakerShop.getKunden_Passwort(id);
    
    SneakerShop.Kunden_aendern(id, neuerName, neuerVorname, neueGroesse, neuerBenutzername, passwort);
    JOptionPane.showMessageDialog(this, "Kunde wurde geändert!");
  }


  //Hinzufügen-Button (Kunden): Neuen Kunden in der DB anlegen.
  //Passwort wird als leerer String gesetzt – der Besitzer vergibt kein Passwort.
  public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
    String name         = jTextField4.getText();
    String vorname      = jTextField5.getText();
    int    schuhgroesse = jNumberField3.getInt();
    String benutzername = jTextField7.getText();
    String passwort     = jTextField8.getText();

    SneakerShop.Kunden_anlegen(name, vorname, schuhgroesse, benutzername, passwort);
    JOptionPane.showMessageDialog(this, "Kunde wurde erstellt!");
  }


  //Hinzufügen-Button (Schuhe): Schuh in allen Größen von "von" bis "bis" anlegen.
  //Die for-Schleife legt für jede Größe einen eigenen Eintrag in der DB an.
  public void bHinzufuegen1_ActionPerformed(ActionEvent evt) {
    String modell           = jTextField3.getText();
    int    schuhgroesse_von = jNumberField7.getInt();
    int    schuhgroesse_bis = jNumberField10.getInt();
    String farbe            = jTextField6.getText();
    double preis            = jNumberField8.getDouble();
    int    bestand          = jNumberField9.getInt();

    //Für jede Größe zwischen "von" und "bis" einen Schuh anlegen
    for (int i = schuhgroesse_von; i <= schuhgroesse_bis; i++) {
      SneakerShop.Schuhe_anlegen(modell, i, farbe, preis, bestand);
    }
    JOptionPane.showMessageDialog(this, "Schuhe wurden hinzugefügt!");
  }


  //Bestellnummer-Suchen-Button: Bestellung anhand der Nummer laden und anzeigen.
  //Zeigt Kundenname, Artikel und Gesamtbetrag in einem Dialog.
  public void bSuchen_ActionPerformed(ActionEvent evt) {
    SneakerShop shop = new SneakerShop();
    String inhalt = SneakerShop.getBestellung_Besitzer(jNumberField1.getInt());
    
    if (!inhalt.isEmpty()) {
      double betrag = shop.getBestellung_Gesamtbetrag(jNumberField1.getInt());
      String anzeige = inhalt +
                       "\n──────────────────\n" +
                       "Gesamtbetrag: " + String.format("%.2f", betrag) + " €";
      JOptionPane.showMessageDialog(this, "Bestellung:\n" + anzeige);
    } else {
      JOptionPane.showMessageDialog(this, "Keine Bestellung gefunden!");
    }
  }


  //Abmelden-Button: Zurück zum Login-Fenster.
  public void babmelden_ActionPerformed(ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "Mach´s gut Sven!");
    GuiKundeLogin ZumLogin = new GuiKundeLogin();
    ZumLogin.setVisible(true);
    this.dispose(); // * Besitzer-Fenster schließen
  }

  
  //Nachfüllen-Button: Bestand eines Schuhs um 1 erhöhen.
  //Schuh wird anhand der eingegebenen ID gefunden.
  public void bNachfuellen_ActionPerformed(ActionEvent evt) {
    SneakerShop.Schuhe_nachfuellen(jNumberField11.getInt());
    JOptionPane.showMessageDialog(this, "Bestand wurde erhöht!");
  }


  //Lager-Button: Alle Schuhe mit Bestand anzeigen.
  public void bLager_ActionPerformed(ActionEvent evt) {
    String inhalt = SneakerShop.getLager();
    if (inhalt.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Lager ist leer!");
      return;
    }
    
    // Scrollbares Textfeld erstellen
    JTextArea textArea = new JTextArea(inhalt);
    textArea.setEditable(false);
    textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    textArea.setBackground(new Color(0xC0C0C0));
    textArea.setForeground(Color.BLACK);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 300));

    JOptionPane.showMessageDialog(this, scrollPane, "Lager", JOptionPane.PLAIN_MESSAGE);
  }

  //Bestellungen-Button: Alle Bestellungen des gesuchten Kunden anzeigen.
  //Nutzt die bereits eingegebenen Name/Vorname-Felder aus dem Kundensuche-Bereich.
  public void bBestellungen_ActionPerformed(ActionEvent evt) {
    SneakerShop Kunden = new SneakerShop();
    String name    = jTextField11.getText();
    String vorname = jTextField10.getText();

    String kundenID = Kunden.getKunden_ID(name, vorname);

    if (kundenID == null || kundenID.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Kunden zuerst suchen!");
      return;
    }

    String bestellungen = Kunden.getAlleBestellungenVonKunde(kundenID);
    if (!bestellungen.isEmpty()) {
      JOptionPane.showMessageDialog(this,
            "Bestellungen von " + vorname + " " + name + ":\n\n" + bestellungen,
            "Bestellübersicht", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(this, "Keine Bestellungen gefunden!");
    }
  } // end of bBestellungen_ActionPerformed

  // end methods
} // end of class GuiBesitzer
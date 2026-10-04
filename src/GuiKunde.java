import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Hashtable;
import java.awt.font.TextAttribute;

/**
 * Hauptfenster für eingeloggte Kunden.
 * Funktionen: Schuhe suchen, Warenkorb, Bestellung aufrufen, Abmelden.
 */
public class GuiKunde extends JFrame {

  // start attributes
  private String       eingeloggterKundeID   = null; //ID des eingeloggten Kunden = wird für Warenkorb und Bestellungen benötigt
  private JTextField   jTextField3           = new JTextField();
  private JButton      bsuchen               = new JButton();
  private JTextArea    jTextArea1            = new JTextArea();
  private JScrollPane  jTextArea1ScrollPane  = new JScrollPane(jTextArea1);
  private JLabel       lWarenkorb            = new JLabel();
  private JLabel       lModell1              = new JLabel();
  private JLabel       lGroesse1             = new JLabel();
  private JLabel       lFarbe1               = new JLabel();
  private JTextField   jTextField6           = new JTextField();
  private JTextField   jTextField10          = new JTextField();
  private JButton      bhinzufuegen          = new JButton();
  private JButton      bWarenkorbanzeigen    = new JButton();
  private ImageIcon    bWarenkorbanzeigenIcon = new ImageIcon(getClass().getResource("images/warenkorb.png"));
  private JButton      babmelden1            = new JButton();
  private ImageIcon    babmelden1Icon        = new ImageIcon(getClass().getResource("images/abmeldne.png"));
  private JLabel       jLabel1               = new JLabel();
  private JLabel       lSneakBuy             = new JLabel();
  private JNumberField jNumberField2         = new JNumberField();
  private JButton      bBestellNr            = new JButton();
  private JList<String>            jList1           = new JList<>();
  private DefaultListModel<String> jList1Model      = new DefaultListModel<>();
  private JScrollPane              jList1ScrollPane = new JScrollPane(jList1);
  private JScrollPane  jScrollPane1              = new JScrollPane();
  private JLabel       lModelleingebenundsuchen  = new JLabel();
  private JSeparator   jSeparator1 = new JSeparator();
  private JSeparator   jSeparator2 = new JSeparator();
  private JSeparator   jSeparator3 = new JSeparator();
  private JSeparator   jSeparator4 = new JSeparator();
  private JSeparator   jSeparator5 = new JSeparator();
  private JSeparator   jSeparator6 = new JSeparator();
  private JSeparator   jSeparator7 = new JSeparator();
  // end attributes

  //Konstruktor bekommt Benutzername (für Titel) und KundenID (für DB Zugriffe) übergeben
  public GuiKunde(String benutzername, String kundenID) {
    super();
    this.eingeloggterKundeID = kundenID;

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth  = 606; 
    int frameHeight = 461;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width  - getSize().width)  / 2;
    int y = (d.height - getSize().height) / 2;
    setTitle("Angemeldet als: " + benutzername);
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(new Color(0xC0C0C0));
    // start components

    jTextField3.setBounds(8, 136, 208, 33);
    jTextField3.setFont(new Font("Comic Sans MS", Font.BOLD, 9));
    cp.add(jTextField3);

    bsuchen.setBounds(256, 136, 89, 32);
    bsuchen.setText("suchen");
    bsuchen.setMargin(new Insets(2, 2, 2, 2));
    bsuchen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bsuchen_ActionPerformed(evt); }
    });
    bsuchen.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    bsuchen.setForeground(new Color(0x800000));
    cp.add(bsuchen);

    bWarenkorbanzeigen.setBounds(472, 184, 80, 72);
    bWarenkorbanzeigen.setText("");
    bWarenkorbanzeigen.setMargin(new Insets(2, 2, 2, 2));
    bWarenkorbanzeigen.setIcon(bWarenkorbanzeigenIcon);
    bWarenkorbanzeigen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { bWarenkorbanzeigen_ActionPerformed(evt); }
    });
    bWarenkorbanzeigen.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(bWarenkorbanzeigen);

    lSneakBuy.setBounds(248, 0, 176, 72);
    lSneakBuy.setText("SneakBuy");
    lSneakBuy.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
    cp.add(lSneakBuy);

    babmelden1.setBounds(472, 16, 104, 40);
    babmelden1.setText("abmelden");
    babmelden1.setMargin(new Insets(2, 2, 2, 2));
    babmelden1.setIcon(babmelden1Icon);
    babmelden1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) { babmelden1_ActionPerformed(evt); }
    });
    babmelden1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    babmelden1.setForeground(new Color(0x800000));
    cp.add(babmelden1);

    jNumberField2.setBounds(408, 376, 80, 33);
    jNumberField2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(jNumberField2);

    bBestellNr.setBounds(496, 376, 80, 33);
    bBestellNr.setText("Bestell Nr.");
    bBestellNr.setMargin(new Insets(2, 2, 2, 2));
    bBestellNr.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { bBestellNr_ActionPerformed(evt); }
    });
    bBestellNr.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    bBestellNr.setForeground(new Color(0x800000));
    cp.add(bBestellNr);

    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(8, 192, 240, 217);
    jList1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(jList1ScrollPane);

    jScrollPane1.setBounds(248, 192, 17, 217);
    jScrollPane1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(jScrollPane1);

    lModelleingebenundsuchen.setBounds(8, 96, 209, 41);
    lModelleingebenundsuchen.setText("Modell eingeben und suchen");
    lModelleingebenundsuchen.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
    cp.add(lModelleingebenundsuchen);

    jSeparator1.setBounds(400, 360, 192, 8);
    jSeparator1.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator1.setOrientation(SwingConstants.HORIZONTAL);
    jSeparator1.setBackground(Color.WHITE);
    cp.add(jSeparator1);
    jSeparator2.setBounds(392, 368, 8, 64);
    jSeparator2.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator2.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator2);
    jSeparator3.setBounds(456, 184, 8, 72);
    jSeparator3.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator3.setForeground(new Color(0x333333));
    jSeparator3.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator3);
    jSeparator4.setBounds(568, 184, 8, 72);
    jSeparator4.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator4.setForeground(new Color(0x333333));
    jSeparator4.setOrientation(SwingConstants.VERTICAL);
    cp.add(jSeparator4);
    jSeparator5.setBounds(464, 168, 96, 8);
    jSeparator5.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator5.setForeground(new Color(0x333333));
    cp.add(jSeparator5);
    jSeparator6.setBounds(464, 272, 96, 8);
    jSeparator6.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator6.setForeground(new Color(0x333333));
    jSeparator6.setBackground(Color.WHITE);
    cp.add(jSeparator6);
    jSeparator7.setBounds(240, 56, 144, 17);
    jSeparator7.setFont(new Font("Dialog", Font.BOLD, 11));
    jSeparator7.setBackground(new Color(0x808000));
    cp.add(jSeparator7);
    // end components

    setVisible(true);

    //Doppelklick auf einen Listeneintrag -> Schuh in den Warenkorb legen
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
          jList1_DoubleClicked();
        }
      }
    });
  }


  // Doppelklick: Ausgewählten Schuh aus der Liste direkt in den Warenkorb legen.  °
  public void jList1_DoubleClicked() {
    String ausgewaehlt = jList1.getSelectedValue();
    if (ausgewaehlt == null) return;

    String[] teile = ausgewaehlt.split(" \\| ");//splittet Modell/Farbe/Größe
    SneakerShop shop = new SneakerShop();
    boolean erfolg = SneakerShop.Warenkorb_hinzufuegen(
    eingeloggterKundeID,
    shop.getSchuhe_ID(
        teile[0],                                       // Modell
        Integer.parseInt(teile[2].replace("Gr. ", "")), // Größe
        teile[1]));                                     // Farbe
    

    if (erfolg) {
        JOptionPane.showMessageDialog(this, teile[0] + " wurde zum Warenkorb hinzugefügt!");
    } else {
        JOptionPane.showMessageDialog(this, teile[0] + " ist leider ausverkauft!");
    }
    // Liste neu laden
    bsuchen_ActionPerformed(null);
  }


  public static void main(String[] args) {
    new GuiKunde("platzhalter", "0");//Testen
  }


  //Suchen-Button: Schuhe nach Modellname in der DB suchen.
  //Ergebnis wird zeilenweise in die Liste geladen.
  public void bsuchen_ActionPerformed(ActionEvent evt) {
    SneakerShop shop = new SneakerShop();
    String ergebnis = shop.getSchuhe_ByModellSuche(jTextField3.getText());
    jList1Model.clear();
    for (String zeile : ergebnis.split("\n")) {
      if (!zeile.isEmpty()) jList1Model.addElement(zeile);                      //Jede nicht-leere Zeile als einzelnen Eintrag in die Liste laden
    }
  }

  
  //Warenkorb-Button: Inhalt + Gesamtbetrag anzeigen.
  //Fragt ob der Kunde alles kaufen möchte.                                          
  //Bei Ja: Bestellung speichern, Bestand reduzieren, Warenkorb leeren
  //Bei Nein: Fragen, ob man Warenkorb leeren möchte 
  public void bWarenkorbanzeigen_ActionPerformed(ActionEvent evt) {
    SneakerShop shop = new SneakerShop();
    
    if (eingeloggterKundeID == null) {
      JOptionPane.showMessageDialog(this, "Bitte erst einloggen!");
      return;
    }
    
    String inhalt = shop.getWarenkorb(eingeloggterKundeID);
    if (inhalt.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Dein Warenkorb ist leer!");
      return;
    }
    
    double betrag = shop.getWarenkorb_Gesamtbetrag(eingeloggterKundeID);
    String anzeige = "Dein Warenkorb:\n" + inhalt +
                     "\n──────────────────\n" +
                     "Gesamtbetrag: " + String.format("%.2f", betrag) + " €" +                           
                     "\n\nAlles kaufen?";
    
    int antwort = JOptionPane.showConfirmDialog(this, anzeige, "Warenkorb", JOptionPane.YES_NO_OPTION);
    
    if (antwort == JOptionPane.YES_OPTION) {
      // Erst Bestand prüfen und reduzieren, nur bei Erfolg wird die Bestellung gespeichert
      if (shop.Schuhe_kaufen(eingeloggterKundeID)) {
        int nr = shop.Bestellung_speichern(eingeloggterKundeID);
        shop.Warenkorb_leeren(eingeloggterKundeID);
        JOptionPane.showMessageDialog(this, "Kauf erfolgreich!\nDeine Bestellnummer: " + nr);
      } else {
        JOptionPane.showMessageDialog(this, "Leider ist nicht mehr genug im Lager. Bitte Warenkorb prüfen!");
      }
      // Liste neu laden, damit ausverkaufte Schuhe verschwinden
      bsuchen_ActionPerformed(null);
    } else {
      // Wenn nicht gekauft: fragen ob Warenkorb geleert werden soll
      int leeren = JOptionPane.showConfirmDialog(this, "Warenkorb leeren?", "Warenkorb", JOptionPane.YES_NO_OPTION);
      if (leeren == JOptionPane.YES_OPTION) {
        shop.Warenkorb_leeren(eingeloggterKundeID);
        JOptionPane.showMessageDialog(this, "Warenkorb wurde geleert!");
      }
    }
  }

  
  //Abmelden-Button: Zurück zum Login-Fenster.
  public void babmelden1_ActionPerformed(ActionEvent evt) {
    new GuiKundeLogin();
    this.dispose();
  }

  
  //Bestellnummer-Button: Bestellung anhand der eingegebenen Nummer anzeigen.
  //Öffnet GuiBestellung mit Inhalt + Gesamtbetrag.
  public void bBestellNr_ActionPerformed(ActionEvent evt) {
    SneakerShop shop = new SneakerShop();
    String inhalt = shop.getBestellung_Kunde(jNumberField2.getInt(), eingeloggterKundeID);
    if (!inhalt.isEmpty()) {
      double betrag = shop.getBestellung_Gesamtbetrag(jNumberField2.getInt());
      String anzeige = inhalt +
                       "\n──────────────────\n" +
                       "Gesamtbetrag: " + String.format("%.2f", betrag) + " €";             
      JOptionPane.showMessageDialog(this, "Bestellung gefunden!");
      
      GuiBestellung bestellung_gui = new GuiBestellung(anzeige, jNumberField2.getInt());
      bestellung_gui.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(this, "Keine Bestellung gefunden!");
    }
  }

  // end methods
} // end of class GuiKunde
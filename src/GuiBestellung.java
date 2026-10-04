import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Zeigt eine einzelne Bestellung in einem separaten Fenster an.
 * Wird aus GuiKunde und GuiBesitzer geöffnet.
 *
 * @version 1.0 vom 29.04.2026
 * @author
 */
public class GuiBestellung extends JFrame {

  // start attributes
  private JTextArea   jTextArea1            = new JTextArea();
  private JScrollPane jTextArea1ScrollPane  = new JScrollPane(jTextArea1);
  // end attributes

 
  public GuiBestellung(String inhalt, int bestellnummer) {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 294; 
    int frameHeight = 408;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width  - getSize().width)  / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Bestellnr. " + bestellnummer);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    cp.setBackground(new Color(0x800000));

    jTextArea1.setText(inhalt); //Bestelltext (Artikel + Gesamtbetrag) anzeigen
    jTextArea1.setEditable(false); //Nur lesen
    jTextArea1ScrollPane.setBounds(8, 8, 264, 352);
    jTextArea1.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextArea1ScrollPane);
    // end components

    setVisible(true);
  }

  // start methods

  public static void main(String[] args) {
    new GuiBestellung("test", 0); //Testen
  }

  // end methods
} // end of class GuiBestellung
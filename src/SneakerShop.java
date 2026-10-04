import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.*;
//Jeder Kunde bekommt eine eindeutige ID, welche mit allen Tabellen (außer Schuhe) verbunden ist -> Zentraler Schlüssel
//Genau das ist so wichtig, da jeder Kunde seinen eigene Bereich hat und nichts vermischt wird
//Passwörter werden NIE im Klartext gespeichert

public class SneakerShop {
  // start attributes
  // end attributes

  SneakerShop() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      System.out.println("Treiber nicht gefunden");
    }
    try {
      Connection con = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement state = con.createStatement();
      state.executeUpdate("CREATE TABLE IF NOT EXISTS Kunden(IDK INTEGER PRIMARY KEY, Name text, Vorname text, Schuhgroesse int, Benutzername text, Passwort text)");
      state.executeUpdate("CREATE TABLE IF NOT EXISTS Schuhe(IDS INTEGER PRIMARY KEY, Modell text, Groesse int, Farbe text, Preis double, Bestand int)");
      state.executeUpdate("CREATE TABLE IF NOT EXISTS Warenkorb(IDW INTEGER PRIMARY KEY, IDK int, IDS int)");
      state.executeUpdate("CREATE TABLE IF NOT EXISTS Bestellungen(IDB INTEGER PRIMARY KEY, Bestellnummer int, IDK int, IDS int)");
      con.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  // --- Kunden: set ---

  // Neuen Kunden in der Datenbank speichern
  // Das Passwort wird vor dem Speichern gehasht (nie im Klartext speichern!)
  // start methods
  static void Kunden_anlegen(String name, String vorname, int Schuhgroesse, String benutzername, String passwort) {
    String gehasht = hashPasswort(passwort);
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement stait = cnf.prepareStatement("INSERT INTO Kunden VALUES(null,?,?,?,?,?)");
      stait.setString(1, name);
      stait.setString(2, vorname);
      stait.setInt(3, Schuhgroesse);
      stait.setString(4, benutzername);
      stait.setString(5, gehasht);
      stait.executeUpdate();
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  // Kundendaten anhand der ID in der DB aktualisieren
  static void Kunden_aendern(int id, String neuerName, String neuerVorname, int neueGroesse, String neuerBenutzername, String neuesPasswort) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement stait = cnf.prepareStatement(
          "UPDATE Kunden SET Name=?, Vorname=?, Schuhgroesse=?, Benutzername=?, Passwort=? WHERE IDK=?"
      );
      stait.setString(1, neuerName);
      stait.setString(2, neuerVorname);
      stait.setInt(3, neueGroesse);
      stait.setString(4, neuerBenutzername);
      stait.setString(5, neuesPasswort);
      stait.setInt(6, id);
      stait.executeUpdate();
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }


  // --- Kunden: get ---

  // Gibt die ID des Kunden zurück
  String getKunden_ID(String name, String vorname) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Name = ? AND Vorname = ?");
      s.setString(1, name);
      s.setString(2, vorname);
      ResultSet rs = s.executeQuery();
      while (rs.next()) { Inhalt = rs.getString("IDK"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt den Nachnamen des Kunden zurück
  String getKunden_Name(String name, String vorname) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Name = ? AND Vorname = ?");
      s.setString(1, name);
      s.setString(2, vorname);
      ResultSet rs = s.executeQuery();
      while (rs.next()) { Inhalt = rs.getString("Name"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt den Vornamen des Kunden zurück
  String getKunden_Vorname(String name, String vorname) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Name = ? AND Vorname = ?");
      s.setString(1, name);
      s.setString(2, vorname);
      ResultSet rs = s.executeQuery();
      while (rs.next()) { Inhalt = rs.getString("Vorname"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt die Schuhgröße des Kunden zurück
  String getKunden_Groesse(String name, String vorname) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Name = ? AND Vorname = ?");
      s.setString(1, name);
      s.setString(2, vorname);
      ResultSet rs = s.executeQuery();
      while (rs.next()) { Inhalt = rs.getString("Schuhgroesse"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt den Benutzernamen des Kunden zurück
  String getKunden_Benutzername(String name, String vorname) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Name = ? AND Vorname = ?");
      s.setString(1, name);
      s.setString(2, vorname);
      ResultSet rs = s.executeQuery();
      while (rs.next()) { Inhalt = rs.getString("Benutzername"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  //Hash
  static String hashPasswort(String passwort) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hashBytes = digest.digest(passwort.getBytes(StandardCharsets.UTF_8));
      StringBuilder hex = new StringBuilder();
      for (byte b : hashBytes) {
        String h = Integer.toHexString(0xff & b);
        if (h.length() == 1) hex.append('0');
        hex.append(h);
      }
      return hex.toString();
    } catch (Exception e) {
      return null;
    }
  }

  // Gibt die Kunden-ID zurück wenn Benutzername und Passwort passen
  static String getID_Login(String benutzername, String passwort) {
    String gehasht = hashPasswort(passwort);
    String id = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Benutzername=? AND Passwort=?");
      s.setString(1, benutzername);
      s.setString(2, gehasht);
      ResultSet rs = s.executeQuery();
      if (rs.next()) { id = rs.getString("IDK"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return id;
  }

  // Gibt das gespeicherte (gehashte) Passwort eines Kunden zurück
  static String getKunden_Passwort(int id) {
    String pw = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT Passwort FROM Kunden " +
          "WHERE IDK = " + id
      );
      if (rs.next()) { pw = rs.getString("Passwort"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return pw;
  }


  // --- Schuhe: set ---

  // Neuen Schuh in der Datenbank anlegen
  static void Schuhe_anlegen(String Modell, int groesse, String farbe, double preis, int bestand) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement stait = cnf.prepareStatement("INSERT INTO Schuhe VALUES(null,?,?,?,?,?)");
      stait.setString(1, Modell);
      stait.setInt(2, groesse);
      stait.setString(3, farbe);
      stait.setDouble(4, preis);
      stait.setInt(5, bestand);
      stait.executeUpdate();
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  // Bestand eines Schuhs um 1 erhöhen (z.B. Nachlieferung)
  static void Schuhe_nachfuellen(int id) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement stait = cnf.createStatement();
      stait.executeUpdate("UPDATE Schuhe SET Bestand = Bestand + 1 WHERE IDS = " + id);
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }


  // --- Schuhe: get ---

  // Gibt das Modell eines Schuhs anhand seiner ID zurück - Doch nicht genutzt
  String getSchuhe_Modell(int id) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe WHERE IDS = " + id);
      while (rs.next()) { Inhalt = rs.getString("Modell"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt die Größe eines Schuhs anhand seiner ID zurück - Doch nicht genutzt
  String getSchuhe_Groesse(int id) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe WHERE IDS = " + id);
      while (rs.next()) { Inhalt = rs.getString("Groesse"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt die Farbe eines Schuhs anhand seiner ID zurück - Doch nicht genutzt
  String getSchuhe_Farbe(int id) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe WHERE IDS = " + id);
      while (rs.next()) { Inhalt = rs.getString("Farbe"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt den Preis eines Schuhs anhand seiner ID zurück - Doch nicht genutzt
  String getSchuhe_Preis(int id) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe WHERE IDS = " + id);
      while (rs.next()) { Inhalt = rs.getString("Preis"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Gibt den aktuellen Bestand eines Schuhs anhand seiner ID zurück - Doch nicht genutzt
  String getSchuhe_Bestand(int id) {
    String Inhalt = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe WHERE IDS = " + id);
      while (rs.next()) { Inhalt = rs.getString("Bestand"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return Inhalt;
  }

  // Schuh-ID anhand von Modell, Größe und Farbe finden
  String getSchuhe_ID(String modell, int groesse, String farbe) {
    String id = null;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Schuhe WHERE Modell=? AND Groesse=? AND Farbe=?");
      s.setString(1, modell);
      s.setInt(2, groesse);
      s.setString(3, farbe);
      ResultSet rs = s.executeQuery();
      if (rs.next()) { id = rs.getString("IDS"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return id;
  }

  // Sucht Schuhe anhand eines Suchbegriffs (Teilwort reicht -> LIKE)
  // Gibt nur Schuhe zurück die noch auf Lager sind (Bestand > 0)
  String getSchuhe_ByModellSuche(String suche) {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Schuhe WHERE Modell LIKE ? AND Bestand > 0");
      s.setString(1, "%" + suche + "%");
      ResultSet rs = s.executeQuery();
      while (rs.next()) {
        inhalt += rs.getString("Modell")
                + " | " + rs.getString("Farbe")
                + " | Gr. " + rs.getString("Groesse")
                + " | " + String.format("%.2f", rs.getDouble("Preis")) + "€\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }

  // Gibt alle Schuhe im Lager als Text zurück
  static String getLager() {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM Schuhe");
      while (rs.next()) {
        inhalt += "ID: " + rs.getString("IDS")
                + " | " + rs.getString("Modell")
                + " | Gr. " + rs.getString("Groesse")
                + " | " + rs.getString("Farbe")
                + " | " + String.format("%.2f", rs.getDouble("Preis")) + "€"
                + " | Bestand: " + rs.getString("Bestand") + "\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }


  // --- Warenkorb: set ---

  // Schuh in den Warenkorb legen, nur wenn noch genug Bestand vorhanden
  // (Bestand minus bereits im Warenkorb) > 0
  static boolean Warenkorb_hinzufuegen(String idk, String ids) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      if (ids == null) { cnf.close(); return false; }
      PreparedStatement stait = cnf.prepareStatement("SELECT Bestand FROM Schuhe WHERE IDS = ?");
      stait.setInt(1, Integer.parseInt(ids));
      ResultSet rs1 = stait.executeQuery();
      int bestand = rs1.next() ? rs1.getInt("Bestand") : 0;
      rs1.close();
      stait = cnf.prepareStatement("SELECT COUNT(*) FROM Warenkorb WHERE IDK = ? AND IDS = ?");
      stait.setInt(1, Integer.parseInt(idk));
      stait.setInt(2, Integer.parseInt(ids));
      ResultSet rs2 = stait.executeQuery();
      rs2.next();
      int imWarenkorb = rs2.getInt(1);
      rs2.close();
      if (bestand - imWarenkorb > 0) {
        stait = cnf.prepareStatement("INSERT INTO Warenkorb VALUES(null,?,?)");
        stait.setInt(1, Integer.parseInt(idk));
        stait.setInt(2, Integer.parseInt(ids));
        stait.executeUpdate();
        cnf.close();
        return true;
      }
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return false;
  }

  // Bestand der Schuhe im Warenkorb reduzieren - pro Schuh um die Anzahl im Warenkorb
  // Läuft als Transaktion: Entweder ist von allen Schuhen genug da, oder es wird gar nichts geändert
  // Gibt true zurück, wenn der Kauf geklappt hat
  static boolean Schuhe_kaufen(String kundenID) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      cnf.setAutoCommit(false);
      PreparedStatement stait = cnf.prepareStatement(
          "SELECT Warenkorb.IDS, COUNT(*) AS Anzahl, Schuhe.Bestand FROM Warenkorb " +
          "JOIN Schuhe ON Warenkorb.IDS = Schuhe.IDS " +
          "WHERE Warenkorb.IDK = ? GROUP BY Warenkorb.IDS"
      );
      stait.setInt(1, Integer.parseInt(kundenID));
      ResultSet rs = stait.executeQuery();
      java.util.ArrayList<int[]> positionen = new java.util.ArrayList<int[]>();
      boolean genugDa = true;
      while (rs.next()) {
        int anzahl = rs.getInt("Anzahl");
        if (anzahl > rs.getInt("Bestand")) genugDa = false;
        positionen.add(new int[] { rs.getInt("IDS"), anzahl });
      }
      rs.close();
      if (!genugDa || positionen.isEmpty()) {
        cnf.rollback();
        cnf.close();
        return false;
      }
      stait = cnf.prepareStatement("UPDATE Schuhe SET Bestand = Bestand - ? WHERE IDS = ?");
      for (int[] p : positionen) {
        stait.setInt(1, p[1]);
        stait.setInt(2, p[0]);
        stait.executeUpdate();
      }
      cnf.commit();
      cnf.close();
      return true;
    } catch (SQLException e) { e.printStackTrace(); }
    return false;
  }

  // Alle Einträge des Kunden aus dem Warenkorb löschen (nach dem Kauf)
  static void Warenkorb_leeren(String kundenID) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement stait = cnf.createStatement();
      stait.executeUpdate("DELETE FROM Warenkorb WHERE IDK = " + kundenID);
      cnf.close();
    } catch (SQLException e) { e.printStackTrace(); }
  }


  // --- Warenkorb: get ---

  // Gibt alle Schuhe im Warenkorb des Kunden als Text zurück
  static String getWarenkorb(String kundenID) {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT Modell, Farbe, Groesse, COUNT(*) AS Anzahl FROM Warenkorb " +
          "JOIN Schuhe ON Warenkorb.IDS = Schuhe.IDS " +
          "WHERE Warenkorb.IDK = " + kundenID + " GROUP BY Warenkorb.IDS"
      );
      while (rs.next()) {
        inhalt += "- " + rs.getString("Modell")
                + " | " + rs.getString("Farbe")
                + " | Größe: " + rs.getString("Groesse")
                + " | Anzahl: " + rs.getString("Anzahl") + "\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }

  // Gibt den Gesamtpreis aller Schuhe im Warenkorb des Kunden zurück
  double getWarenkorb_Gesamtbetrag(String kundenID) {
    double gesamt = 0;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT SUM(Schuhe.Preis) AS Preis FROM Warenkorb " +
          "JOIN Schuhe ON Warenkorb.IDS = Schuhe.IDS " +
          "WHERE Warenkorb.IDK = " + kundenID
      );
      if (rs.next()) { gesamt = rs.getDouble("Preis"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return gesamt;
  }

  // Gibt den Gesamtpreis aller Schuhe einer bestimmten Bestellung zurück
  double getBestellung_Gesamtbetrag(int bestellnummer) {
    double gesamt = 0;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT SUM(Schuhe.Preis) AS Preis FROM Bestellungen " +
          "JOIN Schuhe ON Bestellungen.IDS = Schuhe.IDS " +
          "WHERE Bestellungen.Bestellnummer = " + bestellnummer
      );
      if (rs.next()) { gesamt = rs.getDouble("Preis"); }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return gesamt;
  }


  // --- Login ---

  // Gibt true zurück wenn Benutzername und Passwort in der DB übereinstimmen
  static boolean login_pruefen(String benutzername, String passwort) {
    String gehasht = hashPasswort(passwort);
    boolean gefunden = false;
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      PreparedStatement s = cc.prepareStatement("SELECT * FROM Kunden WHERE Benutzername=? AND Passwort=?");
      s.setString(1, benutzername);
      s.setString(2, gehasht);
      ResultSet rs = s.executeQuery();
      if (rs.next()) { gefunden = true; }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return gefunden;
  }

  // Warenkorb des Kunden als neue Bestellung speichern. Gibt die neue Bestellnummer zurück
  static int Bestellung_speichern(String kundenID) {
    try {
      Connection cnf = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement stait = cnf.createStatement();
      ResultSet rs = stait.executeQuery("SELECT MAX(Bestellnummer) FROM Bestellungen");
      int nr = 1;
      while (rs.next()) {
        if (rs.getString(1) != null) nr = rs.getInt(1) + 1;
      }
      rs.close();
      stait.executeUpdate(
          "INSERT INTO Bestellungen(Bestellnummer, IDK, IDS) " +
          "SELECT " + nr + ", IDK, IDS FROM Warenkorb WHERE IDK=" + kundenID
      );
      cnf.close();
      return nr;
    } catch (SQLException e) { e.printStackTrace(); }
    return 0;
  }

  // Gibt alle bestellten Artikel einer Bestellnummer zurück (Kundenansicht)
  // Prüft ob die Bestellung auch wirklich diesem Kunden gehört
  static String getBestellung_Kunde(int nr, String kundenID) {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT Schuhe.Modell, Schuhe.Farbe, Schuhe.Groesse, Schuhe.Preis " +
          "FROM Bestellungen, Schuhe " +
          "WHERE Bestellungen.IDS = Schuhe.IDS " +
          "AND Bestellnummer = " + nr +
          " AND Bestellungen.IDK = " + kundenID
      );
      while (rs.next()) {
        inhalt += "- " + rs.getString("Modell")
                + " | " + rs.getString("Farbe")
                + " | Gr. " + rs.getString("Groesse")
                + " | " + String.format("%.2f", rs.getDouble("Preis")) + "€\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }

  // Gibt alle bestellten Artikel einer Bestellnummer zurück (Besitzeransicht)
  // Zusätzlich wird der Name des Kunden in der ersten Zeile angezeigt
  static String getBestellung_Besitzer(int nr) {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT Kunden.Name, Kunden.Vorname, Schuhe.Modell, Schuhe.Farbe, Schuhe.Groesse, Schuhe.Preis " +
          "FROM Bestellungen, Schuhe, Kunden " +
          "WHERE Bestellungen.IDS = Schuhe.IDS " +
          "AND Bestellungen.IDK = Kunden.IDK " +
          "AND Bestellnummer=" + nr
      );
      boolean ersteZeile = true;
      while (rs.next()) {
        if (ersteZeile) {
          inhalt += rs.getString("Vorname") + " " + rs.getString("Name") + "\n";
          inhalt += "------------------------\n";
          ersteZeile = false;
        }
        inhalt += "- " + rs.getString("Modell")
                + " | " + rs.getString("Farbe")
                + " | Gr. " + rs.getString("Groesse")
                + " | " + String.format("%.2f", rs.getDouble("Preis")) + "€\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }

  // Gibt alle Bestellnummern + Gesamtbetrag eines Kunden zurück
  public String getAlleBestellungenVonKunde(String kundenID) {
    String inhalt = "";
    try {
      Connection cc = DriverManager.getConnection("jdbc:sqlite:SneakBuy.db");
      Statement s = cc.createStatement();
      ResultSet rs = s.executeQuery(
          "SELECT DISTINCT Bestellnummer FROM Bestellungen " +
          "WHERE IDK = " + kundenID + " ORDER BY Bestellnummer DESC"
      );
      while (rs.next()) {
        int nr = rs.getInt("Bestellnummer");
        double betrag = getBestellung_Gesamtbetrag(nr);
        inhalt += "Bestellung #" + nr + "  →  " + String.format("%.2f", betrag) + " €\n";
      }
      rs.close(); cc.close();
    } catch (SQLException e) { e.printStackTrace(); }
    return inhalt;
  }


  // Main
  public static void main(String[] args) {
    SneakerShop test = new SneakerShop();
  }
  // end methods
}

// Quellen: http://sql.lernenhoch2.de/lernen/sql-anfanger/update-daten-aktualisieren/ & Perplexity
// Quelle: http://www.pellatz.de/downloads/Informatikskript.pdf Seite 117
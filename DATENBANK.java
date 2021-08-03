import java.sql.*;

public class DATENBANK
{
    private static final String url = "jdbc:sqlite:Spiel (Höhle).db";

    public static Connection connect()
    {
        try
        {
            return DriverManager.getConnection(url);
        }
        catch(Throwable a)
        {
            System.err.println("fehler");
            return null;
        }
    }

    public static int NewPlayer(int ID, String Vorname, String Nachname, int Punkte,int HID)
    {
        Connection Verbindung = connect();
        try
        {
            PreparedStatement Spielereinf = Verbindung.prepareStatement("INSERT INTO Spieler (Vorname, Nachname, Punktestand,HöhlenID) VALUES (?,?,?,?)");
            //Spielereinf.setInt(1,ID);
            Spielereinf.setString(1,Vorname);
            Spielereinf.setString(2,Nachname);
            Spielereinf.setInt(3, Punkte);
            Spielereinf.setInt(4,HID);
            Spielereinf.executeUpdate();
            System.out.println("Gonna get ResultSet");
            ResultSet GK=Spielereinf.getGeneratedKeys();
            Spielereinf.close();
            System.out.println("Gonna get INT");
            int gk=GK.getInt(1);
            GK.close();
            PreparedStatement ps = Verbindung.prepareStatement("INSERT INTO Questabfrage (SpielerID, Höhle1,Höhle2,Höhle3,Höhle4,Höhle5,Höhle6,Höhle7,Höhle8,Höhle9) VALUES (?,?,?,?,?,?,?,?,?,?)"); 
            ps.setInt(1,gk);
            ps.setBoolean(2,false);
            ps.setBoolean(3,false);
            ps.setBoolean(4,false);
            ps.setBoolean(5,false);
            ps.setBoolean(6,false);
            ps.setBoolean(7,false);
            ps.setBoolean(8,false);
            ps.setBoolean(9,false);
            ps.setBoolean(10,false);
            ps.executeUpdate();
            ps.close();
            Verbindung.close();
            return gk;
        }
        catch(SQLException e)
        {
            System.out.print(e);
            return 0;
        }  
    }

    public static void UpdateHoehleJetzt(int SpielerID,int HID)
    {
        Connection con = connect();
        try
        {
            PreparedStatement Spielereinf = con.prepareStatement("UPDATE Spieler SET HöhlenID = ? WHERE SpielerID = ?");
            Spielereinf.setInt(1,HID);
            Spielereinf.setInt(2,SpielerID);
            Spielereinf.executeUpdate();
            Spielereinf.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.print("fehler");
        }  
    }

    public static void UpdatePunkte(int SpielerID,int Punkte)
    {
        Connection Verbindung = connect();
        try
        {
            PreparedStatement Spielereinf = Verbindung.prepareStatement("UPDATE Spieler SET Punktestand=? WHERE SpielerID = ?");
            Spielereinf.setInt(1,Punkte);
            Spielereinf.setInt(2,SpielerID);
            Spielereinf.executeUpdate();
            Spielereinf.close();
            Verbindung.close();
        }
        catch(SQLException e)
        {
            System.out.print("fehler");
        }  
    }

    public static PSave getSpieler(int ID)
    {
        Connection con;
        con = connect();
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM SPIELER WHERE SpielerID = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            int result1 = rs.getInt(1);
            String result2 = rs.getString(2);
            String result3 = rs.getString(3);
            int result4 = rs.getInt(4);
            int result5 = rs.getInt(5);
            rs.close();
            ps.close();
            con.close();
            return new PSave(result1,result2,result3,result4,result5);
        }
        catch(SQLException e)
        {
            System.out.println("getSpieler crashed, big oof");
            return null;
        }
    }

    public static void setHoehle(int SID, String HID,boolean Wert) //Spieler Id, Höhlen ID, TRUE/FALSE
    {
        Connection con;
        con = connect();
        try
        {
            PreparedStatement ps = con.prepareStatement("UPDATE SPIELER SET ? VALUES ? WHERE SpielerID = ?");
            ps.setInt(3, SID);
            ps.setString(1, HID);
            ps.setBoolean(2, Wert);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("setH crashed, f");

        }
    }

    public static boolean[] getH(int SID) //Spieler ID, gibt ein Array zurück
    {
        Connection con;
        con = connect();
        boolean[] result = new boolean[9];
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Questabfrage WHERE SpielerID = ?");
            ps.setInt(1, SID);
            ResultSet rs = ps.executeQuery();
            for(int i=1;i<9;i++)
            {
                result[i]=rs.getBoolean(i);
            }
            rs.close();
            ps.close();
            con.close();
            return result;
        }
        catch(SQLException e)
        {
            System.out.println("getH crashed, R.I.P.");
            return null;
        }
    }

    public static void entferneSpieler(int ID)
    {
        Connection conn;
        conn = connect();
        try
        {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Spieler WHERE SpielerID = ?");
            ps.setInt(1, ID);
            ps.execute();
            ps.close();
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.err.println("Fehler");
        }
    }      
}

import java.sql.*;
public class DATENBANKANBINDUNG
{
    private String url;

    public DATENBANKANBINDUNG()
    {
        url = "jdbc:sqlite:Spiel (Höhle).db";
    }

    public Connection connect()
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

    public void neueBesitzt(int SpielerID, String ItemID, int Anzahl)
    {
        Connection con;
        con = connect();
        try
        {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Besitzt (SpielerID, ItemID, Anzahl) VALUES (?,?,?)");
            ps.setInt(1, SpielerID);
            ps.setString(2, ItemID);
            ps.setInt(3, Anzahl);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.print("Fehler");
        }
    }

    public void updateBesitzt(int SpielerID, String ItemID, int Anzahl)
    {
        Connection con;
        con = connect();
        try
        {
            PreparedStatement ps = con.prepareStatement("UPDATE Besitzt SET ItemID = ?, Anzahl = ? WHERE SpielerID = ?");
            ps.setString(1, ItemID);
            ps.setInt(2, Anzahl);
            ps.setInt(3, SpielerID);
            ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.print("Fehler");
        }
    }

    public INVENTAR getItem(String ItemID, int SpielerID)
    {
        Connection con;
        con = connect();
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Besitzt, Inventar WHERE Besitzt.ItemID = ? AND Besitzt.SpielerID = ? AND Besitzt.ItemID = Inventar.ItemID");
            ps.setString(1, ItemID);
            ps.setInt(2, SpielerID);
            ResultSet rs = ps.executeQuery();
            int IDOUT = rs.getInt(1);
            String ItemOUT = rs.getString(2);
            int AnzOUT = rs.getInt(3);
            String BeschOUT = rs.getString(5);
            int Punkte = rs.getInt(6);
            rs.close();
            ps.close();
            con.close();
            INVENTAR inventar = new INVENTAR (IDOUT,ItemOUT,AnzOUT, BeschOUT,Punkte);
            return inventar;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }

    public INVENTAR[] getInventar(int SpielerID)
    {
        Connection con;
        con = connect();

        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Besitzt, Inventar WHERE Besitzt.SpielerID = ? AND Besitzt.ItemID = Inventar.ItemID");
            ps.setInt(1, SpielerID);
            ResultSet rs = ps.executeQuery();

            INVENTAR[] mas=new INVENTAR[1000];
rs.next();
            for(int i=0;i>=0;i++)
            {
                try
                {
                    System.out.println("Durchlauf: "+i);
                    int IDOUT = rs.getInt(1);
                    String ItemOUT = rs.getString(2);
                    int AnzOUT = rs.getInt(3);
                    String BeschOUT = rs.getString(5);
                    int Punkte = rs.getInt(6);
                    mas[i]= new INVENTAR (IDOUT,ItemOUT,AnzOUT, BeschOUT,Punkte);
                    rs.next();
                }
                catch(SQLException e)
                {
                    System.out.println("Inner Try crashed,no shit");
                    System.out.println(e);
                    break;
                }

            }
            rs.close();
            ps.close();
            con.close();
            return mas;
        }
        catch(SQLException e)
        {

            System.out.println("Ooga Booga, Error in GetInventar");
            System.out.println(e);
            return null;
        }
    }

    
}

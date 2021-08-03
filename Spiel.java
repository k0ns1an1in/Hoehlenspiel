public class Spiel
{
    private static Tastatur spiel;
    private int spieler_id;
    private static HoehelenVerwaltung hoehelenVerwaltung = new HoehelenVerwaltung();
    
    public static Tastatur getSpielUi()
    {
        return spiel;
    }
    
    public int getAktuelleHoehle()
    {
        return hoehelenVerwaltung.getAktuelleHoehele();
    }
    public boolean bewegeNach(byte richtung)
    {
        return hoehelenVerwaltung.bewegeNach(richtung);
    }
    
    public boolean checkIfPossible(byte richtung)
    {
        return hoehelenVerwaltung.checkIfPossible(richtung);
    }
        public void starteSpiel()
    {
        hoehelenVerwaltung.getHoehleAtId(0).betreten(spieler_id);
    }
    
    public void starteSpiel(int hoehlenId)
    {
        hoehelenVerwaltung.getHoehleAtId(hoehlenId).betreten(spieler_id);
    }
    
    public int anmelden(int ID)
    {
        if(DATENBANK.getSpieler(ID) == null)
        {
            return -1;
        }
        spieler_id = ID;
        
        return ID;
    }
    
    public int registrieren(int ID, String Vorname, String Nachname)
    {
        ID = DATENBANK.NewPlayer(ID, Vorname, Nachname, 0, 0);
        System.out.println("Spieler ID: " + ID);
        spieler_id = ID;
        
        return ID;
    }
}

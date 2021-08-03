public class INVENTAR
{
    public int Spieler;
    public String ItemID;
    public int Anzahl;
    public String Beschreibung;
    public int Punkte;
    
    public INVENTAR(int nSpieler,String nItemID,int nAnzahl, String nBeschreibung, int nPunkte)
    {
        Spieler=nSpieler;
        ItemID = nItemID;
        Anzahl=nAnzahl;
        Beschreibung = nBeschreibung;
        Punkte = nPunkte;
    }
}



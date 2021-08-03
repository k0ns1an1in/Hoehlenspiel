
public class Hoehle
{
    private String hoehlentext;
    private QUEST quest;
    private String[] items;
    public int hoehle_id;
    private int spieler_id;
    private Tastatur tastatur;
    
    

    public Hoehle(int hoehle_id, String hoehlentext)
    {
        this.hoehle_id = hoehle_id;
        this.hoehlentext = hoehlentext;
        hoehlentext = "";
        quest = null;
        items = null;
        spieler_id = 0;
        tastatur = Spiel.getSpielUi();
    }
    
    public boolean betreten(int spieler_id)
    {
        this.spieler_id = spieler_id;
        SpielGui.getSpielGui().printOverwrite(hoehlentext);
        DATENBANK.UpdateHoehleJetzt(spieler_id,this.hoehle_id);
        if(!DATENBANK.getH(spieler_id)[this.hoehle_id])
        {
            return false;
        }
        return starteQuest(hoehle_id, spieler_id);
    }
    
    private boolean starteQuest(int hoehle_id, int spieler_id)
    {
        return quest.starteQuest(hoehle_id, spieler_id);
    }
    
    public void verlassen()
    {
        //aufräumen bzw daten schreiben
    }
    
    public int getSpieler_id()
    {
        return spieler_id;
    }
    
    private void itemGeben()
    {
        
    }
}

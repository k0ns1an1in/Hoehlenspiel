public class HoehelenVerwaltung
{
    private int aktuelleHoehle;

    private Hoehle Hoehlen[] = new Hoehle[9];

    public HoehelenVerwaltung()
    {
        for(int i = 0; i < 9; i++)
        {
            Hoehlen[i] = new Hoehle(i, Konstanten.HOEHLENTEXT[i]);
        }
    }

    public boolean checkIfPossible(byte richtung)
    {
        int bewegung=0;
            switch(richtung)
            {
                case Konstanten.NORDEN: 
                bewegung = -3;
                
                case Konstanten.OSTEN:
                bewegung = 1;
                
                case Konstanten.SUEDEN:
                bewegung = 3;
                
                case Konstanten.WESTEN:
                bewegung = -1;
                
            }
        if((aktuelleHoehle+bewegung)<9 && (aktuelleHoehle+bewegung)>0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public boolean bewegeNach(byte richtung)
    {
        try{
            switch(richtung)
            {
                case Konstanten.NORDEN: 
                aktuelleHoehle = aktuelleHoehle - 3;
                return true;
                case Konstanten.OSTEN:
                aktuelleHoehle = aktuelleHoehle + 1;
                return true;
                case Konstanten.SUEDEN:
                aktuelleHoehle = aktuelleHoehle + 3;
                return true;
                case Konstanten.WESTEN:
                aktuelleHoehle = aktuelleHoehle - 1;
                return true;
                default: return false;
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    public int getAktuelleHoehele()
    {
        return aktuelleHoehle;
    }

    public Hoehle getHoehleAtId(int id)
    {
        try
        {       
            return Hoehlen[id];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }
}
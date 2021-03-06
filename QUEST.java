public class QUEST{
    private String[] questbeschreibung;
    private int[] questlösung;
    private String[] item;
    private int[] punkte;
    private String[][] falschLösungen;
    private String[] richtigeLösung;
    private DATENBANKANBINDUNG com;

    public QUEST(){
        questbeschreibung = new String[8];
        questlösung = new int[8];
        item = new String[8];
        punkte = new int[8];        
        falschLösungen = new String [8][3];
        richtigeLösung = new String [8];
        com = new DATENBANKANBINDUNG();
        questbeschreibung[0] =
        "Du versuchst aus der Höhle zu entkommen. Plötzlich springt ein Speerkobold hervor \n" + 
        "und versperrt den Weg.Du bist des Todes!,ruft er. Außer du löst folgendes Rätsel für mich.\nVervollständige folgende Zahlenreihe 7 14 9 18 13 26 21 ? \n"  + 
        "1: 19  2: 34  3: 42   4: 64 ";  
        questbeschreibung[1] ="Über deinem Kopf erscheint urplötzlich eine gewaltige giftige Schlange. Für dich geht es um Leben und Tod dich nun richtig zu entscheiden. Du hast 3 Möglichkeiten: 1. Du versuchst wegzurennen2. Du packst die Schlange am Hals und erlegst sie 3. Du lässt dich beisen und versuchst das Gift auszusaugen";
        questbeschreibung[2] ="Nachdem du es geschafft hast der Schlange zu entkommen, hast du nun ein neues Problem: Ein Flaschengeist taucht in der Wüste  auf und er bietet dir an, dich zu diesem Haus zu teleportieren falls du seine Frage richtig beantworten kannst: Wie viele Höcker hat ein Dromedar? 1. einen  2.zwei oder 3. ein Dromedar hat keine Höcker ";
        questbeschreibung[3] ="Du überlegst dir wie vielen Menschen das selbe Schicksal wiederfährt. Diese Frage beschäftigt dich so sehr, dass du nicht weiter gehen kannst, bevor du diese Frage für dich geklärt hast. Wieviele Suizide gibt es weltweit ungefähr jährlich?     1. ca.10.000  2. 50.000  3. 400.000  4. 800.000";
        questbeschreibung[4] ="Du musst aus der Kanalisation entkommen. Du stehst an einer Kreuzung und du musst dich entscheiden in welche Richtung du läufst. Du hast vier Möglichkeiten: 1. nach links  2. nach rechts  3. nach vorne  4.nach hinten ";
        questbeschreibung[5] ="Auf einem der Köpfe befindet sich ein verknitterter Zettel mit der Aufschrift öffne mich. Du überlegst wie du den Schädel am besten öffnen kannst. Entweder 1. du suchst im Plastikmüll nach etwas scharfem, oder  2.du tritts kräftig auf den Kopf, oder 3. du interessierst dich nicht weiter für den Schädel mit der Aufschrift und wirfts in zurück ins Meer. ";
        questbeschreibung[6] ="Du entdeckst an der Wand eine Karte mit einem Labyrinth. Wenn du auf dieser Karte den richtigen Weg zum Ausgang ausmachen kannst, wirst du lebend entkommen. Wählst du den falschen Weg, so wirst du verhungern, da du zu lange umherirrsrt und kein Essen hast ";
        questbeschreibung[7] ="Du erinnerst dich daran, dass du dringend etwas essen musst. 1. du stürmst in den Speisesaal  2. du isst die Katze, die dich anstarrt  3. du wartest auf eine bessere Gelegenheit ";
        questbeschreibung[8] ="Plötzlich steigen drei Engel zu dir herab und singen: „Du bist der Erste Sterbliche, der es bis ans Ende der Welt geschafft hat. Du bekommst eine Belohnung von himmlischen Ausmahßen, falls du deine letze Aufgabe bestehst: Was kam zuerst? 1. Das Huhn  oder 2. das Ei.“ ";
        questlösung[0] = 3;
        questlösung[1] = 2;
        questlösung[2] = 1;
        questlösung[3] = 4;
        questlösung[4] = 4;
        questlösung[5] = 2;
        questlösung[6] = 0;
        questlösung[7] = 1;
        questlösung[8] = 2;
        
        /*punkte[0] =10 ;
        punkte[1] = 15 ;
        punkte[2] = 25;
        punkte[3] = 30;
        punkte[4] = 50;
        punkte[5] = 120;
        punkte[6] = 70;
        punkte[7] = 60;
        punkte[8] = 1000;
        */
        
        item[0] = "Goldmünze";
        item[1] = "Schlangenkopf";
        item[2] = "leere Flasche";
        item[3] = "Habseligkeiten des Toten";
        item[4] = "Ratten";
        item[5] = "eiförmige Karte zum Ende der Welt";
        item[6] = "Steinchen";
        item[7] = "Saftiges Spanferkel";
        item[8] = "Ein Paar Engelsflügel";
        
        falschLösungen[0][0] = "Der Kobold ruft: FALSCH! und wirft seinen Speer auf dich. Das Letzte was du spürst, ist wie der Speer dein Herz durchdringt. ";
        falschLösungen[0][1] = "Der Kobold ruft: FALSCH! und wirft seinen Speer auf dich. Das Letzte was du spürst, ist wie der Speer dein Herz durchdringt.  ";
        falschLösungen[0][3] = "Der Kobold ruft: FALSCH! und wirft seinen Speer auf dich. Das Letzte was du spürst, ist wie der Speer dein Herz durchdringt.  ";
        falschLösungen[1][0] = "Die Schlange holt dich ein und beißt dich. Du erliegst an ihrem Gift. ";
        falschLösungen[1][2] = "Das war eine schlechte Idee. Das Gift der Schlange wirkt trotzdem und dir wird schwarz vor Augen. ";
        falschLösungen[2][1] = "Das ist leider Falsch. Der Flaschengeist verschwindet und du verdurstest nach ein paar Tagen in der Wüste.";
        falschLösungen[2][2] = "Das ist leider Falsch. Der Flaschengeist verschwindet und du verdurstest nach ein paar Tagen in der Wüste.";
        falschLösungen[3][0] = "Dir fällt auf, dass deine Antwort falsch ist. Du bist so sehr von dir enttäuscht, dass du selber Suizid begehst.";
        falschLösungen[3][1] = "Dir fällt auf, dass deine Antwort falsch ist. Du bist so sehr von dir enttäuscht, dass du selber Suizid begehst.";
        falschLösungen[3][2] = "Dir fällt auf, dass deine Antwort falsch ist. Du bist so sehr von dir enttäuscht, dass du selber Suizid begehst.";
        falschLösungen[4][0] = " Du läufst durch die endlose Kanalisation. Langsam geht dein Proviant zuneige. Jahrhunderte später finden Archäologogen dein Skelett in den Abflussrohren. ";
        falschLösungen[4][1] = " Du läufst durch die endlose Kanalisation. Langsam geht dein Proviant zuneige. Jahrhunderte später finden Archäologogen dein Skelett in den Abflussrohren.";
        falschLösungen[4][2] = " Du läufst durch die endlose Kanalisation. Langsam geht dein Proviant zuneige. Jahrhunderte später finden Archäologogen dein Skelett in den Abflussrohren.";
        falschLösungen[5][0] = " Im Plastikmüll findest du nichst Scharfes. Tue etwas anderes!";
        falschLösungen[5][2] = " Du hast die Geister der Entwickler entzürnt! Voller Wut schicken ziehen sie dich in die Tiefe des Meeres.";
        falschLösungen[6][0] = " Du verhungerst du elendiges Stück ";
        falschLösungen[6][1] = " Du verhungerst du elendiges Stück ";
        falschLösungen[7][1] = " Die Katze sieht aber lecker aus, denkst du dir. Du versuchst die Katze zu packen. Diese wehrt sich jedoch heftig und trifft deine Halsschlagader mit ihren Krallen. Du wirst ihr Abendsnack. ";
        falschLösungen[7][2] = " Diese Gelegenheit bietet sich nie. Das wars mit dir";
        falschLösungen[8][0] = " Du bist eine Enttäuschung und des Himmels nicht würdig!, schreien die Engel. Der Boden tut sich unter dir auf und du fällst in die Hölle.  ";
        
        richtigeLösung[0] ="Der Kobold freut sich und lässt dich passieren. Als Dank gibt er dir Goldmünzen";
        richtigeLösung[1] ="Du packst die Schlange am Kopf und drückst zu. Nach einer Zeit wird der Körper der Schlange schlapp, sie ist tot. Als Trophäe nimmst du ihren Kopf";
        richtigeLösung[2] ="Als Belohnung für deine Kenntnisse führe ich dich aus der Wüste. In einem Wimperzucken bist du in einer Stadt. Der Geist ist verschwunden.Was übrig bleibt ist seine Flasche";
        richtigeLösung[3] ="Du bist glücklich über deine grenzenlose Intelligenz. Als nächstes gehst du in die Kanalisation";
        richtigeLösung[4] ="Du siehst wieder Tageslicht. Während des Weges sammelst du Ratten am Rand auf.";
        richtigeLösung[5] ="In dem Schädel findest du eine mysteriöse, eiförmige Karte. Du beschließt, ihr zu folgen";
        richtigeLösung[6] ="Du entkommst dem Labyrinth und findest Steinchen auf dem Weg";
        richtigeLösung[7] ="Du wirst im Speisesaal wie ein Kaiser empfangen und stopfst dich voll mit Essen";
        richtigeLösung[8] ="Du empfängst den Segen des Himmels und wirst mit einem Paar Engelsflügel belohnt. Du wirst zum Engel und Herrscher über die Welt";
    }

    public boolean starteQuest(int höhlennummer, int spielerID){

        questAusgeben(höhlennummer);
        return questLösen(höhlennummer, spielerID);
    }

    public void questAusgeben(int höhlennummer){
        System.out.print(questbeschreibung[höhlennummer]);
    }

    public boolean questLösen(int höhlennummer, int spielerID){
        int lösung = Tastatur.readint();
        if(lösung == questlösung[höhlennummer]){
            System.out.print(richtigeLösung[höhlennummer]);
            gebeItem(höhlennummer,spielerID, 1); 
            return true;
        }
        else{
            System.out.print(falschLösungen[höhlennummer][lösung-1]);
            return questLösen(höhlennummer,spielerID);
        }
    }

    public void gebeItem(int höhlennummer, int spielerID, int anzahl){

        com.neueBesitzt(spielerID, item[höhlennummer],anzahl);
    }





    }


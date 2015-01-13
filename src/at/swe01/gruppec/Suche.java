package at.swe01.gruppec;

public class Suche {
    public static void main(String[] args){

        // Der folgende Text soll durchsucht werden, er wird in Kleinbuchstaben umgewandelt.
        String text = "Hallo, ich bin ein Text und will durchsucht werden! Also los, durchsuch mich!";
        text = text.toLowerCase();

        // Dieser Text (wird auch in Kleinbuchstaben verwandelt) soll im obigen Text gesucht werden.
        // Eigentlich sollte der Benutzer diesen Text selbst eingeben können.
        String suche = "Such";
        suche = suche.toLowerCase();
        
        boolean kommtSuchbegriffVor = text.contains(suche);

        if(kommtSuchbegriffVor){
            // Der Suchbegriff kommt vor, also schauen wir wie oft.
            int anzahl = getNumberOfOccurrences(text, suche, 0);
            System.out.println("'" + suche + "' wurde im Text " + anzahl + "-mal gefunden.");
        } else {
            // Der Suchbegriff kommt nicht vor.
            System.out.println("'" + suche + "' wurde im Text nicht gefunden.");
        }

    }

    /**
     * Diese Methode sagt, wie oft ein String s in einem String t ab der Position offset vorkommt.
     * @param t Text
     * @param s Suchbegriff
     * @param offset Position ab der gesucht werden soll.
     * @return Anzahl der Treffer
     */
    public static int getNumberOfOccurrences(String t, String s, int offset){
        // Nachschauen, ob und wo der Suchbegriff ab "offset" vorkommt.
        int pos = t.indexOf(s, offset);
        
        if(pos < 0){
            // Falls er nicht vorkommt, wird 0 zurückgegeben.
            return 0;
        } else {
            // Falls er vorkommt, wird das Ergebnis der Suche ab dem Ende des aktuellen Treffers + 1 zurückgegeben.
            // (Rekursion)
            return 1 + getNumberOfOccurrences(t, s, pos + s.length());
        }
    }
}

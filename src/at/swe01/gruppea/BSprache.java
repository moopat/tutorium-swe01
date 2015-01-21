package at.swe01.gruppea;

public class BSprache {

    public static void main(String[] args){
        // Dieser Text sollte vom Benutzer eingegeben werden.
        String text = "Meine Mutter isst gerne Fisch.";

        // Im StringBuffer speichern wir die Ausgabe Zeichen für Zeichen.
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < text.length(); i++){ // Wir schauen uns den String Zeichen für Zeichen an.
            char aktuell = text.charAt(i);

            if(isVocal(aktuell)){
                // Überprüfen ob der Buchstabe an Anfang oder Ende des Textes steht.
                if(i == 0 || i == text.length() - 1){
                    // Da das Zeichen am Textanfang oder -ende steht wird es sowieso unverändert ausgegeben.
                    buffer.append(aktuell);
                } else {
                    // Vorheriges und nächstes Zeichen wird in "prev" bzw "next" gespeichert.
                    char prev = text.charAt(i-1);
                    char next = text.charAt(i+1);
                    if(Character.isLetter(prev) && Character.isLetter(next)){
                        // Wenn vorheriges und nächstes Zeichen ein Buchstabe sind befindet sich der Vokal
                        // in der Wortmitte und wird daher bearbeitet ausgegeben.
                        buffer.append(aktuell);
                        buffer.append('b');
                        buffer.append(aktuell);
                    } else {
                        // Buchstabe steht am Wortrand und wird unverändert ausgegeben.
                        buffer.append(aktuell);
                    }
                }
            } else {
                // Das Zeichen ist kein Vokal und wird unverändert ausgegeben.
                buffer.append(aktuell);
            }
        }

        // Aus dem StringBuffer wird ein String gemacht, der in Output gespeichert wird.
        String output = buffer.toString();
        System.out.println(output);
    }

    /**
     * Die Methode überprüft ob ein Zeichen ein Vokal ist.
     * @param zeichen Zeichen
     * @return TRUE wenn das Zeichen ein Vokal ist.
     */
    public static boolean isVocal(char zeichen){
        // Damit sowohl große als auch kleine Vokale erkannt werden,
        // wandeln wir den Character in einen Kleinbuchstaben um.
        zeichen = Character.toLowerCase(zeichen);

        // Alle Vokale die wir kennen schreiben wir (klein) in einen String.
        String vokale = "aeiouäöü";

        // Wir wissen, dass indexOf() immer -1 zurückgibt, wenn ein Zeichen nicht
        // in einem String gefunden wird.
        // Das nutzen wir um zu schauen, ob "zeichen" in "vokale" vorkommt.
        int pos = vokale.indexOf(zeichen);

        if(pos < 0){ // Bei einem Index kleiner als 0 gibt es das Zeichen nicht im String, daher ist es kein Vokal.
            return false;
        } else {
            return true;
        }

        /*
         * Alternativ kann man die letzten beiden "Absätze" so ersetzen:
         * return vokale.indexOf(zeichen) >= 0;
         */
    }
    
}

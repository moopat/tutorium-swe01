package at.swe01.gruppec;

public class Reisepass {

    public static void main(String[] args) {
        String line1 = "P<LTUBRUZAITE<<VIGILIJA<EVA<<<<<<<<<<<<<<<<<";
        String line2 = "00000000<0LTU7803118F210127747803111025<<<64";
        
        String land = line1.substring(2, 5);
        System.out.println("Land: " + land);

        /**
         * Wir wissen, dass der Nachname bei Stelle 5 beginnt, und beim ersten Vorkommen von "<<"
         * endet. Daher suchen wir die Position von "<<" und extrahieren den Substring von 5 bis
         * zur gefundenen Position.
         */
        int endOfNachname = line1.indexOf("<<");
        String nachname = line1.substring(5, endOfNachname);
        System.out.println("Nachname: " + nachname);

        /**
         * Der Start des Vornamens ist zwei Stellen ("<<") nach dem Ende des Nachnamens.
         * Das Ende des Vornamens ist beim ersten Vorkommen von "<<" nach dem Beginn des Vornamens,
         * daher wird der Vorname als Substring zwischen diesen Stellen extrahiert.
         * Einfache "<" Zeichen sind wie Leerzeichen zu sehen, daher werden sie vor der Ausgabe
         * durch Leerzeichen ersetzt.
         */
        int startOfFirstname = endOfNachname + 2;
        int endOfFirstname = line1.indexOf("<<", startOfFirstname);
        String firstname = line1.substring(startOfFirstname, endOfFirstname);
        firstname = firstname.replace("<", " ");
        System.out.println("Vorname: " + firstname);

        /**
         * Die Passnummer steht am Anfang der 2. Zeile und ist 9 Zeichen lang.
         * Manche Länder haben kurze Passnummern, die dann mit "<"-Zeichen enden.
         * Diese Zeichen werden gelöscht, also durch "" ersetzt.
         */
        String passnummer = line2.substring(0, 9);
        passnummer = passnummer.replace("<", "");
        System.out.println("Passnummer: " + passnummer);
        
        String geschlecht = line2.substring(20, 21);
        System.out.println("Geschlecht: " + geschlecht);
        
    }
    
}

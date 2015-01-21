package at.swe01.gruppeb;

public class Suche {
    
    public static void main(String[] args){
        String text = "Der Österreichische Hausärzteverband kann sich immer noch nicht mit der Elektronischen Gesundheitsakte (Elga) anfreunden. Für Hausärztepräsident Christian Euler ist es eine kranke Akte. Konkret bezieht sich die Kritik auf die lange Bearbeitungszeit der Abmeldungserklärungen und auf die Nichteinhaltung des Zeitplans. Der Hausärzteverband rät den Patienten weiterhin, sich von Elga abzumelden, also das Opt-out wahrzunehmen, fordert aber eigentlich ein System, das auf Freiwilligkeit basiert.";
        
        System.out.println("Bitte gib einen Suchbegriff ein.");
        String suche = Template.userInputRead();
        if(suche == null || suche.length() < 1){
            System.err.println("(!) Du musst einen Text eingeben.");
            System.exit(1);
        }

        // Text und Suchbegriff werden in Kleinbuchstaben umgewandelt,
        // damit wir bei der Suche nach "AU" auch "Haus" finden.
        text = text.toLowerCase();
        suche = suche.toLowerCase();

        // Speichert die aktuelle Trefferzahl.
        int count = 0;

        // Merkt sich, wo beim nächsten Mal mit der Suche begonnen wird.
        int nextIndex = 0;
        
        while(nextIndex != -1){ // Wir hören mit der Schleife auf, wenn der Begriff nicht mehr gefunden wird.
            /*
             Nach dem folgenden Aufruf ist der Wert von nextIndex die Position des Suchbegriffs im Text
             ab der Position des *alten* nextIndex-Werts. (Das Ergebnis überschreibt den alten Wert.)
             */
            nextIndex = text.indexOf(suche, nextIndex);
            /*
            Falls nextIndex *nicht* größer als -1 ist passiert nichts mehr, und die while-Schleife wird kein weiteres
            Mal aufgerufen.
             */
            if(nextIndex > -1){
                // nextIndex wird um die Suchbegriffslänge erhöht, da erst nach dem aktuellen Treffer weitergesucht werden soll.
                nextIndex = nextIndex + suche.length();
                // Die Anzahl der Treffer wird erhöht.
                count++;
            }
        }
        
        System.out.println("Treffer: " + count);

        // Der Suchbegriff wird im Text (Text ist seit Zeile 17 kleingeschrieben)
        // durch den großgeschriebenen Suchbegriff ersetzt und dann ausgegeben.
        String output = text.replace(suche, suche.toUpperCase());
        System.out.println(output);
        
    }
    
}

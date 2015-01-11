package at.swe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocialSecurityValidator {

    public static void main(String[] args) {

        boolean isValidInput = false;
        String socialSecurityNumber = "";

        /*
            Sozialversicherungsnummer einlesen und einfache Validierungen sofort durchführen:
            - Länge muss 10 sein
            - Es dürfen nur Zahlen vorkommen
            - Eventuell prüfen, ob das Datum plausibel ist (TODO)
         */
        while(!isValidInput){
            socialSecurityNumber = readString("Bitte gib die 10-stellige Sozialversicherungsnummer ohne Leerzeichen ein!");
            if(socialSecurityNumber == null || socialSecurityNumber.length() != 10){
                System.out.println("(!) Die Sozialversicherungsnummer muss genau 10 Stellen haben.");
            } else {
                // Prüfen, ob es sich nur um Zahlen handelt.
                isValidInput = true;
                for(char number : socialSecurityNumber.toCharArray()){
                    if(!Character.isDigit(number)) isValidInput = false;
                }
                if(!isValidInput) System.out.println("(!) Die Sozialversicherungsnummer darf nur aus Zahlen bestehen!");
            }
        }

        // Die Sozialversicherungsnummer ist jetzt syntaktisch korrekt vorhanden

        // Auslesen der Prüfziffer aus der Eingabe, indem der char an der jeweiligen Position extrahiert wird
        // und dessen numerischer Wert ausgelesen wird.
        int checkNumber = Character.getNumericValue(socialSecurityNumber.charAt(3));

        // Errechnen der korrekten Prüfziffer.
        int calculatedCheckNumber = getCheckNumber(socialSecurityNumber);

        // Vergleich der beiden Prüfziffern.
        if(calculatedCheckNumber != checkNumber){
            System.out.println("(!) Die Sozialversicherungsnummer ist nicht gültig!");
        } else {
            System.out.println("Die Sozialversicherungsnummer ist gültig!");
        }

    }

    /**
     * Die Prüfziffer einer eingegebenen Sozialversicherungsnummer wird errechnet.
     * Die Nummer muss 10 Stellen lang sein und aus Ziffern bestehen.
     * Die Stelle der Prüfziffer wird ignoriert.
     * @param socialSecurityNumber 10-stellige numerische Sozialversicherungsnummer
     * @return Prüfziffer zwischen 0 und 10.
     */
    public static int getCheckNumber(String socialSecurityNumber){
        // Die Multiplikatoren für alle Felder. 0 an der 4. Stelle bewirkt, dass die Prüfziffer ignoriert wird.
        int[] multipliers = {3, 7, 9, 0, 5, 8, 4, 2, 1, 6};
        int sum = 0;
        for(int i = 0; i < socialSecurityNumber.length(); i++){
            // Für jedes Zeichen in der SVNR wird mit dem jeweiligen Multiplikator multipliziert und die
            // Ergebnisse aufsummiert.
            sum += multipliers[i] * Character.getNumericValue(socialSecurityNumber.charAt(i));
        }
        return sum % 11;
    }

    /**
     * Methode zum Lesen eines Strings aus der Kommandozeile.
     * @param prompt Der vor der Eingabe anzuzeigende Text oder null.
     * @return Eingegebener String
     */
    public static String readString(String prompt){
        if(prompt != null) {
            System.out.println(prompt);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.err.println("(!) Input kann nicht gelesen werden.");
            System.exit(1);
        }

        return input;
    }

}

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
            - Es dürfen nur Zahlen vorkommen, bzw. ein "X" an 4. Stelle (am Index 0)
         */
        while(!isValidInput){
            socialSecurityNumber = readString("Bitte gib die 10-stellige Sozialversicherungsnummer ohne Leerzeichen ein!");
            if(socialSecurityNumber == null || socialSecurityNumber.length() != 10){
                System.out.println("(!) Die Sozialversicherungsnummer muss genau 10 Stellen haben.");
            } else {
                // Prüfen, ob es sich nur um Zahlen handelt bzw ein X an der 4. Stelle handelt
                // Wir nehmen von vorne herein an, dass der Input gültig ist, und setzten isValidInput auf false, falls
                // wir einen Fehler entdecken.
                isValidInput = true;
                for(int i = 0; i < socialSecurityNumber.length(); i++){
                    char currentLetter = socialSecurityNumber.charAt(i);
                    // Das Zeichen ist ungültig, wenn es sich nicht um eine Zahl handelt,
                    // und das Zeichen weder ein X noch an vierter Stelle ist.
                    if(!Character.isDigit(currentLetter) && (currentLetter != 'X' || i != 3)){
                        isValidInput = false;
                    }
                }

                if(!isValidInput){
                    System.out.println("(!) Die Sozialversicherungsnummer darf nur aus Zahlen bestehen!");
                }
            }
        }

        // Wenn die 4. Stelle (Index 3) ein X ist, ist die Nummer unvollständig.
        boolean isCompleteNumber = socialSecurityNumber.charAt(3) != 'X';

        // Die korrekte Prüfziffer wird ausgerechnet.
        int calculatedCheckNumber = getCheckNumber(socialSecurityNumber);

        if(isCompleteNumber){ // Die Nummer ist vollständig und soll überprüft werden.
            // Auslesen der Prüfziffer aus der Eingabe, indem der char an der jeweiligen Position extrahiert wird
            // und dessen numerischer Wert ausgelesen wird.
            int checkNumber = Character.getNumericValue(socialSecurityNumber.charAt(3));

            // Vergleich der beiden Prüfziffern.
            if(calculatedCheckNumber != checkNumber){
                System.out.println("(!) Die Sozialversicherungsnummer ist nicht gültig!");
            } else {
                System.out.println("Die Sozialversicherungsnummer ist gültig!");
            }
        } else { // Die Nummer ist unvollständig und das X soll durch die errechnete Prüfziffer ersetzt werden.
            if(calculatedCheckNumber == 10){
                System.out.println("(!) Diese laufende Nummer gibt es am gewählten Tag nicht.");
            } else {
                String completeNumber = socialSecurityNumber.replace("X", String.valueOf(calculatedCheckNumber));
                System.out.println("Die vollständige Nummer lautet " + completeNumber + ".");
            }
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

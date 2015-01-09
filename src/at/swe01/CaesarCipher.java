package at.swe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarCipher {

    public static void main(String[] args) {

        boolean hasValidString = false;
        boolean hasValidShift = false;
        String input = null;
        int shift = 0;

        while(!hasValidString){
            input = readString("Text der verschlüsselt werden soll: ");
            if(input == null || input.length() < 1){
                System.out.println("(!) Die Zeichenkette muss mindestens ein Zeichen haben.");
            } else {
                hasValidString = true;
            }
        }


        while(!hasValidShift){
            String shiftString = readString("Größe der Verschiebung: ");
            try {
                // Aus dem String wird ein Integer gemacht.
                shift = Integer.valueOf(shiftString);
                if(shift < -25 || shift > 25){
                    System.out.println("(!) Du musst eine Zahl zwischen -25 und 25 eingeben.");
                } else {
                    hasValidShift = true;
                }
            } catch (Exception e){
                System.out.println("(!) Du musst eine gültige Zahl eingeben.");
            }
        }

        String output = encode(input, shift);
        System.out.println(output);
    }

    /**
     * Verschlüsst einen Text mit der Cäsar-Verschlüsselung.
     * @param input Zu verschlüsselnder Text
     * @param shift Größe der Zeichenverschiebung
     * @return Verschlüsselter Text
     */
    public static String encode(String input, int shift){
        /*
         * Negative Zahlen werden zu 26 dazuaddiert:
         * Eine Verschiebung um -1 entspricht einer Verschiebung um 25.
         */
        if(shift < 0) shift = 26 + shift;

        StringBuilder builder = new StringBuilder();
        // Die Eingabe wird in ein Array aus Großbuchstaben umgewandelt.
        char[] inputChars = input.toUpperCase().toCharArray();
        for (char inputChar : inputChars) {
            if(inputChar < 'A' || inputChar > 'Z'){
                // Zeichen die nicht zwischen A und Z liegen werden unverändert zurückgegeben.
                builder.append(inputChar);
            } else {
                /*
                 * A wird bei der Verschiebung subtrahiert und danach wieder addiert, da A nicht den Wert 1 hat.
                 * Die Modulo-Operation wird benötigt, damit die Zahl des neuen Buchstabens nicht größer als 25 wird (und nach Z wieder A folgt).
                 */
                char newChar = (char) ((inputChar + shift - 'A') % 26 + 'A');
                builder.append(newChar);
            }
        }
        return builder.toString();
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
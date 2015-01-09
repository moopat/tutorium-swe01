package at.swe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetterHistrogram {

    public static int[] values;

    public static void main(String[] args){

        String text = "";
        boolean isValidText = false;

        while(!isValidText){
            text = readString("Gib einen Text ein!");
            if(text == null || text.length() < 1){
                System.out.println("Der Text muss zumindest ein Zeichen lang sein.");
            } else {
                isValidText = true;
            }
        }

        // Ein Array in der Größe des Alphabets wird initialisiert.
        // Es wird für jeden Buchstaben die Anzahl der Vorkommnisse enthalten.
        // values[0] soll die Werte für A, und values[25] die Werte für Z enthalten.
        values = new int[26];

        // Der Text wird in ein großbuchstabiges Character-Array gespeichert.
        char[] textchars = text.toUpperCase().toCharArray();

        // Alle Buchstaben des Textes werden nacheinander begutachtet.
        for(char letter : textchars){
            // Ist der Buchstabe im Bereich A-Z?
            if(letter >= 'A' && letter <= 'Z'){
                // Der Array-Index errechnet sich durch letter - 'A', so dass 'A' am Index 0 ist.
                // Der Wert wird inkrementiert.
                values[letter - 'A']++;
            }
        }

        // Alle Buchstaben des Alphabets werden nacheinander begutachtet.
        for(int i = 0; i < values.length; i++){
            StringBuilder output = new StringBuilder();
            // Zuerst wird der jeweilige Buchstabe an den String angehängt,
            // indem der Index zu 'A' addiert und in char umgewandelt wird.
            output.append((char) ('A' + i));
            output.append(" ");

            // So oft wie der Buchstabe vorgekommen ist (= Wert von values[i]) wird ein * angezeigt.
            for(int j = 0; j < values[i]; j++){
                output.append("*");
            }

            // Zum Schluss wird aus dem "output" ein String gemacht und angezeigt.
            System.out.println(output.toString());
        }
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

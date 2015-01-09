package at.swe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInString {

    // Textquelle: http://derstandard.at/2000010137826/Elga-Hausaerzteverband-pocht-weiter-auf-Freiwilligkeit
    static String text = "Der Österreichische Hausärzteverband kann sich immer noch nicht mit der Elektronischen Gesundheitsakte (Elga) anfreunden.\nFür Hausärztepräsident Christian Euler ist es eine kranke Akte. Konkret bezieht sich die Kritik auf die lange \nBearbeitungszeit der Abmeldungserklärungen und auf die Nichteinhaltung des Zeitplans. Der Hausärzteverband rät den \nPatienten weiterhin, sich von Elga abzumelden, also das Opt-out wahrzunehmen, fordert aber eigentlich ein System, das auf \nFreiwilligkeit basiert.";

    public static void main(String[] args) {

        boolean isValidSearchTerm = false;
        String searchTerm = "";

        // Suchbegriff einlesen
        while(!isValidSearchTerm){
            searchTerm = readString("Bitte gib einen Suchbegriff ein: ");
            if(searchTerm != null && searchTerm.length() >= 1){
                isValidSearchTerm = true;
            } else {
                System.out.println("(!) Der Suchbegriff muss mindestens ein Zeichen lang sein!");
            }
        }

        // Wir wandeln die Texte in Kleinbuchstaben um, damit wir leichter suchen können.
        text = text.toLowerCase();
        searchTerm = searchTerm.toLowerCase();

        // Kommt der Suchbegriff überhaupt vor?
        boolean occurs = text.contains(searchTerm);

        if(occurs){
            // Ausgeben, wie oft der Suchbegriff vorkommt.
            System.out.println("\"" + searchTerm.toUpperCase() + "\" kommt " + getNumberOfOccurences(text, searchTerm) + " mal vor.");
            // Den Suchbegriff im Text durch den Suchbegriff in Großschreibung ersetzen und ausgeben.
            System.out.println(text.replace(searchTerm, searchTerm.toUpperCase()));
        } else {
            // Der Suchbegriff wurde nicht gefunden.
            System.out.println("\"" + searchTerm.toUpperCase() + "\" wurde im Text nicht gefunden.");
        }


    }

    /**
     * Liefert zurück wie oft "search" in "text" vorkommt.
     * @param text zu durchsuchender Text
     * @param search Suchbegriff
     * @return Anzahl der Vorkommnisse
     */
    public static int getNumberOfOccurences(String text, String search){
        // Wir geben das Ergebnis für eine Suche ab Stelle 0 zurück.
        return getNumberOfOccurences(text, search, 0);
    }

    /**
     * Liefert zurück wie oft "search" in "text" ab Stelle "offset" vorkommt.
     * @param text zu durchsuchender Text
     * @param search Suchbegriff
     * @param offset Stelle, ab der gesucht wird
     * @return Anzahl der Vorkommnisse
     */
    public static int getNumberOfOccurences(String text, String search, int offset){
        // Standardmäßig gehen wir davon aus, dass der Begriff nicht gefunden wird.
        int occurences = 0;
        // Die Position des Suchbegriffs im Text, oder -1 falls er nicht vorkommt.
        int position = text.indexOf(search, offset);
        // Wenn der Begriff nicht gefunden wurde geben wir 0 zurück.
        if(position < 0) return occurences;
        // Ansonsten erhöhen wir die occurences auf 1
        occurences++;
        // Der rekursive Aufruf startet die Suche am Ende des letzten Treffers und liefert
        // zurück wie viele Treffer es ab der jeweiligen Position gibt.
        return occurences + getNumberOfOccurences(text, search, position + search.length());
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

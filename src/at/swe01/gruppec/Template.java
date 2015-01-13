package at.swe01.gruppec;

/**
 * Diese Klasse wurde 1:1 aus Moodle übernommen.
 */
public class Template {
    private static java.io.BufferedReader userInputBR = null;
    public static void main(String[] args) {
        String input = userInputRead();
        System.out.println("Sie haben eingegeben: " + input);
    }
    /**
     * DE: Diese Funktion ruft die letzte älteste Zeile (Nutzereingabe + Enter)
     * ab. Schnell schreibende Nutzer können also mehrere Befehle in
     * "userInputRead" eingetippt haben, bevor Sie diese ausgewertet haben.
     * @return String DE: Älteste Zeile von der Tastatur (ohne das Zeilenumbruchszeichen).
     */
    public static String userInputRead() {
        try {
            if (userInputBR == null) {
                String fileEncoding = System.getProperty("file.encoding");
                if (fileEncoding.equalsIgnoreCase("UTF-8")) {
                    //Netbeans fix for Console-input
                    userInputBR = new java.io.BufferedReader(new java.io.InputStreamReader(System.in, "ISO-8859-1"));
                } else {
                    userInputBR = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
                }
            }
            String input = userInputBR.readLine();
            if (input != null) {
                return input;
            }
        } catch (java.io.IOException ex) {
            /*Dies würde man in der Praxis mit einer "Logging"-Klasse lösen, und nicht direkt auf System.err schreiben!*/
            System.err.println("DE: Ein Fehler beim Lesen der Nutzereingabe ist aufgetreten!\n" + ex.getLocalizedMessage());
        }
        return "";
    }
}
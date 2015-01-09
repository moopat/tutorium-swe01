package at.swe01;

public class PassportReader {

    // Die beiden maschinenlesbaren Zeilen des Reisepasses.
    // Die Prüfziffern sind in diesem Beispiel nicht relevant.
    public static String line1 = "P<USA<KELSO<<BOB<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
    public static String line2 = "L0287498<3USA4010120M160505<<<<<<<<<<<<<<<<5";

    public static void main(String[] args){
        // Die Nationalität befindet sich immer zwischen 2. und 5. Position.
        System.out.println("Nationalität: " + line1.substring(2, 5));

        // Der Nachname kommt nach der Nationalität und geht bis zum nächsten <<.
        int endOfLastName = line1.indexOf("<<", 6);
        System.out.println("Nachname: " + line1.substring(6, endOfLastName));

        // Der Vorname kommt nach dem Nachnamen und geht bis zum nächsten << (ein < alleine wäre das Trennzeichen für den 2. Vornamen)
        int beginOfFirstName = endOfLastName + 2;
        System.out.println("Vorname: " + line1.substring(beginOfFirstName, line1.indexOf("<<", beginOfFirstName)));

        // Die Passnummer befindet sich am Anfang der zweiten Zeile und ist 9 Zeichen lang. < am Ende werden gekürzt.
        System.out.println("Passnummer: " + line2.substring(0, 9).replace("<", ""));

        // Das Geschlecht ist immer an der 20. Position.
        System.out.println("Geschlecht: " + line2.substring(20, 21));
    }
}

package at.swe01.gruppec;

import at.swe01.Template;

public class Verschluesselung {
    
    public static void main(String[] args){

        /**
         * Es werden zwei Arrays definiert. Eines enthält das normale Alphabet,
         * und eines das kodierte Alphabet (um 13 Stellen verschoben).
         */
        char[] klartext = new char[26];
        char[] kodiert = new char[26];
        
        for(int i = 0; i < klartext.length; i++){
            // ('A' + i) ergibt einen Integer, und muss mit (char) wieder in ein Zeichen umgewandelt werden.
            klartext[i] = (char) ('A' + i);
            // Im verschlüsselten Array ist der jeweilige Buchstabe um 13 Zeichen verschoben. Damit der Array-Index
            // nicht größer als 25 wird, wird der errechnete Index mit "%26" normalisiert.
            kodiert[(i + 13) % 26] = (char) ('A' + i);
        }

        // Lesen des zu verschlüsselnden Textes.
        System.out.println("Geben Sie den zu verschlüsselnden Text ein!");
        String text = Template.userInputRead();

        // Falls der Text leer ist wird eine Fehlermeldung ausgegeben und das Programm beendet.
        if(text == null || text.length() < 1){
            System.err.println("(!) Es muss ein Text eingegeben werden!");
            System.exit(1);
        }

        // Der Text wird in Großbuchstaben umgewandelt,
        // damit auch Eingaben in Kleinschreibung verschlüsselt werden können.
        text = text.toUpperCase();

        // Der StringBuffer wird genutzt, um einen String (das Ergebnis) nach und nach zusammenzusetzen.
        StringBuffer output = new StringBuffer();
        
        for(int i = 0; i < text.length(); i++){
            // Es wird die Position des i.ten Buchstaben des Texts im klartext-Array gesucht.
            int positionOfCharInKlartext = getPosition(text.charAt(i), klartext);

            // Falls der Buchstabe nicht im Array vorkommt (-1) wird er unverschlüsselt an den String angehängt.
            if(positionOfCharInKlartext == -1){
                output.append(text.charAt(i));
            } else {
                // Ansonsten wird das Zeichen aus der äquivalenten Stelle des kodiert-Arrays an den String angehängt.
                char kod = kodiert[positionOfCharInKlartext];
                output.append(kod);
            }
            
        }

        // Mit output.toString() wird der String fertiggestellt, und hier auch sofort ausgegeben.
        System.out.println("Verschlüsselter Text:");
        System.out.println(output.toString());
        
    }

    /**
     * Diese Methode gibt die Position eines Zeichens in einem Array aus.
     * @param suche das zu suchende Zeichen
     * @param array das char-Array in dem gesucht wird
     * @return Position oder -1
     */
    public static int getPosition(char suche, char[] array){
        for(int i = 0; i < array.length; i++){
            // Falls die aktuelle Stelle im Array mit dem gesuchten Zeichen übereinstimmt, wird die aktuelle Stelle
            // zurückgegeben, und die Methode wird beendet.
            if(array[i] == suche){
                return i;
            }
        }
        // Falls das Zeichen im Array nicht gefunden wurde wird -1 zurückgegeben.
        return -1;
    }
    
}

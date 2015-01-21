package at.swe01.gruppeb;

public class Reisepass {

    public static void main(String[] args){
        String zeile1 = "P<USAKELSO<<BOB<TIM<<<<<<<<<<<<<<<<<<<<<<<<<";
        String zeile2 = "L0287498<3USA4010120M160505<<<<<<<<<<<<<<<<5";
        
        String nation = zeile1.substring(2, 5);
        System.out.println("Land: " + nation);
        
        int endeNachname = zeile1.indexOf("<<", 5);
        String nachname = zeile1.substring(5, endeNachname);
        System.out.println("Nachname: " + nachname);
        
        int endeVorname = zeile1.indexOf("<<", endeNachname + 2);
        String vorname = zeile1.substring(endeNachname + 2, endeVorname);
        vorname = vorname.replace("<", " ");
        System.out.println("Vorname: " + vorname);
        
        String passnummer = zeile2.substring(0, 9);
        passnummer = passnummer.replace("<", "");
        System.out.println("Passnummer: " + passnummer);
        
        String geschlecht = zeile2.substring(20, 21);
        System.out.println("Geschlecht: " + geschlecht);
        
        
    }
    
}

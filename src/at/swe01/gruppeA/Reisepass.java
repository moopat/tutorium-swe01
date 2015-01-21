package at.swe01.gruppeA;

public class Reisepass {
    
    public static void main(String[] args){
        
        String zeile1 = "P<USAKELSO<<BOB<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
        String zeile2 = "L0287498<3USA4010120M160505<<<<<<<<<<<<<<<<";

        // Land
        String land = zeile1.substring(2, 5);
        System.out.println("Land: " + land);
        
        // Nachname
        int endOfLastname = zeile1.indexOf("<<", 5);
        String lastname = zeile1.substring(5, endOfLastname);
        System.out.println("Nachname: " + lastname);
        
        // Vorname
        int startOfFirstname = endOfLastname + 2;
        int endOfFirstname = zeile1.indexOf("<<", startOfFirstname);
        String firstname = zeile1.substring(startOfFirstname, endOfFirstname);
        System.out.println("Vorname: " + firstname);
    }
    
}

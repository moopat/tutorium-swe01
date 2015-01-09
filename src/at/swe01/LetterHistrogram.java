package at.swe01;

public class LetterHistrogram {

    public static String text;
    public static int[] values;

    public static void main(String[] args){
        text = "Guten Morgen liebe Sorgen, seid ihr auch schon alle da? Habt ihr auch so gut geschlafen? Na dann ist ja alles klar!";

        values = new int[26];

        char[] textchars = text.toUpperCase().toCharArray();

        for(char letter : textchars){
            if(letter >= 'A' && letter <= 'Z'){
                values[letter - 'A']++;
            }
        }

        for(int i = 0; i < values.length; i++){
            StringBuilder output = new StringBuilder();
            output.append((char) ('A' + i));
            output.append(" ");
            for(int j = 0; j < values[i]; j++){
                output.append("*");
            }
            System.out.println(output.toString());
        }
    }
}

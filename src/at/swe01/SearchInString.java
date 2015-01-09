package at.swe01;

public class SearchInString {

    static String text;

    public static void main(String[] args) {

        text = "Jede Woche gibt es ein Wochenende.";

        String search = "Woche";

        text = text.toLowerCase();
        search = search.toLowerCase();

        boolean occurs = text.contains(search);

        if(occurs){
            System.out.println("\"" + search + "\" kommt " + getNumberOfOccurences(text, search) + " mal vor.");
            System.out.println(text.replace(search, search.toUpperCase()));
        } else {
            System.out.println("\"" + search + "\" wurde im Text nicht gefunden.");
        }


    }

    public static int getNumberOfOccurences(String text, String search){
        return getNumberOfOccurences(text, search, 0);
    }

    public static int getNumberOfOccurences(String text, String search, int offset){
        // By default, we do not assume that the String is found.
        int occurences = 0;
        // The position of the searched term in the text, or -1 if it is not found.
        int position = text.indexOf(search, offset);
        // If the string is not found, we can return the number of occurences.
        if(position < 0) return occurences;
        // Otherwise, we increase it to one.
        occurences++;
        // The recursive call will start search at the end of the last found String and return 0 or 1 if the String is found.
        return occurences + getNumberOfOccurences(text, search, position + search.length());
    }

}

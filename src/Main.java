import java.lang.StringBuilder;
public class Main {

    public static void main(String[] args) {

        System.out.println(decipherThis("72olle 103doo 100ya"));

    }

    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String str) {

        int total = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {

                total += 1;


            } else if (str.charAt(i) == ')') {


                total += -1; //check later

                if (total < 0) {

                    return false;

                }

            }

        }

        return total == 0;

    }




    // 2. reverseInteger

    public static String reverseInteger(int num) {

        String str = String.valueOf(num); //mk string to int
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) { //minus 1 because of index

            result.append(str.charAt(i));

        }

        return result.toString();

    }


    // 3. encryptThis

    public static String encryptThis (String str) {

        StringBuilder result = new StringBuilder(str);

        String[] strings = result.toString().split(" ");

        result = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            StringBuilder something = new StringBuilder(strings[i]);
            char secondChar = something.charAt(1);
            char lastOne = something.charAt(something.length()-1);

            something.setCharAt(1,lastOne);
            something.setCharAt(something.length()-1,secondChar);

            int firstCharAsInt = (int) something.charAt(0); //converts int to string
            something.deleteCharAt(0);
            something.insert(0, String.valueOf(firstCharAsInt));

            //System.out.println(something);
            result.append(something);

            //to have spaces between each word
            if (i < strings.length - 1) {
                result.append(" ");
            }

        }

        return result.toString();

    }


    // 4. decipherThis

    public static String decipherThis(String str) {

        //splitting it through an array and split each word
        String[] strings = str.split(" ");

        //initialising the stringbuilder to hold the result
        StringBuilder result = new StringBuilder();

        //iterating over the words in the array
        for (int i = 0; i < strings.length; i++) {

            String remove = strings[i].replaceAll("\\D+",""); //remove non-digit
            int intVerseOfRemove = Integer.parseInt(remove); //converting the string to an int
            char charVerseOfRemove = (char) intVerseOfRemove; //converting to a char

            //replaced the digits back to a char
            strings[i] = strings[i].replace(remove,"" + charVerseOfRemove);

            char secondChar = strings[i].charAt(1); //finding the second letter
            char lastOne = strings[i].charAt(strings[i].length()-1); //finding the second last letter

            //setcharAt cant be done in strings so we did another stringbuilder
            StringBuilder replace = new StringBuilder(strings[i]);
            replace.setCharAt(1,lastOne);
            replace.setCharAt(strings[i].length()-1,secondChar);

            //add the decrypted word to the result string ++++
            result.append(replace);

            //to have spaces between each word and the last one doesn't show up
            if (i < strings.length - 1) {

                result.append(" ");

            }

        }

        //returned the whole string
        return result.toString();

    }

}
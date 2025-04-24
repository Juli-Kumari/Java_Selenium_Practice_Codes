package Java_Code;

public class TC_11_GetFirstNonRepeatingChar {
// Q. Java function that takes a String as input and returns the first non-repeating character:
    public static char getFirstNonRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return '_';
    }

    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatingChar("swiss"));
    }
}

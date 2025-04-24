package Java_Code;

public class TC_08_ReverseString {

    public static void main (String[] args) {
        String str = "I LOVE JAVA";
        // 1. without reverse() method.      o/p= "AVAJ EVOL I "
        String[] words = str.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];

            for (int j = word.length() - 1; j >= 0; j--) {
                System.out.print(word.charAt(j));
            }

            System.out.print(" ");
        }
        // Method 2: with reverse() method.     o/p= "AVAJ EVOL I "
        for(int i = words.length -1; i >=0; i++){
            StringBuilder stringBuilder = new StringBuilder();
            String reverseString = stringBuilder.reverse().toString() + " ";
            System.out.print(reverseString);
        }


        // 2. o/p= "JAVA LOVE I "
        String rev = "";
        for(int i =0; i<words.length;i++){
            rev = words[i] +" " +rev;
        }
        System.out.println("rev: "+ rev);
    }
}

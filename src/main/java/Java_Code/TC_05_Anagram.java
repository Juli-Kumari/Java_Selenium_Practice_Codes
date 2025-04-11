package Java_Code;

import java.util.Arrays;

public class TC_05_Anagram {

    public static boolean areAnagrams(String s1, String s2, String s3){
        return sortString(s1).equals(sortString(s2))&&sortString(s2).equals(sortString(s3));
    }
    public static String sortString(String s){
        char[] chars = s.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(chars);
        return  new String(chars);
    }


    public static void main (String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";
        String str3 = "Enlist";

        if (areAnagrams(str1, str2, str3)) {
            System.out.println("All three strings are anagrams of each other.");
        } else {
            System.out.println("Strings are NOT anagrams.");
        }

    }
}

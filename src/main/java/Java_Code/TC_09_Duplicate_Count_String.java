package Java_Code;

import java.util.LinkedHashMap;
import java.util.Map;

public class TC_09_Duplicate_Count_String {

        public static void main(String[] args) {
            String input = "HiHello";
            StringBuilder uniqueChars = new StringBuilder();
            Map<Character, Integer> charCount = new LinkedHashMap<>();

            for (char c : input.toCharArray()) {
                // Count occurrences
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);

                // Remove duplicates (preserve order)
                if (uniqueChars.indexOf(String.valueOf(c)) == -1) {
                    uniqueChars.append(c);
                }
            }

            System.out.println("Unique String: " + uniqueChars); // Output: Hielo
            System.out.println("Character Count: " + charCount); // Output: {H=2, i=1, e=1, l=2, o=1}
        }
    }


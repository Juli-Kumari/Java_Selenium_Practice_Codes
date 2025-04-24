package Java_Code;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TC_04_SortUnsortedArray {

    public static void main (String[] args) {
        // 1. sort in Acending order
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("unsorted array: " + Arrays.toString(unsortedArray));

        Arrays.sort(unsortedArray);
        System.out.println("sorted array: " + Arrays.toString(unsortedArray));


        // 2. Sorting in DESENDING order without using sort() method
        int[] unsorArr = {64, 34, 25, 12, 22, 11, 90};
        int temp;
        int len = unsorArr.length;

        for(int i =0; i<len; i++){
            for(int j=0; j<len-i-1; j ++){
                if(unsorArr[j]< unsorArr[j+1]){
                    temp = unsorArr[j];
                    unsorArr[j] = unsorArr[j+1];
                    unsorArr[j+1] = temp;
                }
            }
        }
        System.out.println("sorted by for loop: "+ Arrays.toString(unsorArr));

    }

}

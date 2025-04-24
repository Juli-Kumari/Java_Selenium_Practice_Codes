package Java_Code;

import java.lang.reflect.Array;
import java.util.Scanner;

public class TC_03_Fibonacci_Series {

    public static void fab(int n){
 int a=0, b =1;

 for(int i=1; i< n ; i++){
     System.out.print(a + " ");
     int temp = a+b;
     a = b;
     b=temp;
 }
    }

    public static void main (String[] args) {
fab(10);
     }
}

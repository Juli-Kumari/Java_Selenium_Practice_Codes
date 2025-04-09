package Java_Code;

import java.util.Scanner;

public class TC_02_FactorialOfAnumber {

    // static METHOD
    public static int factorial(int n ){
        if(n==0 || n==1){
            return 1;
        }
        else {
            return n* factorial(n-1);
        }
    }


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");

        int number = sc.nextInt();
        System.out.println("number: " + number);

        int fact =  factorial(number);

        System.out.println("Factorial of number " + number + " is " + fact);

    }
}

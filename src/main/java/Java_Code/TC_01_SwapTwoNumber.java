package Java_Code;

public class TC_01_SwapTwoNumber {
    public static void main (String[] args){
//        Swap two numbers using 3rd variable
            int a =10, b=20, temp;
            temp=a;
            a=b;
            b=temp;
            System.out.println("a = "+ a + ",b = "+ b );

//        without using 3rd variable
        int a1 = 3, b1 = 5;
         a1 = a1+ b1; // 8 = a1
         b1 = a1 - b1; // 8- 5 = 3 = a1
        a1 =  a1 - b1; // 8 - 3 = 5 =b1
        System.out.println("a1 = "+ a1 + ",b1 = "+ b1 );

    }
}

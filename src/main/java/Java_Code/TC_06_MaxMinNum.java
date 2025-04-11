package Java_Code;

public class TC_06_MaxMinNum {

    public static void main (String[] args) {

                int a[] = {8,5,2, 90};

                if(a==null || a.length == 0){
                    return;
                }

                int max = a[0];
                int min = a[0];

                for(int i=1;i<a.length; i++){
                    if(a[i]>max){
                        max = a[i];
                    }
                    if(a[i]<min){
                        min= a[i];
                    }

                }
                System.out.println("max: "+ max + ", min: "+ min);
     }
}

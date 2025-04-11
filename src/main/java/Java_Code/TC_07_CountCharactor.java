package Java_Code;

public class TC_07_CountCharactor {


    public static int countChar(String s){
        if( s == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<s.length();i++){
            count++;
        }
        return count;
    }

    public static void main (String[] args) {
     int count = countChar("juli");
     System.out.println(count);
    }
}

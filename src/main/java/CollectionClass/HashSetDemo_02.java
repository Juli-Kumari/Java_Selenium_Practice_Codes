package CollectionClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo_02 {

    public static void main(String[] args){
        // 1. declaration
        HashSet mySet = new HashSet();
//        Set mySet = new HashSet();
//        HashSet <String>mySet = new HashSet<String>();

        // 2.  adding elements
        mySet.add(100);
        mySet.add(10.9);
        mySet.add("Java");
        mySet.add('A');
        mySet.add(100);
        mySet.add(null);
        mySet.add(null);
        mySet.add(true);

        System.out.println(mySet); // [null, Java, A, 100, 10.9, true]

        // size
        System.out.println(mySet.size());
        // 3. Remove element - one at a time. Not possible to remove all the elements
        mySet.remove(10.9); // direct remove the VALUE, not by index

        System.out.println(mySet); // [null, Java, A, 100, true]

        // 4. Insert an element -> NOT POSSIBLE
        // 5. Retrieve any particular element -> NOT POSSIBLE . Alernative approach
        // Get all elements by -> convert HASH SET into Array List
        ArrayList al = new ArrayList(mySet); // convert HASH SET into Array List
        System.out.println(al); // [null, Java, A, 100, true]
        // now we can easily get the value
        System.out.println(al.get(2)); // A

        // 6. Read all the data using for....each. Normal FOR Loop not used.
        for(Object x: mySet){
            System.out.println(x);
        }
// Using IETRATOR
        Iterator <Object>it = mySet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // 7. clear data
        mySet.clear();
        System.out.println(mySet );



    }

}

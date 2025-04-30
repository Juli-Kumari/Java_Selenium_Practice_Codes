package CollectionClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo_03 {
    public static void main(String[] args){
        // 1.declaration
//        HashMap hm = new HashMap();
        HashMap <Integer, String>hm = new HashMap<Integer, String>();
//        Map map = new HashMap();

        // 2. add pairs
        hm.put(101, "A");
        hm.put(102, "B");
        hm.put(103, "C");
        hm.put(104, "D");
        hm.put(101, "E");

        System.out.println(hm); // return as Set {101=E, 102=B, 103=C, 104=D}

        // 3. size
        System.out.println(hm.size()); // 4

        // 4. remove -> based on key
        hm.remove(103);
        System.out.println(hm); // {101=E, 102=B,104=D}

        // 5. access value of a key
        System.out.println(hm.get(102)); // B

        // 6. get all the keys
        System.out.println(hm.keySet()); // [101, 102, 104]
        // 7. get all the values
        System.out.println(hm.values()); // [E, B, D]
        // 8. get keys along with values
        System.out.println(hm.entrySet()); // return as list [101=E, 102=B, 104=D]

        // 9. reading data from MAP
        // using for.....each
        for(int k: hm.keySet()){
        System.out.println(k+"  " + hm.get(k));
        }
        // iterator
       Iterator <Map.Entry<Integer, String>> it= hm.entrySet().iterator();

        while (it.hasNext()){
           Map.Entry<Integer, String> entry = it.next();
           System.out.println(entry.getKey()+ " : " + entry.getValue());
        }
        // 10. clear
        hm.clear();
        System.out.println(hm.isEmpty()); // true
    }

}

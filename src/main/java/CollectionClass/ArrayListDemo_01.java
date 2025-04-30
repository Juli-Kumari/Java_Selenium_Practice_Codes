package CollectionClass;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListDemo_01 {

    public static void main(String[] args){
        // Define array list
        // 1. Hetrogenious data
//        ArrayList arrayList = new ArrayList();
//         List arrayList = new ArrayList();

        // 2. homogenious data
//        ArrayList <Integer>arrayList = new ArrayList<Integer>();
//        ArrayList <String>stringTypeList = new ArrayList<String>();
//        List <Employee>empList = new ArrayList<Employee>();

        // 3. add data
        ArrayList arrayList = new ArrayList();

        arrayList.add(100);
        arrayList.add("Suman");
        arrayList.add('A');
        arrayList.add(10.6);
        arrayList.add(100);
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(false);

        // 4. SIZE
        System.out.println("Size: "+ arrayList.size()); // 8
// 5. print LIST
        System.out.println("Array list: " + arrayList); // [100, Suman, A, 10.6, 100, null, null, false]
// 6. remove element
        arrayList.remove(4); // index
        System.out.println("Array list: " + arrayList); // [100, Suman, A, 10.6, null, null, false]
// 7. replace -> modify element
        arrayList.set(2, 'C');
        System.out.println("Array list: " + arrayList); // [100, Suman, C, 10.6, null, null, false]
// 8. Insert data -> not replace data
        arrayList.add(0, 999);
        System.out.println("Array list: " + arrayList); // [999, 100, Suman, C, 10.6, null, null, false]
// 9. access specific elemet
        System.out.println (arrayList.get(4)); // 10.6
        // 10. Get list value one by one

        // A. using for loop
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        // B. using for......each loop
        for(Object ele: arrayList){
            System.out.println(ele);
        }
        // C. Iterator class
        Iterator it = arrayList.iterator(); // create iterator variable as 'it' not object.

        while (it.hasNext()){
            System.out.println(it.next()); //
        }
//        System.out.println("Value without while loop: "+ it.next()); // 999
// 11. array list empty or not
//        System.out.println(arrayList.isEmpty()); // true

        // 12. remove all the elements from array list
ArrayList myList2 = new ArrayList();
myList2.add(10.6);
myList2.add(null);
myList2.add('C');

System.out.println("myList2: "+ myList2);

arrayList.removeAll(myList2);
System.out.println("After remove multiple elements: "+arrayList);
        // using clear
        arrayList.clear();
        System.out.println("Empty array list using clear: "+ arrayList);





    }

}

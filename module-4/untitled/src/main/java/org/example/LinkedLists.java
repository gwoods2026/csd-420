//Garrett Woods Module 4
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {

    //Calls the test and displays the results
    public static void main(String[] args) {
        System.out.println("50,000 Integer test");
        timeCheck(50000);

        System.out.println("500,000 Integer test");
        timeCheck(500000);
    }
    public static void timeCheck(int size) {

        //creates the Iterator test
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();
        long iteratorSum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        //finds the time it took
        long endTime = System.nanoTime();
        double iteratorTime = (endTime - startTime) / 1_000_000.0;
        System.out.printf("Iterator time: %.2f ms%n", iteratorTime);

        //creates the index test
        startTime = System.nanoTime();
        long getSum = 0;
        for (int i = 0; i < size; i++) {
            getSum += list.get(i);
        }

        //find the time it took
        endTime = System.nanoTime();
        double getDuration = (endTime - startTime) / 1_000_000.0;
        System.out.printf("get(index) time: %.2f ms%n", getDuration);

    }
}

//The get index took so long for the 500,000 one that I went back and doublechecked my code to see why it wasn't displaying
//Since the Iterator can keep its place in the list  it cuts time down by an amazing amount.
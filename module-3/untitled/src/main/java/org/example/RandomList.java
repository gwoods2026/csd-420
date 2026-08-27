// Garrett Woods Module 3.2
package org.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomList {

    //removes duplicates
    public static <E> ArrayList<E> uniqueArray(ArrayList<E> list) {
        HashSet<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        //Creates array with 50 random numbers
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int randomNumber = random.nextInt(20) + 1;
            originalList.add(randomNumber);
        }

        //shows unedited list
        System.out.println("Original List: ");
        System.out.println(originalList);
        System.out.println();

        ArrayList<Integer> uniqueList = uniqueArray(originalList);

        //shows unique values
        System.out.println("Unique List: ");
        System.out.println(uniqueList);
    }
}

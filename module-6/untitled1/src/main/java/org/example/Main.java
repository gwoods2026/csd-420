//Garrett Woods Module 6

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    //Comparable Sort
    public static <E extends Comparable<E>> void bubbleSort(E[] values) {
        E temp;

        //checks values and swaps position if needed
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < values.length - 1; ++j) {
                if (values[j].compareTo(values[j + 1]) > 0) {
                    temp = values[j];
                    values[j] = values [j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    //Comparator Sort
    public static <E> void bubbleSort(E[] values, Comparator<? super E> comparator) {
    E temp;

    //checks values and swaps position if needed
    for (int i = 0; i < values.length; ++i) {
        for (int j = 0; j < values.length - 1; ++j) {
                if (comparator.compare(values[j], values[j + 1]) > 0) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        //sets up arrays and displays unsorted arrays
        Integer[] intArray = {2, 6, 3, 7, 4, 5, 9};
        System.out.println("Original Array: " + Arrays.toString(intArray));


        //sorts arrays and displays it
        bubbleSort(intArray);
        System.out.println("Sorted Array: " + Arrays.toString(intArray));
        System.out.println();


        //sets up arrays displays unsorted arrays
        String[] stringArray = {"Phone", "CD", "Glasses", "Bottle", "Game", "Laptop"};
        System.out.println("Original Array: " + Arrays.toString(stringArray));


        //sorts array and displays it
        bubbleSort(stringArray, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted Array: " + Arrays.toString(stringArray));
    }
}
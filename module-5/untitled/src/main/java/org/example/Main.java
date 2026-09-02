//Garrett Woods Module 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    //gets the text file
    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";
        TreeSet<String> uniqueWords = new TreeSet<>();

        //formats words to make them all the same
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                if(!word.isEmpty()) {
                    uniqueWords.add(word);
                }
            }

        //error if unable to find the text file
        } catch (FileNotFoundException e) {
            System.out.println("The file, " + fileName + ", was not found.");
            return;
        }

        //displays list in Ascending Order
        System.out.println("\nAscending Order: ");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        //displays the list in Descending order
        System.out.println("\nDescending Order: ");
        for (String word : uniqueWords.descendingSet()) {
            System.out.println(word);
        }
    }
}
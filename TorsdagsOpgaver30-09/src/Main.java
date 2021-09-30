import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");                    // Creates and array of strings, where each element is a single word from the file.
        //System.out.println(text.length);

       // printWordsStartingWith("Ø");

       // printWordsOfLength(3);

       // printLongestWord();

        //printFirstHalfOfEachWord();

        //printMostFrequentLetter();

        printLessFrequentLetter();




        //test dine metoder ved at kalde dem her:


    }

    private static void printLessFrequentLetter() {
        ArrayList<Character> bogstav = new ArrayList<>();

        for(int i = 0; i < text.length; i++) {
            String ord = text[i].toLowerCase();


            for(int j = 0; j < ord.length(); j++){
                bogstav.add(ord.charAt(j));
            }
        }
        char[] alfabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','æ','ø','å'};
        char current;
        char leastFrequentChar = alfabet[0];
        int currentFreq;
        int lowestFreq = Collections.frequency(bogstav, alfabet[0]);
        for( int i = 0; i < alfabet.length; i++) {
            current = alfabet[i];
            currentFreq = Collections.frequency(bogstav, current);
            System.out.println("Så mange gange er det et "+alfabet[i]+ ": " + Collections.frequency(bogstav, current));
            if(currentFreq <= lowestFreq) {
                lowestFreq = currentFreq;
                leastFrequentChar = current;
            }

        }System.out.println("Her er alle de mindst benyttede bogstaver: ");

        for( int j = 0; j < alfabet.length; j++) {
            int tmp = Collections.frequency(bogstav, alfabet[j]);
            if(tmp == lowestFreq){
                System.out.println(alfabet[j] + ": 0 gange :)");
            }
        }

    }

    private static void printMostFrequentLetter() {

ArrayList<Character> bogstav = new ArrayList<>();

        for(int i = 0; i < text.length; i++) {
            String ord = text[i].toLowerCase();


            for(int j = 0; j < ord.length(); j++){
                bogstav.add(ord.charAt(j));
            }
        }
        char[] alfabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','æ','ø','å'};
        char mostFrequentChar = 0;
        char current;
        int currentFreq;
        int highestFreq = 0;
        for( int i = 0; i < alfabet.length; i++) {
            current = alfabet[i];
            currentFreq = Collections.frequency(bogstav, current);
            System.out.println("Så mange gange er det et "+alfabet[i]+ ": " + Collections.frequency(bogstav, current));
            if(currentFreq > highestFreq) {
                highestFreq = currentFreq;
                mostFrequentChar = current;
            }

        }
        System.out.println("Det mest brugte bogstav er derfor: "+mostFrequentChar+" da den fremtræder "+highestFreq+" gange :)");

    }

    private static void printFirstHalfOfEachWord() {

        for(int i = 0; i < text.length; i++) {
            System.out.println(text[i].substring(0,text[i].length()/2)); // Bruger substring til at printe første halvdel af hvert ord.
        }
    }

    private static void printLongestWord() {
        String longestWord = ""; // Det længste ord ind til videre i loopet
        String current; // Det ord vi er nået til i loopet

        for(int i = 0; i < text.length; i++) {
           current = text[i];
           if(current.length() > longestWord.length()){ // Den går igennem alle ord og finder det længste.
               longestWord = current;
           }
        }
        System.out.println("Dette er det længste ord: " +longestWord);
    }

    private static void printWordsOfLength(int l)
    {
        boolean wordisvalid = true;

        for (String s : text)
        {
            if (s.length() == l)
            {
                if (s.contains(",") || s.contains("."))
                {
                    wordisvalid = false;
                }

                if (wordisvalid)
                {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern)
    {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase()))
            {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:


}

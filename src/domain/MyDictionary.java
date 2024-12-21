package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyDictionary {

    public static String PATH =  "src\\Dict.txt";
    public static final ArrayList<String> DICTIONARY = new ArrayList<>();

    public static void buildTSTFromFile(TernarySearchTrie tst, String filepath)  {
        try {
            File file = new File(filepath);
            Scanner reader = new Scanner(file);

            while(reader.hasNext()) {
                String word = reader.next();
                DICTIONARY.add(word);
                tst.put(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public  static int getSize() {
        //returns size of Dictionary(List of words in file)
        return DICTIONARY.size();
    }

    public static String getIndex(int index) {
        //returns the string at an index
        return DICTIONARY.get(index);
    }
}

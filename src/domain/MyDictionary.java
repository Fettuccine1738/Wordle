package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyDictionary {

    private final ArrayList<String> wordList;

    public MyDictionary () {
        wordList = populateFromFile();
    }

    public ArrayList<String> populateFromFile()  {
        String filePath =  "C:\\Users\\favya\\IdeaProjects\\Wordle\\src\\Dictionary.txt";
        ArrayList<String> imports = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);


            while(reader.hasNext()) {
                String word = reader.next();
                //ensures word is always in upper case when read from file.
                String trimmedUpperCaseWord = word.trim().toUpperCase();
                imports.add(trimmedUpperCaseWord);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return imports;
    }

    public int getSize() {
        //returns size of Dictionary(List of words in file)
        return wordList.size();
    }

    public String getIndex(int index) {
        //returns the string at an index
        return wordList.get(index);
    }
}

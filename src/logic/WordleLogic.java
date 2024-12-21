package logic;
import domain.*;

import java.util.Random;

public class WordleLogic {
    public StringBuilder builder;
    public StringBuilder stringBuilder;
    private final String wordOfTheDay;
    private final Random rand;
    private static final TernarySearchTrie trie = new TernarySearchTrie();


    static {
        MyDictionary.buildTSTFromFile(trie, MyDictionary.PATH);
    }

    public WordleLogic() {
        stringBuilder = new StringBuilder("\n");
        rand = new Random();
        wordOfTheDay = getWordOfTheDay();
        builder = new StringBuilder("LETTERS NOT IN WORD: #");
    }

    public String getWordOfTheDay() {
        //returns a random int as (index) to get word from the arraylist
        int random = rand.nextInt(MyDictionary.getSize());
        return MyDictionary.getIndex(random);
    }

    /*logic to check words and indexes: Players have six attempts to guess a five-letter word,
     with feedback given for each guess in the form of colored tiles indicating when letters match or
      occupy the correct position.
      After every guess, each letter is marked as either green, yellow or gray:
      green indicates that the letter is correct and in the correct position,
      yellow means it is in the answer but not in the right position,
      while gray indicates it is not in the answer at all.
     */
    public boolean checkWord(String word) {
        String otherWord = word.toUpperCase();
        return otherWord.equals(wordOfTheDay);
    }

    /**
     * @param word to be validated
     * @return true if word is valid in the ENGLISH lexicon
     */
    public static boolean validateWord(String word) {
        return trie.search(word);
    }

    public String matchIndex(String input) {
        //checks for letters that appear in words but at the wrong index
        // arraylist is used to use List interface' indexOf method
        char[] inputArray = input.toCharArray();
        char[] charsOfTheDay = wordOfTheDay.toCharArray();

        for (int m = 0; m < input.length(); m++) {
            int index = wordOfTheDay.indexOf(input.charAt(m));
            if (index == -1) {
                sanitizeBuilder(input.charAt(m));
            }else {
                // check for second occurence of character
                int index2 = wordOfTheDay.lastIndexOf(input.charAt(m));
                if (index2 != index) { // if second occurence exist, check if we indexes are equal
                    if (m == index) stringBuilder.append(input.charAt(m)).append(" ").append(rightIndexInWord());
                    else if (m == index2) stringBuilder.append(input.charAt(m)).append(" ").append(rightIndexInWord());
                    else stringBuilder.append(input.charAt(m)).append(" ").append(wrongIndexInWord());
                } else {
                    if (m == index) stringBuilder.append(input.charAt(m)).append(" ").append(rightIndexInWord());
                    else stringBuilder.append(input.charAt(m)).append(" ").append(wrongIndexInWord());
                }
            }

        }
        return stringBuilder.toString();
    }

    private String rightIndexInWord() {
        return  " is in the correct position. \n";
    }

    private String wrongIndexInWord() {
        return " is in word but not in the correct position. \n";
    }


    public String getWord() {
        return  wordOfTheDay;
    }

    // gurantees chars not in the word are not repeated
    public void sanitizeBuilder(char s) {
        String newString = builder.toString();
        String[] sanitizedString = newString.split(": ");

        if (sanitizedString.length > 1) {
            char[] characters = sanitizedString[1].toCharArray();
            boolean exists = false;

            //for loop to iterate through all characters
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == s) {
                    exists = true;
                    break;
                }
            }
            if (!exists) builder.append(s).append(" ");
        }

    }

    //It is called by the method in user interface message after every full iteration,
    public void clearString() {
        stringBuilder.delete(0,stringBuilder.length()-1);
    }
}

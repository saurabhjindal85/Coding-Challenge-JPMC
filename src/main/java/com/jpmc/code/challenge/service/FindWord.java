package com.jpmc.code.challenge.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindWord {
    String statement;
    String character;
    public FindWord(String statement , String character){
        this.character = character;
        this.statement = statement;
    }

    /**
     *Method return word having the most occurrence of the search Character
     *
     * example
     * Statement : To change the font size, right-click a Javadoc in the editor and select Adjust Font Size from the context menu. Note that the rendered comments use the same font size as the quick documentation popup.
     * character : a
     * return : Javadoc
     *
     *
     * @return
     */
    public String checkForCharacterInStmt(){
        String outputString  = Arrays.stream(this.statement.split(" "))
                .filter(w -> w.contains(String.valueOf(this.character)))
                .reduce("", (intermediate, newWord)-> checkForCharacterInStmt(intermediate, newWord));
        if(outputString == "")
            outputString = "Search character is not present in Statement.";
        return outputString;
    }

    /**
     *Method responsible for checking the occurrence of search character in each word
     * compare it existing finding and returns the compared result
     *
     * @param intermediate
     * @param newWord
     * @return
     */

    private String checkForCharacterInStmt(String intermediate, String newWord){
        String output = intermediate;
        Long occInIntermediate = Arrays.stream(intermediate.split(""))
                .filter(s-> s.equals(String.valueOf(character)))
                .collect(Collectors.counting());
        Long occInNewWord = Arrays.stream(newWord.split(""))
                .filter(s-> s.equals(String.valueOf(character)))
                .collect(Collectors.counting());

        if(occInNewWord > occInIntermediate)
            output = newWord;
        return output;
    }
}

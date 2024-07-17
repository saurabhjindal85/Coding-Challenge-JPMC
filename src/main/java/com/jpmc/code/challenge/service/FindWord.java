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
     *Method return word having the most occurence of the search Character
     *
     * @return
     */
    public String checkForCharacterInStmt(){
        String outputString  = Arrays.stream(this.statement.split(" "))
                .filter(w -> w.contains(String.valueOf(this.character)))
                .reduce("", (intermediate, newWord)-> checkForCharacterInStmt(intermediate, newWord));
        return outputString;
    }

    /**
     *Method responible for checking the occurence of search character in each word
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

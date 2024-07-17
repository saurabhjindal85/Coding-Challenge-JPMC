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
    public String checkForCharacterInStmt(){
        String outputString  = Arrays.stream(this.statement.split(" "))
                .filter(w -> w.contains(String.valueOf(this.character)))
                .reduce("", (intermediate, newWord)-> checkForCharacterInStmt(intermediate, newWord));
        return null;
    }

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

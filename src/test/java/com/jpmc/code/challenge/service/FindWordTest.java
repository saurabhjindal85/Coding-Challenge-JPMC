package com.jpmc.code.challenge.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindWordTest {

    @Test
    void testCheckForCharacterInStmt() {
        FindWord findWord = new FindWord("To change the font size, right-click a Javadoc in the editor " +
                "and select Adjust Font Size from the context menu. Note that the rendered comments use the same font size as the quick documentation popup.",
                "a");
        String output  = findWord.checkForCharacterInStmt();
        assertEquals("Javadoc", output);
    }

    @Test
    void testcheckForCharacterNotInStmt() {
        //test to check when character is not in String
        FindWord findWord = new FindWord("To change the font size, right-click a Javadoc in the editor " +
                "and select Adjust Font Size from the context menu. Note that the rendered comments use the same font size as the quick documentation popup.",
                "?");
        String output  = findWord.checkForCharacterInStmt();
        assertEquals("Search character is not present in Statement.", output);
    }
}
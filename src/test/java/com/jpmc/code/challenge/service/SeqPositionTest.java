package com.jpmc.code.challenge.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeqPositionTest {

    @Test
    void findSeqPositionForInputEqualTo0() {

        SeqPosition seqPosition = new SeqPosition(0);
        int output = seqPosition.findSeqPosition();
        assertEquals(0, output);
    }

    @Test
    void findSeqPositionForInputGreaterThan0() {

        SeqPosition seqPosition = new SeqPosition(88);//input 1
        int output = seqPosition.findSeqPosition();
        assertEquals(3, output);
        seqPosition = new SeqPosition(156);//input 2
        output = seqPosition.findSeqPosition();
        assertEquals(4, output);
        seqPosition = new SeqPosition(99);//input 3
        output = seqPosition.findSeqPosition();
        assertEquals(1, output);
    }
}
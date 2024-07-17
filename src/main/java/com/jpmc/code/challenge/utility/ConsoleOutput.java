package com.jpmc.code.challenge.utility;

public interface ConsoleOutput {
    static  void printOnConsole(String message){
        System.out.println(message);
    }

    static  void printMain(){
        System.out.println("Welcome to the main menu");
        System.out.println("Please select 1 0r 2 for executing solution");
        System.out.println("1. Find the word which contains the most number of the character");
        System.out.println("2. Returns the starting position of the longest continuous Seq of 1s in its binary format");
    }


    static  void printFor1(){
        System.out.println("Input statment for finding character.");
    }


    static  void printForEnterCharactToSearch(){
        System.out.println("Input Character to be search for.");
    }

    static  void printFor2(){
        System.out.println("Input  a number.");
    }


    static  void printStartOverMenu(){
        System.out.println("Please choose from the following options.");
        System.out.println("1. Start Over");
        System.out.println("2. Exit");
    }
}

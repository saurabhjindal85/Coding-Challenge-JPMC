package com.jpmc.code.challenge;

import com.jpmc.code.challenge.service.FindWord;
import com.jpmc.code.challenge.service.SeqPosition;
import com.jpmc.code.challenge.utility.ConsoleOutput;
import org.apache.commons.lang3.StringUtils;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws  Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start_Or_exit = 1;
        while(1 == start_Or_exit){
            int option = numericInput(reader);
            if(1 == option){
                ConsoleOutput.printFor1();
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(System.in);
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if(line.isEmpty()){
                        break;
                    }
                    sb.append(line).append("\n");
                }
                sb.deleteCharAt(sb.length() -1 );
                String stmt = sb.toString();
                ConsoleOutput.printForEnterCharactToSearch();
                String searchChar = scanner.next();
                FindWord findWord = new FindWord( stmt, searchChar);

                String outputString = findWord.checkForCharacterInStmt();
                System.out.println(outputString);

            }

            if(2 == option){
                Scanner scanner = new Scanner(System.in);
                ConsoleOutput.printFor2();
                String number = scanner.next();
                SeqPosition seqPosition = new SeqPosition(Integer.valueOf(number));
                int output = seqPosition.findSeqPosition();
                System.out.println(output);
            }
            start_Or_exit = enterStartOverOrExitCommand(reader);
        }
        if(start_Or_exit == 2 )
            ConsoleOutput.printOnConsole("Thank you for simulation. GoodBye!");

    }

    public static int numericInput(BufferedReader reader) throws Exception{
        ConsoleOutput.printMain();

        String option = reader.readLine();
        String validateOption = validateInput(option);
        while(StringUtils.isNotEmpty(validateOption)){
            ConsoleOutput.printOnConsole(validateOption);
            ConsoleOutput.printMain();
            option = reader.readLine();
            validateOption = validateInput(option);
        }
        return Integer.valueOf(option).intValue();
    }

    private static String validateInput(String option) {
        String message = null;
        try{
            List<String> optionList = Arrays.asList("1", "2");
            if(!optionList.contains(option))
                throw new RuntimeException("Please choose option between 1 and 2.");

        }catch (RuntimeException ex){
            message = ex.getMessage();
        }
        return message;
    }

    public static int enterStartOverOrExitCommand(BufferedReader reader) throws  Exception {
        ConsoleOutput.printStartOverMenu();
        String option = reader.readLine();
        String validateOption = validateInput(option);
        while(StringUtils.isNotEmpty(validateOption)){
            ConsoleOutput.printOnConsole(validateOption);
            ConsoleOutput.printStartOverMenu();
            option = reader.readLine();
            validateOption = validateInput(option);
        }
        return Integer.valueOf(option).intValue();
    }
}

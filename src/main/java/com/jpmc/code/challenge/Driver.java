package com.jpmc.code.challenge;

import com.jpmc.code.challenge.service.FindWord;
import com.jpmc.code.challenge.service.SeqPosition;
import com.jpmc.code.challenge.utility.ConsoleOutput;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

    /**
     * Driver class of the program, run example is as below
     *
     * Example
     *Welcome to the main menu
     * Please select 1 0r 2 for executing solution
     * 1. Find the word which contains the most number of the character
     * 2. Returns the starting position of the longest continuous Seq of 1s in its binary format
     * 1
     * Input statment for finding character.
     * To change the font size, right-click a Javadoc in the editor and select Adjust Font Size from the context menu. Note that the rendered comments use the same font size as the quick documentation popup.
     *
     * Input Character to be search for.
     *
     * Please enter a character to search for in the statment
     * Input Character to be search for.
     * .
     * menu.
     * Please choose from the following options.
     * 1. Start Over
     * 2. Exit
     * 2
     * Thank you for simulation. GoodBye!
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start_Or_exit = 1;
        while(1 == start_Or_exit){
            int option = numericInput(reader);
            if (1 == option) {
                String stmt = acceptAndValidateInputFor1();
                String searchChar = acceptSearchCharacterFor1();
                FindWord findWord = new FindWord(stmt, searchChar);
                String outputString = findWord.checkForCharacterInStmt();
                System.out.println(outputString);
            }

            if(2 == option){
                int userInputNumber = acceptUserInputAndValidateFor2();
                SeqPosition seqPosition = new SeqPosition(userInputNumber);
                int output = seqPosition.findSeqPosition();
                System.out.println(output);
            }
            start_Or_exit = enterStartOverOrExitCommand(reader);
        }
        if(start_Or_exit == 2 )
            ConsoleOutput.printOnConsole("Thank you for simulation. GoodBye!");

    }


    /**
     * Accept user input for search the Character
     * Validate to be a single character and not empty String
     * Empty Character shows error Message "Please enter a character to search for in the statment"
     *
     * @return
     */
    public static String acceptSearchCharacterFor1() {
        Scanner scanner = new Scanner(System.in);
        ConsoleOutput.printForEnterCharactToSearch();
        String input = scanner.nextLine();
        String validateMessage = null;
        if (StringUtils.isEmpty(input)){
            validateMessage = "Please enter a character to search for in the statment";
        }
        while(StringUtils.isNotEmpty(validateMessage)){
            ConsoleOutput.printOnConsole(validateMessage);
            ConsoleOutput.printForEnterCharactToSearch();
            input = scanner.nextLine();
            if (StringUtils.isEmpty(input)){
                validateMessage = "Please enter a character to search for in the statment";
            }else
                validateMessage = null;
        }
        return input;
    }

    /**
     * Accept user input for the statement
     * Empty statement return Error "Empty statment. Pleaser retry"
     *
     *
     * @return
     */
    private static String acceptAndValidateInputFor1(){
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
        String validateMessage = null;
        if(StringUtils.isEmpty(sb.toString())){
            validateMessage = "Empty statment. Pleaser retry";
        }
        while(StringUtils.isNotEmpty(validateMessage)){
            ConsoleOutput.printOnConsole(validateMessage);
            ConsoleOutput.printFor1();
            sb = new StringBuilder();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    break;
                }
                sb.append(line).append("\n");
            }
            if(StringUtils.isEmpty(sb.toString())){
                validateMessage = "Please enter a number greater than 0.";
            }else{
                validateMessage = null;
            }
        }
        sb.deleteCharAt(sb.length() -1 );
        return sb.toString();
    }
    /**
     * Takes Reader as input
     * Reads user input and validate it to be as numeric 1 or 2
     * if not 1 or 2 user will be asked to input right choice
     * expect user to choose one of the belwo
     * ("1. Find the word which contains the most number of the character");
     * ("2. Returns the starting position of the longest continuous Seq of 1s in its binary format")
     *
     * @param reader
     * @return
     * @throws Exception
     */
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

    /**
     * Method Accept user input number for Option 2
     * Validate user input
     * if user input is <= 0 then user will be advised to input value > 0
     *
     *
     * @param
     * @return
     * @throws Exception
     */
    public static int acceptUserInputAndValidateFor2() {
        Scanner scanner = new Scanner(System.in);
        ConsoleOutput.printFor2();
        String input = scanner.next();
        Integer num = Integer.valueOf(input);
        String validateMessage = null;
        if(num <= 0){
            validateMessage = "Please enter a number greater than 0.";
        }
        while (StringUtils.isNotEmpty(validateMessage)){
            ConsoleOutput.printOnConsole(validateMessage);
            ConsoleOutput.printFor2();
            input = scanner.next();
            num = Integer.valueOf(input);
            if(num <= 0){
                validateMessage = "Please enter a number greater than 0.";
            }else
                validateMessage= null;
        }
        return Integer.valueOf(input).intValue();
    }


    /**
     * Takes string input and validate it against accepted value of 1 or 2
     * if not 1 or return error message "Please choose option between 1 and 2."
     *
     * @param option
     * @return
     */
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

    /**
     * Takes Reader as input
     * Checks for the user input for
     * ("1. Start Over")
     * ("2. Exit");
     *
     * @param reader
     * @return
     * @throws Exception
     */
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

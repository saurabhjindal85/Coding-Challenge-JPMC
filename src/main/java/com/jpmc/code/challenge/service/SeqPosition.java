package com.jpmc.code.challenge.service;

import java.util.*;
import java.util.stream.Collectors;

public class SeqPosition {
    int num;
    public SeqPosition(int num){
        this.num = num;
    }

    /**
     * Method return position of Sequence of 1s in Binary format of user input number.
     * First we convert user input into Binary format.
     * using the Binary digits find the required position
     * if number <= 0 return 0
     * else return the starting position of the 1s in binary format.
     *
     * example
     * num = 0 return 0
     * num = 88 return 3
     * num = 156 return 4
     * @return
     */
    public int findSeqPosition(){
        int output = 0;
        List<String> remainderList = getBinaryConversion();
        if(remainderList.size() > 0 ){
            int len=0;
            int posi=-1;
            Map<Integer, List<String>> lengthAndPos = new HashMap<>();
            for(int i=0 ; i< remainderList.size()-1; i++){
                if(!"0".equals(remainderList.get(i))){
                    if(posi <0 ){
                        posi = i;
                    }
                    len++;
                }else{
                    if(lengthAndPos.containsKey(len)) {
                        List<String> posiList = new ArrayList<>();
                        posiList.add(String.valueOf(posi + 1));
                        lengthAndPos.put(len, posiList);
                    }else{
                        List<String> posiList = new ArrayList<>();
                        posiList.add(String.valueOf(posi + 1));
                        if(len != 0){
                            lengthAndPos.put(len, posiList);
                        }
                    }
                    posi = -1;
                    len = 0;
                }

            }
            List<Integer> numSet = lengthAndPos.keySet().stream().collect(Collectors.toList());
            Collections.sort(numSet, Collections.reverseOrder());
            String temp = lengthAndPos.get(numSet.get(0)).get(0);
            output = Integer.valueOf(temp).intValue();
        }
        return output;
    }

    /**
     * Method is used convert the user provided input number into binary digits
     * example 16 will be converted to 10000
     * @return
     */
    private List<String> getBinaryConversion(){
        List<String> remainderList = new ArrayList();
        int quotient = num;
        if (quotient != 0){
            while(quotient != 0){
                int r = quotient%2;
                int quo = quotient/2;
                quotient = quo;
                remainderList.add(String.valueOf(r));
            }
        }
        Collections.reverse(remainderList);
        return remainderList;
    }
}

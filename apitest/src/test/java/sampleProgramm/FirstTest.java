package sampleProgramm;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FirstTest {

    /***
     Add the array elements in set
     take 1 as smallest positive number
     check if set contains the smallest number or else increase it by +1
     and repeat with while block

     */
    @Test
    public void smallestPositiveMissingNumber() {
        int[] array = {3, -1, 1, 0, 5, 9, -2, 2};

        int missingNumber = findSmallestPositiveMissingNumber(array);


        System.out.println("The smallest positive missing number is: " + missingNumber);
    }


    public static int findSmallestPositiveMissingNumber(int[] array) {

        Set<Integer> distinctSet = Arrays.stream(array).boxed().collect(Collectors.toSet());
        int smallestNum = 1;
        while (true) {
            if (!distinctSet.contains(smallestNum)) {
                break;
            }
            smallestNum++;
        }
        return smallestNum;
    }


    @Test
    public void findSumOfDigitFromString() {

        String str = "ab2ch12lk15otu3";

        String temp = "0";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                temp = temp + ch;
            else {
                sum = sum + Integer.parseInt(temp);
                temp = "0";
            }
        }
        sum = sum + Integer.parseInt(temp);
        System.out.println("sum of total digits from the String is : " + sum);
    }


    @Test
    public void generatePermutation() {

        String str = "abc";
        findPermutation(str, "");
    }

    public static void findPermutation(String str, String permutation) {

        if (str.isEmpty()) {
            System.out.println(permutation);
            return;
        }


        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String remainingString = str.substring(0, i) + str.substring(i + 1);
            String result = permutation + currentChar;

            findPermutation(remainingString, result);

        }

    }


    @Test
    public void findFrequency() {


        int[] arr = {10, 20, 30, 40, 50,10,20,19,10,20};
        HashMap<Integer, Integer> distinct = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!distinct.containsKey(arr[i]))
                distinct.put(arr[i], 1);

            else
                distinct.put(arr[i], distinct.get(arr[i]) + 1);

        }

        for(Map.Entry<Integer,Integer> entry : distinct.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


}

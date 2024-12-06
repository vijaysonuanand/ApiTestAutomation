package sampleProgramm;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FirstTest {

    @Test
    public void smallestPositiveMissingNumber() {
        int[] array = {3, -1,1,  0, 5, 9, -2, 2};

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
    public void findSumOfDigitFromString(){

        String str = "ab2ch12lk15otu3";

        String temp ="0";
        int sum =0;

        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);
            if(Character.isDigit(ch))
                temp= temp+ch;
            else {
                sum = sum + Integer.parseInt(temp);
                temp = "0";
            }
        }
        sum = sum + Integer.parseInt(temp);
        System.out.println("sum of total digits from the String is : "+ sum);
    }

}

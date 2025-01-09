package sampleProgramm;

import com.sun.codemodel.JForEach;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Basics {

    /***
     Add the array elements in set
     take 1 as smallest positive number
     check if set contains the smallest number or else increase it by +1
     and repeat with while block

     */
    @Test
    public void IterateOverMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ram");
        map.put(2, "shyam");
        map.put(1, "meera");
        map.put(4, "SIta");
        map.put(3, "krishna");

        map.forEach((k, v) -> System.out.printf("Key is : " + k + " value is : " + v + "\n"));

        for (Map.Entry<Integer, String> mp : map.entrySet()) {
            System.out.printf("Key is : " + mp.getKey() + " value is : " + mp.getValue() + "\n");
        }
    }

    @Test
    public void permutation() {
        String str = "abc";
        String result = "";
        findPermutation(str, result);

    }


    private void findPermutation(String str, String result) {

        if (str.isEmpty()) {
            System.out.println(" permutations are : " + result);
        }
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1);
            String newResult = result + ch;
            findPermutation(remainingStr, newResult);
        }
    }



}

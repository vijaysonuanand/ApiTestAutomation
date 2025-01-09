package sampleProgramm;

import Pojo.User;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleProgramms {

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


        int[] arr = {10, 20, 30, 40, 50, 10, 20, 19, 10, 20};
        HashMap<Integer, Integer> distinct = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            distinct.put(arr[i], distinct.getOrDefault(arr[i],0)+1);
            /*if (!distinct.containsKey(arr[i]))
                distinct.put(arr[i], 1);
            else
                distinct.put(arr[i], distinct.get(arr[i]) + 1);*/
        }

        for (Map.Entry<Integer, Integer> entry : distinct.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    @Test
    public void findFirstNonRepeatedChar() {
        String str = "askdjhkurskjdbbuabskjundhskl";
        char ch = findNonRepeatedCharUsingMap(str);
        char ch1 = findNonRepeatedChar(str);
        System.out.println(" first unique character is :" + ch);
        System.out.println("Another way first unique character is :" + ch1);
    }

    public Character findNonRepeatedChar(String str) {

        List<Character> discardList = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return 0; // Return null character if string is empty or null
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (discardList.contains(ch))
                continue;
            for (int j = i + 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    discardList.add(ch);
                    break;
                } else if (j == str.length() - 1) {
                    System.out.println("first non repeated character is : " + ch);
                    return ch;
                }
            }
        }
        return 0;
    }


    public char findNonRepeatedCharUsingMap(String str) {

        Map<Character, Integer> charCount = new LinkedHashMap<>();

        if (str == null || str.isEmpty()) {
            return 0; // Return null character if string is empty or null
        }

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        //System.out.println("All char counts are " + charCount);
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Test
    public void sorting() {

        /*List<String> list = Arrays.asList("Ab", "s", "h", "c", "p");

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        List<String> sortedList1 = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        sortedList1.forEach(System.out::println);
        List<String> sortedList2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortedList2.forEach(System.out::println);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(System.out::println);*/

        List<User> userList = Arrays.asList(new User(1, "Ram"),
                new User(2, "zjjdh"),
                new User(5, "Geeta"),
                new User(4, "Yaksjj")
        );

        List<User> sortedUserList = userList.stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());
        sortedUserList.forEach(user -> {
            System.out.println(user.getName());
        });
    }

    @Test
    public void firstNonRepeatedChar() {

        String str = "tester";

        for (char ch : str.toCharArray()) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                System.out.println("first non repeated char is :" + ch);
                break;
            }
        }
    }


    @Test
    public void findLongestSubstringLength() {

        String str = "abcabcbb";

        int left = 0, maxlength = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (seen.contains(ch)) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            maxlength = Math.max(maxlength, right - left + 1);

        }
        System.out.println("longest non repeated subsrting length is " + maxlength);
    }


    @Test
    public void alternateCharFromString() {
        String str = "ThisisNewString";
        StringBuilder result = new StringBuilder(str.length() + 1);
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                result.append(str.charAt(i));
            }
        }
        System.out.println(result);
    }

    @Test
    public void countOfPermutations() {

        String str = "abc";
        HashSet<String> permutationSet = findNewPermutation(str);
        System.out.println("Total number of permutations generated is : " + permutationSet.size() + " \n" + permutationSet);

    }

    public HashSet<String> findNewPermutation(String str) {

        HashSet<String> permutation = new HashSet<>();

        if (str.isEmpty()) {
            permutation.add("");
            return permutation;
        }
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1);
            HashSet<String> subPermutation = findNewPermutation(remainingStr);
            for (String subPerm : subPermutation) {
                permutation.add(subPerm + ch);
            }
        }
        return permutation;
    }

}

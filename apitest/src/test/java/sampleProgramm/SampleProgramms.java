package sampleProgramm;

import Pojo.User;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
            distinct.put(arr[i], distinct.getOrDefault(arr[i], 0) + 1);
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

        List<String> list = Arrays.asList("Ab", "s", "h", "c", "p");

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        List<String> sortedList1 = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        sortedList1.forEach(System.out::println);
        List<String> sortedList2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortedList2.forEach(System.out::println);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(System.out::println);

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


    @Test
    public void removeDuplicateFromArray() {
        int[] arr = {1, 2, 3, 1, 2, 4, 2, 3, 4, 2,};
        ArrayList<Integer> seen = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (seen.contains(x))
                continue;
            else {
                result.add(x);
                seen.add(x);
            }

        }
        result.stream().forEach(System.out::println);

    }

    @Test
    public void diamondStar() {

        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 1; j--) {
                System.out.printf(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(" ");
            }
            for (int k = n - i; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    @Test
    public void denseDiamondStar() {

        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 1; j--) {
                System.out.printf(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(" ");
            }
            for (int k = 2 * (n - i) - 1; k >= 1; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    @Test
    public void hollowPyramid() {
        int n = 5; // Number of rows

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            // Print stars and spaces to form the hollow part
            for (int k = 1; k <= (2 * i - 1); k++) {
                if (k == 1 || k == (2 * i - 1) || i == n) {
                    System.out.print("*"); // Print stars at the boundary
                } else {
                    System.out.print(" "); // Print spaces in the middle
                }
            }

            // Move to the next line
            System.out.println();
        }
    }

    @Test
    public void palindrome() {
        String str = "madamsir";
        boolean result = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                result = false;
                break;
            }
        }
        if (result)
            System.out.println("String " + str + " is palindrome");
        else
            System.out.println("String " + str + " is not palindrome");
    }

    @Test
    public void LinkedListTest() {
        LinkedList list = new LinkedList();

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);

        // Display the list
        System.out.println("Linked List:");
        list.forEach(x -> System.out.println(x));

        // Delete a node
        System.out.println("Deleting 20:");
        list.remove(1);

        // Display after deletion
        list.forEach(x -> System.out.println(x));
    }


    @Test
    public void mergeSortArray() {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        int[] mergedArray = mergeSortedArrays(array1, array2);

        // Print the merged array
        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public int[] mergeSortedArrays(int[] array1, int[] array2) {

        // Using stream API
        int[] mergedArray1 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .sorted()
                .toArray();
        //return  mergedArray1;
        //=================================================


        int length1 = array1.length;
        int length2 = array2.length;
        int[] mergedArray = new int[length1 + length2];

        int i = 0, j = 0, k = 0;

        // Merge arrays until one is exhausted
        while (i < length1 && j < length2) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Copy remaining elements from array1, if any
        while (i < length1) {
            mergedArray[k++] = array1[i++];
        }

        // Copy remaining elements from array2, if any
        while (j < length2) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
    }

    @Test
    public void findnthPrimeNumber() {
        int n = 5;
        int count = 0;
        int num = 1;
        int i;
        while (count < n) {
            num++;
            for (i = 2; i <= num; i++) {
                if (num % i == 0)
                    break;
            }
            if (i == num)
                count++;
        }
        System.out.println(n + "th prime number is :" + num);
    }

    @Test
    public void primeNumberInRange() {

        int num = 5;
        int n = 17;
        int j = 0;
        while (num < n) {

            for (j = 2; j <= num; j++) {
                if (num % j == 0)
                    break;
            }
            if (j == num)
                System.out.println(" next prime number is : " + num);
            num++;
        }
    }

    @Test
    public void reverseEachWordOfString() {
        String str = "this is main string";

        String[] arr = str.split(" ");
        String reversed = Arrays.stream(arr).map(x -> new StringBuilder(x).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(reversed);
    }

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    @Test
    public void printFibonacciSeries() {
        int n = 10;
        int first = 0;
        int second = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                System.out.println(i + " ");
            } else {
                System.out.println(first + " ");
                sum = first + second;
                first = second;
                second = sum;

            }
        }
    }

    @Test
    public void PrintFibonacciUsingRecursion() {

        int n = 10;
        int i = 0;
        while (i < n) {
            System.out.println(findNthFibonacci(i) + " ");
            i++;
        }

        int fibonacciNumber = findNthFibonacci(n);

        System.out.println(n + "th fibonacci number is : " + fibonacciNumber);
    }

    public int findNthFibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);

    }

    @Test
    public void findSumOfDigit() {
        int num = 1234;
        int sum = 0;

        while (num > 0) {

            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;

        }
        System.out.print("Sum of all the digits are : " + sum);
    }

    @Test
    public void bubbleShort(){
        //ascending
        int [] numbers = {8,1,4,2,3,5,7,-2};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1 ; j <=numbers.length - 1; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        System.out.println("sorted array is : "+ Arrays.toString(numbers));
    }

    @Test
    public void bubbleShortReverse(){
        //decending
        int [] numbers = {-5,8,1,4,2,3,5,7,-2,9};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1 ; j <=numbers.length - 1; j++) {
                if (numbers[j] > numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        System.out.println("sorted array is : "+ Arrays.toString(numbers));
    }
}



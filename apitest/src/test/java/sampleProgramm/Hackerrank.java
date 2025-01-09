package sampleProgramm;

import org.testng.annotations.Test;

import java.util.*;

public class Hackerrank {

    /* In this problem, we are managing a set of tasks and processors in a way that optimizes the total time required to complete all tasks.
     We have n processors, each with 4 cores, meaning each processor can work on up to 4 tasks simultaneously.
     We also have n * 4 tasks that need to be completed, with the stipulation that each core can only execute one task at a time.

     We are provided with two arrays: processorTime and tasks. The processorTime array tells us when each processor will become
     available to start executing tasks, with the index of the array representing each processor. The tasks array indicates the time each individual task takes to execute.

     The objective is to determine the minimum amount of time needed to finish all n * 4 tasks when they are distributed across the n processors and their cores.
     It's a scheduling problem where we must figure out an optimal assignment of tasks to processors to minimize the overall completion time.
 */
    @Test
    public void findMinimumProcessingTime() {

        List<Integer> processTimes = Arrays.asList(8, 10);
        List<Integer> tasks = Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5);

        System.out.println("Minimum processign time is : " + minProcessingTime(processTimes, tasks));
    }

    public int minProcessingTime(List<Integer> processorTimes, List<Integer> tasks) {

        Collections.sort(processorTimes);

        Collections.sort(tasks);

        int minTime = 0; // Variable to store the minimum processing time required
        int taskIndex = tasks.size() - 1; // Start from the last task (which is the largest due to sorting)

        // Iterate over each processor time
        for (int processorTime : processorTimes) {
            // If there are no more tasks to allocate, break the loop
            if (taskIndex < 0) {
                break;
            }

            // Calculate the total time for current processor by adding its ready time to the task time
            // and update minTime if this is larger than the current minTime
            minTime = Math.max(minTime, processorTime + tasks.get(taskIndex));

            // Move to the task which is 4 positions earlier in the list since there are 4 processors (0-based index)
            taskIndex -= 4;
        }

        // Return the minimum time needed to complete all tasks
        return minTime;
    }


    /*Alice and Bob are playing a game. Initially, Alice has a string word = "a".

    You are given a positive integer k.

    Now Bob will ask Alice to perform the following operation forever:

    Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
    For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

    Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

    Note that the character 'z' can be changed to 'a' in the operation.*/
    @Test
    public void findKthCharInStringGame() {
        int k = 64;
        System.out.println("find Kth Char In String Game : " + kthCharacter(k));
    }

    public char kthCharacter(int k) {
        List<Integer> word = new ArrayList<>();
        word.add(0);
        while (word.size() < k) {
            int m = word.size();
            for (int i = 0; i < m; ++i) {
                word.add((word.get(i) + 1) % 26);
            }
            System.out.println("word is : " + word);
        }
        return (char) ('a' + word.get(k - 1));
    }


    //Given an integer array nums, find the subarray with the largest sum, and return its sum.

    @Test
    public void subArrayWIthLargestSum() {

        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int sum = maxSubArray(arr);
        System.out.println(" Maximum sum of  subArray " + sum);
    }


    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int f = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            f = Math.max(f, 0) + nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }


    @Test
    public static void findMedianOfArray() {
        int arr[] = {1, 4, 3, 2, 5, 1, 6, 9};
        System.out.println("Median of the given array is : " + findMedian(arr));
    }


    public static double findMedian(int[] array) {
        Arrays.sort(array);
        int l = array.length;
        double median = 0;
        if (l % 2 != 0)
            median = array[l / 2];
        else
            median = (array[(l / 2) - 1] + array[(l / 2)]) / 2.0;
        return median;
    }

    @Test
    public void checkValidParenthesis() {
        String str = "ab{jd(d)[]h}[]l4";
        Deque<Character> stack = new ArrayDeque<>();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if(ch == '}' || ch == ')' || ch == ']') {
                if(stack.isEmpty() || !match(stack.pop(),ch)){
                    flag = false;
                    break;
                }
            }
        }

        if (flag && stack.isEmpty())
            System.out.println("String has balanced parenthesis");
        else
            System.out.println("String has unbalanced  parenthesis");

    }

    public boolean  match(char leftbracket, char rightbracket ){
       return (leftbracket == '{' && rightbracket =='}') || (leftbracket == '(' && rightbracket ==')') || (leftbracket == '[' && rightbracket ==']');

    }
}

package sampleProgramm;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {


    @Test
    public void emailPattern() {
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        String phonePattern = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,3}?\\)?[-.\\s]?[0-9]{3,4}[-.\\s]?[0-9]{3,4}$";

        // Test strings
        String[] emails = {"test@example.com", "invalid-email@com", "user.name@domain.org"};
        String[] phoneNumbers = {"+123-456-7890", "(123) 456-7890", "456-7890"};

        Pattern pattern = Pattern.compile(emailPattern);
        System.out.println("email validation");
        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " is valid ? - " + matcher.matches());
        }

        System.out.println("\nPhone Validation:");
        Pattern phoneRegex = Pattern.compile(phonePattern);
        for (String phone : phoneNumbers) {
            Matcher matcher = phoneRegex.matcher(phone);
            System.out.println(phone + " is valid? " + matcher.matches());
        }
    }

    @Test
    public void deQueue(){

        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = 6;
        int m = 3;
        int max = Integer.MIN_VALUE;
        int[] arr = {5, 3, 5, 2, 3, 2};

        for (int i = 0; i < n; i++) {

            System.out.println("enter the next input");
            int input = arr[i];

            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                 if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }

        System.out.println(max);
    }


}
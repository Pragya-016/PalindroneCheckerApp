import java.util.*;

class PalindromeChecker {

    // Encapsulated method
    public boolean checkPalindrome(String input) {

        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {

            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
// UC12: Strategy Pattern

interface PalindromeStrategy {
    boolean check(String input);
}

// Stack based strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


public class PalindromeCheckerApp {
    public static void main(String [] args){

        System.out.println("Welcome to Palindrome Checker App Management sytem");

        String input="madam";
        boolean isPalindrome=true;

        for(int i=0;i<input.length()/2;i++){
            if(input.charAt(i)!=input.charAt(input.length()-1-i)){
                isPalindrome=false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("it is a palindrome");
        }else{
            System.out.println("not a palindrome");
        }

        if(isPalindrome){
            System.out.println("it is a palindrome");
        }else{
            System.out.println("not a palindrome");
        }

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        isPalindrome = input.equals(reversed);

        System.out.println("Reversed text: " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        isPalindrome = true;

        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        // ==============================
        // UC6: FIFO vs LIFO Demonstration
        // ==============================

        System.out.println("\n--- FIFO vs LIFO Demonstration ---");

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            stack.push(input.charAt(i));
        }

        isPalindrome = true;

        while (!queue.isEmpty()) {

            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            System.out.println("Queue (FIFO): " + fromQueue +
                    " | Stack (LIFO): " + fromStack);

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Using Queue & Stack - Is Palindrome? : " + isPalindrome);

        // ************************************************7

        System.out.println("\n--- Deque (Front vs Rear) Demonstration ---");

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        isPalindrome = true;

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            System.out.println("Front: " + front + " | Rear: " + rear);

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Using Deque - Is Palindrome? : " + isPalindrome);

        //*************************************8

        System.out.println("\n--- Linked List Palindrome Check ---");

        class Node {
            char data;
            Node next;
            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head = null, tail = null;

        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("Using Singly Linked List - Is Palindrome? : " + isPalindrome);

        //***************************************9

        System.out.println("\n--- Recursive Palindrome Check ---");

        class RecursiveChecker {
            boolean check(String str, int start, int end) {

                if (start >= end) {
                    return true;
                }

                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }

                return check(str, start + 1, end - 1);
            }
        }

        RecursiveChecker rc = new RecursiveChecker();
        isPalindrome = rc.check(input, 0, input.length() - 1);

        System.out.println("Using Recursion (Call Stack) - Is Palindrome? : " + isPalindrome);

        //***************************************10
        // UC10: Case-Insensitive & Space-Ignored Palindrome

        System.out.println("\n--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");

        String text = "Madam In Eden Im Adam";

        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        System.out.println("Original Text : " + text);
        System.out.println("Normalized Text : " + normalized);

        int left = 0;
        int right = normalized.length() - 1;

        isPalindrome = true;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Ignoring Spaces & Case - Is Palindrome? : " + isPalindrome);

        //***************************************11
        // UC11: Encapsulation using PalindromeChecker class

        System.out.println("\n--- UC11: Encapsulated Palindrome Check ---");

        PalindromeChecker checker = new PalindromeChecker();

        isPalindrome = checker.checkPalindrome(input);

        System.out.println("Using Encapsulation (PalindromeChecker Class) - Is Palindrome? : " + isPalindrome);
        // Deque based strategy        //***************************************12
        // UC12: Dynamic Strategy Selection

        System.out.println("\n--- UC12: Strategy Pattern Palindrome Check ---");

        PalindromeStrategy strategy;

        // Choose algorithm dynamically
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();  // switch algorithm if needed

        boolean result = strategy.check(input);

        System.out.println("Using Strategy Pattern - Is Palindrome? : " + result);
        class DequeStrategy implements PalindromeStrategy {

            public boolean check(String input) {

                Deque<Character> deque = new LinkedList<>();

                for (char c : input.toCharArray()) {
                    deque.addLast(c);
                }

                while (deque.size() > 1) {

                    char front = deque.removeFirst();
                    char rear = deque.removeLast();

                    if (front != rear) {
                        return false;
                    }
                }

                return true;
            }
        }
        // UC13: Performance Comparison of Palindrome Algorithms

        System.out.println("\n--- UC13: Performance Comparison ---");

        // 1. Two Pointer Approach
        long startTime = System.nanoTime();

        boolean result1 = true;
        int leftPtr = 0;
        int rightPtr = input.length() - 1;

        while (leftPtr < rightPtr) {
            if (input.charAt(leftPtr) != input.charAt(rightPtr)) {
                result1 = false;
                break;
            }
            leftPtr++;
            rightPtr--;
        }

        long endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        // 2. Stack Strategy
        startTime = System.nanoTime();

        Stack<Character> stackTest = new Stack<>();
        for(char c : input.toCharArray()){
            stackTest.push(c);
        }

        boolean result2 = true;

        for(int i=0;i<input.length();i++){
            if(input.charAt(i) != stackTest.pop()){
                result2 = false;
                break;
            }
        }

        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // 3. Deque Strategy
        startTime = System.nanoTime();

        Deque<Character> dequeTest = new LinkedList<>();

        for(char c : input.toCharArray()){
            dequeTest.addLast(c);
        }

        boolean result3 = true;

        while(dequeTest.size() > 1){

            char front = dequeTest.removeFirst();
            char rear = dequeTest.removeLast();

            if(front != rear){
                result3 = false;
                break;
            }
        }

        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        // Display Results
        System.out.println("Two Pointer Result : " + result1 + " | Time : " + twoPointerTime + " ns");
        System.out.println("Stack Result       : " + result2 + " | Time : " + stackTime + " ns");
        System.out.println("Deque Result       : " + result3 + " | Time : " + dequeTime + " ns");

    }
}
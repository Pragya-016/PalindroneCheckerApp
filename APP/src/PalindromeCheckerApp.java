import java.util.*;
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

// Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

// Compare original and reversed string
        isPalindrome = input.equals(reversed);

// Display results
        System.out.println("Reversed text: " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        char[] chars = input.toCharArray();

// Initialize pointers
        int start = 0;
        int end = chars.length - 1;

        isPalindrome = true;

// Two-pointer comparison
        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

// Display result
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

// Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        // ==============================
        // UC6: FIFO vs LIFO Demonstration
        // ==============================

        System.out.println("\n--- FIFO vs LIFO Demonstration ---");

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

// Enqueue (FIFO) and Push (LIFO)
        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));   // Enqueue
            stack.push(input.charAt(i));  // Push
        }

        isPalindrome = true;

// Compare Dequeue vs Pop
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove(); // Dequeue (FIFO)
            char fromStack = stack.pop();    // Pop (LIFO)

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

// Insert characters into Deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));  // Insert at rear
        }

        isPalindrome = true;

// Compare front and rear until deque is empty or has 1 element
        while (deque.size() > 1) {

            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            System.out.println("Front: " + front + " | Rear: " + rear);

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Using Deque - Is Palindrome? : " + isPalindrome);

        //*************************************8

        System.out.println("\n--- Linked List Palindrome Check ---");

// Create Singly Linked List from input
        class Node {
            char data;
            Node next;
            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

// Convert string to linked list
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

// Fast and Slow pointer to find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

// Reverse second half (in-place)
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

// Compare first half and reversed second half
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

// Recursive helper using start & end index
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

        // Normalize string
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
    }
}
import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to palindrome checker app management system");
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

        // Initialize pointers

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

        System.out.println("\n--- FIFO vs LIFO Demonstration ---");

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and Push characters
        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));   // Enqueue (FIFO)
            stack.push(input.charAt(i));  // Push (LIFO)
        }

        isPalindrome = true;

        // Compare dequeue (FIFO) and pop (LIFO)
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove(); // Dequeue
            char fromStack = stack.pop();    // Pop

            System.out.println("Queue (FIFO): " + fromQueue +
                    " | Stack (LIFO): " + fromStack);

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Using Queue & Stack - Is Palindrome? : " + isPalindrome);

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

        // ==============================
// UC8: Linked List Based Palindrome Checker
// ==============================

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
        // ==============================
// UC9: Recursive Palindrome Checker
// ==============================

        System.out.println("\n--- Recursive Palindrome Check ---");

// Recursive helper using start & end index
        class RecursiveChecker {
            boolean check(String str, int start, int end) {

                // Base condition
                if (start >= end) {
                    return true;
                }

                // Compare start & end characters
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }

                // Recursive call
                return check(str, start + 1, end - 1);
            }
        }

        RecursiveChecker rc = new RecursiveChecker();
        isPalindrome = rc.check(input, 0, input.length() - 1);

        System.out.println("Using Recursion (Call Stack) - Is Palindrome? : " + isPalindrome);

    }
}

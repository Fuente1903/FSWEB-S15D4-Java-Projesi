import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String[] palindromeTestCases = {
                "I did, did I?",
                "Racecar",
                "hello",
                "Was it a car or a cat I saw ?"
        };

        System.out.println("Palindrome Kontrolü:");
        for (String testCase : palindromeTestCases) {
            System.out.println(testCase + " => " + isPalindrome(testCase));
        }
        System.out.println();


        System.out.println("Stack ve Queue Kullanarak Palindrome Kontrolü:");
        for (String testCase : palindromeTestCases) {
            System.out.println(testCase + " => " + isPalindromeUsingStackAndQueue(testCase));
        }
        System.out.println();

        
        int[] decimalTestCases = { 5, 6, 13 };

        System.out.println("Decimal Sayıyı Binary'ye Çevirme:");
        for (int testCase : decimalTestCases) {
            System.out.println(testCase + " => " + decimalToBinary(testCase));
        }
    }

    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeUsingStackAndQueue(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static String decimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber /= 2;
        }

        StringBuilder binary = new StringBuilder();

        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}

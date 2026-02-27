import java.util.*;

// 1️⃣ Stack Approach
class StackPalindrome {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// 2️⃣ Deque Approach
class DequePalindrome {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// 3️⃣ Two Pointer Approach
class TwoPointerPalindrome {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// 4️⃣ Main Class
public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String input = sc.nextLine();

        // Stack Performance
        StackPalindrome stackObj = new StackPalindrome();
        long start1 = System.nanoTime();
        boolean result1 = stackObj.check(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Deque Performance
        DequePalindrome dequeObj = new DequePalindrome();
        long start2 = System.nanoTime();
        boolean result2 = dequeObj.check(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Two Pointer Performance
        TwoPointerPalindrome twoPointerObj = new TwoPointerPalindrome();
        long start3 = System.nanoTime();
        boolean result3 = twoPointerObj.check(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("Is Palindrome? : " + result1);
        System.out.println("\nPerformance Comparison (in nanoseconds):");
        System.out.println("Stack Approach      : " + time1);
        System.out.println("Deque Approach      : " + time2);
        System.out.println("Two Pointer Approach: " + time3);

        sc.close();
    }
}
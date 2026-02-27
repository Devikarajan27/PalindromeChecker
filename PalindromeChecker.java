public class PalindromeChecker { public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Convert to lowercase to ignore case difference
        str = str.toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into stack and queue
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Ignore spaces
            if (ch != ' ') {
                stack.push(ch);
                queue.add(ch);
            }
        }

        boolean isPalindrome = true;

        // Compare stack and queue
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}
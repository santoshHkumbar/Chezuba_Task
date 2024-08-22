package Problem_Solving_Task;

public class Integer {
	public static int[] plusOne(int[] digits) {
        // Start from the last digit and move left
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the digit is less than 9, increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, set it to 0
            digits[i] = 0;
        }

        // If we reach this point, all the digits were 9, so we need a new array
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;  // Set the first digit to 1, all others are 0 by default
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] result = plusOne(digits);
        for (int digit : result) {
            System.out.print(digit+ " "); // Output should be 1 2 4
        }

    }
}    

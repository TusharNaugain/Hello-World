public class AddNumbers {
    
    /**
     * Adds two integers
     * @param num1 First integer
     * @param num2 Second integer
     * @return Sum of the two numbers
     */
    public int addIntegers(int num1, int num2) {
        return num1 + num2;
    }
    
    /**
     * Adds two double numbers
     * @param num1 First double number
     * @param num2 Second double number
     * @return Sum of the two numbers
     */
    public double addDoubles(double num1, double num2) {
        return num1 + num2;
    }
    
    /**
     * Adds two large numbers with overflow checking
     * @param num1 First long number
     * @param num2 Second long number
     * @return Sum of the two numbers
     * @throws ArithmeticException if overflow occurs
     */
    public long addLongNumbers(long num1, long num2) {
        if (willOverflow(num1, num2)) {
            throw new ArithmeticException("Number overflow occurred");
        }
        return num1 + num2;
    }
    
    /**
     * Checks if adding two numbers will cause overflow
     * @param num1 First number
     * @param num2 Second number
     * @return true if overflow will occur, false otherwise
     */
    private boolean willOverflow(long num1, long num2) {
        if (num2 > 0 && num1 > Long.MAX_VALUE - num2) return true;
        if (num2 < 0 && num1 < Long.MIN_VALUE - num2) return true;
        return false;
    }
    
    /**
     * Adds two numbers from string input
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return Sum of the two numbers
     * @throws NumberFormatException if input strings are not valid numbers
     */
    public double addStringNumbers(String num1, String num2) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            return number1 + number2;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format: Please enter valid numbers");
        }
    }
    
    public static void main(String[] args) {
        AddNumbers calculator = new AddNumbers();
        
        // Testing integer addition
        System.out.println("Integer Addition: " + calculator.addIntegers(5, 3));
        
        // Testing double addition
        System.out.println("Double Addition: " + calculator.addDoubles(3.5, 2.7));
        
        // Testing long addition with overflow checking
        try {
            System.out.println("Long Addition: " + 
                calculator.addLongNumbers(Long.MAX_VALUE - 1, 5));
        } catch (ArithmeticException e) {
            System.out.println("Overflow Error: " + e.getMessage());
        }
        
        // Testing string number addition
        try {
            System.out.println("String Number Addition: " + 
                calculator.addStringNumbers("10.5", "20.3"));
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: " + e.getMessage());
        }
    }
}

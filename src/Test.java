import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter the upper bound of the random number");
            Scanner input = new Scanner(System.in);
            int ob = input.nextInt();
            if (ob > 0) System.out.println(Math.ceil(Math.random() * ob));
            else break;
        }
    }


    public static String compressedString(String message) {

        StringBuilder result = new StringBuilder();
        int countChar = 1;
        for (int i = 0; i < message.length(); i++) {
            if (i == message.length() - 1 || message.charAt(i) != message.charAt(i + 1)) {
                if (countChar == 1) {
                    result.append(message.charAt(i));
                } else {
                    result.append(message.charAt(i));
                    result.append(countChar);
                    countChar = 1;
                }
            } else {
                countChar++;
            }
        }
        return result.toString();
    }
}

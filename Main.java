import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String plainText;
        String cipherText;

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please input the message:");
        String msg = myScanner.nextLine();
        System.out.println("Please state the keyword.");
        String keyword = myScanner.nextLine();

        char[] chars = msg.toCharArray();
        boolean flag = false;

        for (char letter : chars){
            while (!flag){
                if (letter == '.' || letter == ',' || letter == '!' || letter == '?'){
                    plainText = msg; //saves the original text
                    //call Cipher, INPUT PLAINTEXT AND KEYWORD; reminder in Cipher to print out "Completed..." first
                    Cipher myCipher = new Cipher(plainText, keyword);
                    flag = true;
                } else {
                    cipherText = msg;
                    //call Decipher, CIPHER TEXT AND KEYWORD; reminder in Cipher to print out "Completed..." first
                    Decipher myDecipher = new Decipher(cipherText, keyword);
                    flag = true;
                }
            }

        }


    }
}

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
            //System.out.println(letter);
                if (letter == '.' || letter == ',' || letter == '!' || letter == '?'){
                    flag = true;
                    break;
                }
        }

        if (flag){
            plainText = msg; //saves the original text
            //call Cipher, INPUT PLAINTEXT AND KEYWORD; reminder in Cipher to print out "Completed..." first
            //System.out.println(plainText);
            Cipher myCipher = new Cipher(plainText, keyword);
        } else {
            cipherText = msg;
            //call Decipher, CIPHER TEXT AND KEYWORD; reminder in Cipher to print out "Completed..." first
            Decipher myDecipher = new Decipher(cipherText, keyword);
        }



    }
}

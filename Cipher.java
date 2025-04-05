import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {
    private String plainText;
    private String keyword;
    private String[][] process;
    private String cipherText = "";

    private int twoDArrayCounter;

    public Cipher(String plainText, String keyword){
        this.plainText = plainText;
        this.keyword = keyword;

        //System.out.println(plainText);

        //call methods put here
        toLowercase();
        inputProcess();
        outputProcess();

        System.out.println("Completed. The secret message is:");
        System.out.println(cipherText);
    }

    public void toLowercase(){
        plainText = plainText.replaceAll("[ ,!,&,',.,,,:,;,?]", "");//replaces everything listed in regex with an empty string
        plainText = plainText.toLowerCase();
        //System.out.println(plainText);
    }

    public void inputProcess(){
        //organize the input into rows within 2d array process
        if (plainText.length() % keyword.length() == 0){
            process = new String[(int)(plainText.length() / keyword.length())][keyword.length()];
        } else {//not divisible
            process = new String[(int)((plainText.length() / keyword.length()) + 1)][keyword.length()];
        }

        twoDArrayCounter = 0;
        for (int i = 0; i < process.length; i++){
            for (int j = 0; j < process[i].length; j++){
                if (twoDArrayCounter < plainText.length()){
                    process[i][j] = plainText.substring(twoDArrayCounter, twoDArrayCounter + 1);
                    twoDArrayCounter++;
                } else {
                    process[i][j] = "x";
                    twoDArrayCounter++;
                }
            }
        }

//        System.out.println("all keyword's letters should be organized within 2d array 'process'");
//        System.out.println(Arrays.deepToString(process));
//        System.out.println("counter should be how many letters in total in the 2d array");
//        System.out.println(twoDArrayCounter);
    }

    public void outputProcess(){
        //idea:
        //make parallel arrays: one int arraylist for original index; one char arraylist for each letter
        //make a separate int arraylist: column index order
        //compare each char to see which should come first.
        //once identified, record its index number in "column index order"
        //remove identified letter in the char arraylist AND it's corresponding original index in the parallel int arraylist
        //continue this process until column index order is filled

        //Parallel Arrays:
        int[] ogIndex = new int[twoDArrayCounter]; ogIndex = fillNum(ogIndex, keyword.length());
        char[] keywordLetters = new char[twoDArrayCounter]; keywordLetters = stringToCharArraylist(keywordLetters, keyword, keyword.length());

        //tracking order of column index
        ArrayList<Integer> indexOrder = new ArrayList<>();


        //indexOrder will be filled. ogIndex and keywordLetters will be empty.
        while (!checkAllNull(keywordLetters)){//not empty = not all null = false
            char smallest = Character.MAX_VALUE; // Initialize smallest to the maximum value
            int smallestIndex = -1;

            for (int i = 0; i < keywordLetters.length; i++){
                if (keywordLetters[i] != '\0' && keywordLetters[i] < smallest) {
                    smallest = keywordLetters[i];
                    smallestIndex = i;

//                    System.out.println("---");
//                    System.out.println("smallest letter at " + i + " iteration: " + smallest);
//                    System.out.println("smallest letter index at " + i + " iteration is: " + smallestIndex);
//                    System.out.println("---");

                }
            }
            if (smallestIndex != -1){
                // Add the smallest element's index to indexOrder
                indexOrder.add(ogIndex[smallestIndex]);

                // Remove the smallest element from keywordLetters and ogIndex
                keywordLetters[smallestIndex] = '\0';
                ogIndex[smallestIndex] = -1; // Or any other marker value
            }
        }
//        System.out.println("IndexOrder should be all different numbers and rank alphabet order of keyword");
//        System.out.println(indexOrder);

        //add columns according to indexOrder into ciphertext
        for (int colIndex : indexOrder) {
            for (int row = 0; row < process.length; row++) {
                System.out.print(process[row][colIndex] + " ");
            }
        }

        // Concatenate elements into a single string
        StringBuilder concatenatedString = new StringBuilder();
        for (int colIndex : indexOrder) {
            for (int row = 0; row < process.length; row++) {
                concatenatedString.append(process[row][colIndex]);
            }
        }

        cipherText = concatenatedString.toString();
//        System.out.println("\nConcatenated String: " + cipherText);
    }

    //sub-methods:
    public char[] stringToCharArraylist(char[] input, String word, int length){
        for (int i = 0; i < length; i++){
            input [i] = word.charAt(i);
        }
        return input;
    }

    public int[] fillNum(int[] empty, int length){
        for (int i = 0; i <= length; i++){
            empty[i] = i;
        }
        return empty;
    }

    public boolean checkAllNull(char[] input){
        for (int i = 0; i < input.length; i ++){
            if (input[i] != '\0'){
                return false;
            }
        }
        return true;
    }


    //cipher
    //method 1: toLowercase (Transform uppercase letters into lowercase and remove punctuation and spaces)
    //method 2: reorganise: find length of keyword, divide msg w length, if not whole number, add x to fill spaces
    //method 3: write them in rows under the keyword. (2d arrays)
    //           - number columns based on the alphabetized order
    //                - create a spare keyword and compare each letter and determine which letter goes first
    //                - create an int (?) for column index that tracks the corresponding column index to the first letter
    //                - delete the found letter and continue figuring out which letter is smallest until there's no more letters
    //                - when you call a column, just go by the order of the int
    //           NOPE IM DISCARDING TIHS IDEA - it doesn't work because when you take a letter out, it mixes the index order up
    //method 4: get cipher text: output entire columns by the specified order (numbers)
}

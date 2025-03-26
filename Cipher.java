import java.util.ArrayList;

public class Cipher {
    private String plainText;
    private String keyword;
    private String[][] process;
    private String cipherText = "";

    public Cipher(String plainText, String keyword){
        this.plainText = plainText;
        this.keyword = keyword;

        //call methods put here
        toLowercase();
        inputProcess();
        outputProcess();

        System.out.println("Completed. The secret message is:");
        System.out.println(cipherText);
    }

    public void toLowercase(){
        plainText.replaceAll(" !&',.:;?", "");//replaces everything listed in regex with an empty string
        System.out.println(plainText.toLowerCase());
    }

    public void inputProcess(){

        //organize the input into rows within 2d array process
        if (plainText.length() / keyword.length() == 0){
            process = new String[plainText.length() / keyword.length()][keyword.length()];
        } else {
            process = new String[(plainText.length() / keyword.length()) + 1][keyword.length()];
        }

        int counter = 0;
        for (int i = 0; i < process.length; i++){
            for (int j = 0; j < process[i].length; j++){
                process[i][j] = plainText.substring(counter, counter++);
                counter++;
            }
        }

        //fill empty spots with x
        for (String[] row : process){
            for (String col : row){
                if (col.equals(null)){
                    col = "x";
                }
            }
        }
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
        ArrayList<Integer> ogIndex = new ArrayList<>(); ogIndex = fillNum(ogIndex, keyword.length());
        ArrayList<Character> keywordLetters = new ArrayList<>(); keywordLetters = stringToCharArraylist(keywordLetters, keyword, keyword.length());

        //tracking order of column index
        ArrayList<Integer> indexOrder = new ArrayList<>();

        char first = keywordLetters.getFirst(); indexOrder.add(0,0);//pretend first is the first alphabet and add to indexOrder
        int counter = 0;

        //indexOrder will be filled. ogIndex and keywordLetters will be empty.
        while (!keywordLetters.isEmpty()){
            for (int i = 1; i < keywordLetters.size() - 1; i++){
                if (keywordLetters.get(i).compareTo(first) < 0){ // i is before first
                    first = keywordLetters.get(i);
                    indexOrder.add(counter, keywordLetters.indexOf(i)); //replace if needed
                }
            }
            keywordLetters.remove(indexOrder.get(counter));
            ogIndex.remove(indexOrder.get(counter));
            counter ++;
        }

        //add columns according to indexOrder into ciphertext
        for (int col : indexOrder){
            for (int row = 0; row < process.length; row++){
                cipherText += process[col][row];
            }
        }
    }

    //sub-methods:
    public ArrayList<Character> stringToCharArraylist(ArrayList<Character> input, String word, int length){
        for (int i = 0; i <= length; i++){
            input.add(i,word.charAt(i));
        }
        return input;
    }

    public ArrayList<Integer> fillNum(ArrayList<Integer> empty, int length){
        for (int i = 0; i < length; i++){
            empty.add(i,i);
        }
        return empty;
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

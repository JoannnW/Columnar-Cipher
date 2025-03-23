public class Cipher {
    private String plainText;
    private String keyword;
    private String[][] process;
    private String cipherText;

    public Cipher(String plainText, String keyword){
        this.plainText = plainText;
        this.keyword = keyword;

        //call methods put here
        toLowercase();
        inputProcess();
        cipherText = outputProcess();

        System.out.println("Completed. The secret message is:");
        System.out.println(cipherText);
    }

    public void toLowercase(){
        plainText.replaceAll(" !&',.:;?", "");//replaces everything listed in regex with an empty string
        System.out.println(plainText.toLowerCase());
    }

    public void inputProcess(){

        //organize the input into rows within 2d array process
        process = new String[plainText.length() / keyword.length()][keyword.length()];
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

    }
    //cipher
    //method 1: toLowercase (Transform uppercase letters into lowercase and remove punctuation and spaces)
    //method 2: reorganise: find length of keyword, divide msg w length, if not whole number, add x to fill spaces
    //method 3: write them in rows under the keyword. (2d arrays)
    //           - number columns based on the alphabetized order
    //                - compare each letter and determine which letter goes first
    //                - create an int (?) that tracks the corresponding column index to the first letter
    //                - when you call a column, just go by the order of the int
    //method 4: get cipher text: output entire columns by the specified order (numbers)
}

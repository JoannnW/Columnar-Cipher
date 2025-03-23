public class Decipher {
    private String cipherText;
    private String keyword;
    private String[][] process;
    private String plainText;

    public Decipher(String cipherText, String keyword){
        this.cipherText = cipherText;
        this.keyword = keyword;

        //call methods put here
        System.out.println("Completed. The secret message is:");
        System.out.println(plainText);
    }
}

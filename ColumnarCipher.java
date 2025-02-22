public class ColumnarCipher {
    //method 1: toLowercase (Transform uppercase letters into lowercase and remove punctuation and spaces)
    //method 2: reorganise: Break up the message into chunks of the same length as the keyword
    // write them in rows under the keyword. (2d arrays)
    //fill in blank space with "x"
    // number columns based on the alphabetized order

    //method 3: get cipher text: output entire columns by the specified order (numbers)
    //method 4: decipher text...

//TASK
//Create a program that takes a string and a keyword. It return the ciphertext if the string
//is in plaintext (i.e. broken up into normal English words and punctuated), or the
//deciphered message if the string is in ciphertext.
//The resulting deciphered message will not have spaces.
//Examples
//cipher("Meet me by the lake at midnight. Bring shovel.", "python")
//Output ➞ "thaiivelmhglmetgnembaitsetenroeykdbh"
//cipher("meeanbsleyamgioxebltirhxttkihnvxmhedtgex", "monty")
//Output ➞ "meetmebythelakeatmidnightbringshovelxxxx"
//cipher("Mission Delta Kilo Sierra has been compromised. Kill Steve.
//Evacuate", "cake")
//Output ➞
//"ioliiabcrsiteuxmieksrsnpiksecesdaoraemmdlvatxsntleheooelevax"
//Note
//You may use any data structure to solve this program.
}

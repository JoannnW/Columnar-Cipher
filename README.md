# Columnar-Cipher
The columnar cipher is a transposition cipher that works like this.

Start with a secret message:

msg = "Meet me by the lake at midnight. Bring shovel."


Transform uppercase letters into lowercase and remove punctuation and spaces:

msg = "meetmebythelakeatmidnightbringshovel"

Then, pick a keyword made out of distinct letters:

keyword = "python"

Break up the message into chunks of the same length as the keyword, and write them

in rows under the keyword. Then, number the columns based on the alphabetized order

of the letters in the keyword:

p y t h o n

m e e t m e

b y t h e l

a k e a t m

i d n i g h

t b r i n g

s h o v e l

4 6 5 1 3 2


Read off the enciphered message (ciphertext) from the columns in the order specified

by the numbers:

ciphertext = "thaiivelmhglmetgnembaitsetenroeykdbh"

If the message length is not a multiple of the keyword length, fill in each blank space

with "x". For example:


msg = "Meet me at midnight."

keyword = "python"

p y t h o n


m e e t m e

a t m i d n

i g h t x x



TASK

Create a program that takes a string and a keyword. It return the ciphertext if the string

is in plaintext (i.e. broken up into normal English words and punctuated), or the

deciphered message if the string is in ciphertext.

The resulting deciphered message will not have spaces.


Examples

cipher("Meet me by the lake at midnight. Bring shovel.", "python")

Output ➞ "thaiivelmhglmetgnembaitsetenroeykdbh"

cipher("meeanbsleyamgioxebltirhxttkihnvxmhedtgex", "monty")

Output ➞ "meetmebythelakeatmidnightbringshovelxxxx"

cipher("Mission Delta Kilo Sierra has been compromised. Kill Steve.

Evacuate", "cake")
Output ➞
"ioliiabcrsiteuxmieksrsnpiksecesdaoraemmdlvatxsntleheooelevax"
Note
You may use any data structure to solve this program.

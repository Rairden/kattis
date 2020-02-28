# Backspace
https://open.kattis.com/problems/backspace  

Shortly before the programming contest started, Bjarki
decided to update his computer. He didn’t notice anything
strange until he started coding in his favorite editor, Bim
(Bjarki IMproved). Usually when he’s writing in an editor and
presses the _backspace_ key a single character is erased
to the left. But after the update pressing that key outputs the
character **<tt class="ttfamily">&lt;</tt>**. He’s tested all the editors on his
machine, Bmacs, Neobim, bjedit, NoteBjad++ and Subjark Text,
but they all seem to have the same problem. He doesn’t have
time to search the web for a solution, and instead decides to
temporarily circumvent the issue with a simple program.

Help Bjarki write a program that takes as input the string
that was written in the text editor, and outputs the string as
Bjarki intended to write it. You can assume that Bjarki never
intended to write the character **<tt class="ttfamily">&lt;</tt>**, and that Bjarki never pressed the
backspace key in an empty line.

## Input

One line containing the string that was written in the text editor. The length of the string is at most 10<sup>6</sup>, 
and it will only contain lowercase letters from the English alphabet as well as the character <.

## Output

One line containing the string as Bjarki intended to write it.

Sample Input 1   | Sample Output 1 
---------------- | ----------------
<pre>
a&lt;bc&lt;                 b
</pre>

Sample Input 2   | Sample Output 2
---------------- | ---------------
<pre>
foss&lt;&lt;rritun          forritun
</pre>

Sample Input 3   | Sample Output 3
---------------- | ---------------
<pre>
a&lt;a&lt;a&lt;aa&lt;&lt;          
</pre>

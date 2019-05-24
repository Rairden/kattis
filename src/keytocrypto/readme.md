# The Key to Cryptography

Suppose you need to encrypt a top secret message like “SEND
MORE MONKEYS”. You could use a simple substitution cipher,
where each letter in the alphabet is replaced with a different
letter. However, these ciphers are easily broken by using the
fact that certain letters of the alphabet (like ‘E’, ‘S’, and
‘A’) appear more frequently than others (like ‘Q’, ‘Z’, and
‘X’). A better encryption scheme would vary the substitutions
used for each letter. One such system is the _autokey_ cipher.

To encrypt a message, you first select a secret word – say
“ACM” – and prepend it to the front of the message. This longer
string is truncated to the length of the message and called the
_key_, and the <nobr aria-hidden="true"><span class="math" id="MathJax-Span-1" style="width: 1.733em; display: inline-block;"><span style="display: inline-block; position: relative; width: 1.342em; height: 0px; font-size: 128%;"><span style="position: absolute; clip: rect(1.286em, 1001.34em, 2.458em, -999.997em); top: -2.285em; left: 0em;"><span class="mrow" id="MathJax-Span-2"><span class="msubsup" id="MathJax-Span-3"><span style="display: inline-block; position: relative; width: 1.342em; height: 0px;"><span style="position: absolute; clip: rect(3.407em, 1000.56em, 4.188em, -999.997em); top: -4.015em; left: 0em;"><span class="mi" id="MathJax-Span-4" style="font-family: MathJax_Math-italic;">n</span><span style="display: inline-block; width: 0px; height: 4.021em;"></span></span><span style="position: absolute; top: -4.406em; left: 0.617em;"><span class="texatom" id="MathJax-Span-5"><span class="mrow" id="MathJax-Span-6"><span class="mi" id="MathJax-Span-7" style="font-size: 70.7%; font-family: MathJax_Math-italic;">t</span><span class="mi" id="MathJax-Span-8" style="font-size: 70.7%; font-family: MathJax_Math-italic;">h</span></span></span><span style="display: inline-block; width: 0px; height: 4.021em;"></span></span></span></span></span><span style="display: inline-block; width: 0px; height: 2.291em;"></span></span></span><span style="display: inline-block; overflow: hidden; vertical-align: -0.068em; border-left: 0px solid; width: 0px; height: 1.218em;"></span></span></nobr> letter of the key is used to
encrypt the <nobr aria-hidden="true"><span class="math" id="MathJax-Span-9" style="width: 1.733em; display: inline-block;"><span style="display: inline-block; position: relative; width: 1.342em; height: 0px; font-size: 128%;"><span style="position: absolute; clip: rect(1.286em, 1001.34em, 2.458em, -999.997em); top: -2.285em; left: 0em;"><span class="mrow" id="MathJax-Span-10"><span class="msubsup" id="MathJax-Span-11"><span style="display: inline-block; position: relative; width: 1.342em; height: 0px;"><span style="position: absolute; clip: rect(3.407em, 1000.56em, 4.188em, -999.997em); top: -4.015em; left: 0em;"><span class="mi" id="MathJax-Span-12" style="font-family: MathJax_Math-italic;">n</span><span style="display: inline-block; width: 0px; height: 4.021em;"></span></span><span style="position: absolute; top: -4.406em; left: 0.617em;"><span class="texatom" id="MathJax-Span-13"><span class="mrow" id="MathJax-Span-14"><span class="mi" id="MathJax-Span-15" style="font-size: 70.7%; font-family: MathJax_Math-italic;">t</span><span class="mi" id="MathJax-Span-16" style="font-size: 70.7%; font-family: MathJax_Math-italic;">h</span></span></span><span style="display: inline-block; width: 0px; height: 4.021em;"></span></span></span></span></span><span style="display: inline-block; width: 0px; height: 2.291em;"></span></span></span><span style="display: inline-block; overflow: hidden; vertical-align: -0.068em; border-left: 0px solid; width: 0px; height: 1.218em;"></span></span></nobr>
letter of the original message. This encryption is done by
treating each letter in the key as a cyclic shift value for the
corresponding letter in the message, where ‘A’ indicates a
shift of 0, ‘B’ a shift
of 1, and so on. Using
“ACM” as the secret word, we would encrypt our message as
follows:<center>      

col 1                               | col 2       
----------------------------------- | ------------
<tt class="tt">SENDMOREMONKEYS</tt> | (message)   
<tt class="tt">ACMSENDMOREMONK</tt> | (key)       
<tt class="tt">SGZVQBUQAFRWSLC</tt> | (ciphertext)
</center>


Note that the letter ‘E’ in the message was encrypted as ‘G’
the first time it was encountered (since the corresponding
letter in the key was ‘C’ indicating a shift of 2, but then as ‘Q’ and ‘S’ the next
two times.

Your task is simple: given a ciphertext and the secret word,
you must determine the original message.

## Input

Input consists of two lines. The first contains the
ciphertext and the second contains the secret word (which may
be longer than the ciphertext). Both lines contain only
uppercase alphabetic letters. Both the ciphertext and the
secret word are between 1 and 500 letters long.

## Output

Display the original message that generated the given
ciphertext using the given secret word.

Sample Input 1                   | Sample Output 1             
-------------------------------- | ----------------------------
<pre>
SGZVQBUQAFRWSLC         SENDMOREMONKEYS
ACM
</pre>

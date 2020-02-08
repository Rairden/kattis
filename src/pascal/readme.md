# Pascal
https://open.kattis.com/problems/pascal

Little Frane is already in tenth grade, but is still struggling with Pascal in computer class. 
For homework, his teacher wrote the following program into his notebook, and he needs to determine the output, 
given the integer N.  

<pre>
readln(N);
counter := 0;
for i := N - 1 downto 1 do begin
  counter := counter + 1;
  if N mod i = 0 then break;
end;
writeln(counter);
</pre>

Write a program which solves Frane’s problem.

## Input

The first and only line of input contains the integer 1 ≤ N ≤ 10<sup>9</sup>.

## Output

Output the result from Frane’s program on a single line.

Sample Input 1   | Sample Output 1 
---------------- | ----------------
<pre>
1                       0
</pre>

Sample Input 2   | Sample Output 2
---------------- | ---------------
<pre>
10                      5
</pre>

Sample Input 3   | Sample Output 3
---------------- | ---------------
<pre>
27                      18
</pre>

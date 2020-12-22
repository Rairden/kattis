# Repeating Decimal

<https://open.kattis.com/problems/repeatingdecimal>

For this problem, write a program that reports the decimal value of various integer fractions.

## Input

Input consists of up to 100 lines. Each line contains three integers: `a`, `b` and `c`. The constraints are: 1 ≤ `a` < `b` ≤ 10<sup>6</sup> and 1 ≤ `c` ≤ 10,000. Input ends at the end of file.

## Output

For each input line, output a line giving the first `c` fractional digits of the decimal representation for $`\displaystyle \frac{a}{b}`$. Truncate your result; don't round.

`Sample Input 1	/ Sample Output 1`
<pre>
3 7 10
199 200 1
9 35 25
7 10 3
</pre>
<pre>
0.4285714285
0.9
0.2571428571428571428571428
0.700  
</pre>

# Prime Sieve

<https://open.kattis.com/problems/primesieve>

## Input

The first line of input consists of two integers `n`, `q`, where 1 ≤ n ≤ 10<sup>8</sup> and 1 ≤ q ≤ 20,000.  
Then follow `q` lines, each containing an integer `x` satisfying 1 ≤ x ≤ n.

## Output

On the first line of output, write one line giving the number of prime numbers less than or equal to n.  
Then for each query x, output 1 if x is a `prime` and output 0 if x is `composite`.  

`Sample Input / Sample Output`  

<pre>
9973 6
1
2
3
4
9972
9973
</pre>
<pre>
1229
0
1
1
0
0
1
</pre>

***

I cannot beat this problem. I think you have to use some wheel technique.

I've tried with Java and Go. The two techniques below are too slow in Go:

* [sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_and_variants)
* segmented sieve of Eratosthenes

Supposedly both of these techniques take $`O(n\log(\log(n)))`$ time, but Go fails my maximum input test file with 0.31 sec on my machine.

For the primality tests, I use the Go builtin math/big.`ProbablyPrime` which has a time complexity of $`O(k \log(n)^3)`$. ProbablyPrime uses the Miller-Rabin algorithm.

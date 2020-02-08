# Prime Sieve
https://open.kattis.com/problems/primesieve

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

### Hint: use this algo
[en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_and_variants](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_and_variants)  
[en.wikipedia.org/wiki/Prime-counting_function#Table_of_%CF%80(x)](https://en.wikipedia.org/wiki/Prime-counting_function#Table_of_%CF%80(x),_x_/_ln_x,_and_li(x\))  
**algorithm** Sieve of Eratosthenes **is**  
&#160; &#160; **input**: an integer _n_ > 1.  
&#160; &#160; **output**: all prime numbers from 2 through _n_.  

&#160; &#160; **let** _A_ be an **array of boolean values** values, indexed by **integer**s 2 to _n_,  
&#160; &#160; initially all **set** to **true**.  

&#160; &#160; **for** i = 2, 3, 4, ..., not exceeding _√n_ **do**  
&#160; &#160; **if** _A_[i] **is** **true**  
&#160; &#160; &#160; &#160; **for** _j_ = i<sup>2</sup>, i<sup>2</sup>+i, i<sup>2</sup>+2i, i<sup>2</sup>+3i, ..., not exceeding _n_ **do**  
&#160; &#160; &#160; &#160; &#160; &#160; _A_[_j_] := **false**  

&#160; &#160; **return** all i such that _A_[i] **is** **true**.  
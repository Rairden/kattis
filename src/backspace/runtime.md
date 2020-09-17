# Backspace
## https://open.kattis.com/problems/backspace

### I could not get java code to pass the 1 second time limit.

I originally solved this problem in Feb 2020. I couldn't beat the time limit.  Fast-foward 7 months and I beat it.

What I was doing wrong was using `StringBuilder.deleteCharAt()`. That does a lot of shuffling of the data structure.

When I finally beat this problem, I compared the runtimes of old vs new code. Here are the results:

| technique | runtime (ms) |                                |
|-----------|-------------:|--------------------------------|
| new       |           55 |                                |
| old       |       50,332 | no ensureCapacity              |
| old       |       83,454 | sb.ensureCapacity(1000000);    |

## Conslusion

Don't use java.lang.StringBuilder.`ensureCapacity​(int minimumCapacity)` if you're expecting a string that could be 10<sup>6</sup> long. If it needs to resize, then it doubles its size when needed.

And for this problem it seems super slow to use java.lang.StringBuilder.`deleteCharAt​(int index)`. Because when you delete a character, it needs to shuffle every single character to the left one place.


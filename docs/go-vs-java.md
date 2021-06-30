## Why I love Go more than Java

1. it's more like C
1. performance
1. compiles to a single binary
1. curly braces on the same line ([1TBS](https://en.wikipedia.org/wiki/Indentation_style#Variant:_1TBS_(OTBS))) enforced
1. C-like enums
1. C-like number aliases (x := 1e6)
1. regex doesn't need escaping
1. superb profiling tools

Enums in java are very ugly and verbose. And you cannot write shorthand notation for large numbers.

```java
class Main {
    public static void main(String[] args) {
        int x = 1000000000;
        int y = 1000000;
        System.out.println(x / y);
    }
}
```

```go
package main

import "fmt"

func main() {
	x := 1e9
	y := 1e6
	fmt.Println(x / y)
}
```

## Java vs Go speed

I'm making a list of all my competetive programming runtimes of Java vs Go.

I've done 42 problems in Java, and now I'm learning Go. I love how much faster Go runs.

A list of my memorable or interesting problems can be found [here](https://gitlab.com/Rairden/kattis/-/blob/master/docs/favProblems.md).

| problem               | runtime Java (sec) | runtime Go (sec) |
| --------------------- | -----------------: | ---------------: |
| helpaphd              | 0.15               | 0.02             |
| almostperfect         | 0.16               | 0.02             |
| parsinghex            | 0.25               | 0.02             |
| variablearithmetic    | 0.33               | 0.02             |
| bits                  | 0.37               | 0.02             |
| guessthedatastructure | 0.56               | 0.06             |
| stickysituation       | 0.19               | 0.08             |
| haypoints             | 0.33               | 0.08             |
| heartrate             | 0.35               | 0.08             |
| goldbach2             | 0.53               | 0.08             |
| backspace             | 0.23               | 0.10             |
| roundedbuttons        | 0.79               | 0.10             |
| enlarginghashtables   | 0.34               | 0.12             |
| crackingrsa           | 0.28               | 0.16             |
| conversationlog       | 0.75               | 0.35             |

What I don't like about Java is reading input. The normal `Scanner` is 2x slower than using a `BufferedReader`. On almost all problems I drag around my custom `FastReader` class which is 70 lines. In Go, it's just one line and builtin (NewScanner or ReadAll).

And Java has no unsigned types. So if you want large numbers Go's uint64 goes 2x larger than Java's long.

$`~~9\ 223\ 372\ 036\ 854\ 775\ 807 \approx 9.22e18 \approx 9.2 \ quintillion`$  
$`18\ 446\ 744\ 073\ 709\ 551\ 615 \approx 1.84e19 \approx 18.4 \ quintillion`$

***

## Array-Based vs List-Based Stacks and Queues in Go

Here is a stack overflow [explanation](https://stackoverflow.com/a/7477556) comparing the time complexity of stacks and queues (array vs list-based).

| problem               | Array-based | LinkedList-based |
| --------------------- | ----------: | ---------------: |
| guessthedatastructure | 0.11        | 0.09             |

<br>

The code to the above array vs list-based stack and queues are found here (not my code):
* [array-based](https://github.com/arnauddri/algorithms)
* [list-based](https://github.com/floyernick/Data-Structures-and-Algorithms)

I then did a stringbuilder to save more time. My best is 0.06. This simple code [here](https://github.com/jupp0r/go-priority-queue/blob/master/priorty_queue.go) is 0.12 sec. Short, simple code runs 2x slower.

## Java vs Go speed

I'm making a list of all my competetive programming runtimes of Java vs Go.

I've done 43 problems in Java, and now I'm learning Go. I love how much faster Go runs.

A list of my memorable or interesting problems can be found [here](https://gitlab.com/Rairden/kattis/-/blob/master/docs/favProblems.md).

| problem               | runtime Java (sec) | runtime Go (sec) |
| --------------------- | -----------------: | ---------------: |
| helpaphd              | 0.15               | 0.02             |
| haypoints             | 0.33               | 0.08             |
| heartrate             | 0.35               | 0.08             |
| guessthedatastructure | 0.56               | 0.06             |
| goldbach2             | 0.53               | 0.08             |
| backspace             | 0.23               | 0.10             |
| roundedbuttons        | 0.79               | 0.10             |

<br>

## Array-Based vs List-Based Stacks and Queues in Go

Here is a stack overflow [explanation](https://stackoverflow.com/a/7477556) comparing the time complexity of stacks and queues (array vs list-based).

| problem               | Array-based | LinkedList-based |
| --------------------- | ----------: | ---------------: |
| guessthedatastructure | 0.11        | 0.09             |

<br>

The code to the above array vs list-based stack and queues are found here:
* [array-based](https://github.com/arnauddri/algorithms)
* [list-based](https://github.com/floyernick/Data-Structures-and-Algorithms)

I then did a stringbuilder to save more time. My best is 0.06. This simple code [here](https://github.com/jupp0r/go-priority-queue/blob/master/priorty_queue.go) is 0.12 sec. Short, simple code runs 2x slower.


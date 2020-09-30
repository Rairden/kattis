## Compare runtimes

| lang | class            | runtime (sec) |
| ---- | ---------------- | ------------: |
| Go   | ioutil.ReadAll   | 0.08          |
| Go   | bufio.NewScanner | 0.08          |
| Java | Kattio           | 0.33          |
| Java | FastReader       | 0.34          |
| Java | Scanner          | 0.62          |


```sh
time go run code/haypoints
700150
150

real    0m0.083s
user    0m0.147s
sys     0m0.042s
```

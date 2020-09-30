package main

import (
    "io/ioutil"
    "strings"
    "testing"
)

var fileLong = "/run/media/erik/storage/Kattis-longInput/enwik9/enwik9"

func populateDict() {
    dict["administer"] = 100000
    dict["spending"] = 200000
    dict["manage"] = 50000
    dict["responsibility"] = 25000
    dict["expertise"] = 100
    dict["skill"] = 50
    dict["money"] = 75000
}

func TestSplitLine(t *testing.T) {
    a := "test 5"
    line, salary := splitLine(a)

    if line != "test" || salary != 5 {
        t.Errorf("want: test 5\n")
        t.Errorf(" got: %v %v", line, salary)
    }
}

func TestSplitLine2(t *testing.T) {
    type job struct {
        title  string
        salary int64
    }

    var tests = []struct {
        in   string
        want job
    }{
        {"worker 240", job{"worker", 240}},
    }
    for _, test := range tests {
        if title, salary := splitLine(test.in); title != test.want.title && salary != test.want.salary {
            t.Errorf(" got: %v %v", title, salary)
            t.Errorf("want: %v %v", test.want.title, test.want.salary)
        }
    }
}

func TestSumLine(t *testing.T) {
    populateDict()
    line1 := "the incumbent will administer the spending of kindergarden milk money"
    line2 := "abc"

    want := 375000
    if got := sumLine(line1); got != want {
        t.Errorf("want: %v\n", want)
        t.Errorf(" got: %v\n", got)
    }

    want = 0
    if got := sumLine(line2); got != want {
        t.Errorf("want: %v\n", want)
        t.Errorf(" got: %v\n", got)
    }
}

func TestCalcSalary(t *testing.T) {
    populateDict()
    var arr = []string{"" +
        "this individual must have the skill to perform a heart transplant and",
        "expertise in rocket science",
        "."}

    var sum int
    for _, s := range arr {
        sum += sumLine(s)
    }

    want := 150
    if sum != want {
        t.Errorf("want: %v\n", want)
        t.Errorf(" got: %v\n", sum)
    }
}

func BenchmarkSplitLine(b *testing.B) {
    for i := 0; i < b.N; i++ {
        line := "10000 100"
        splitLine(line)
    }
}

func BenchmarkSumLine(b *testing.B) {
    file, _ := ioutil.ReadFile(fileLong)
    for i := 0; i < b.N; i++ {
        line := strings.Split(string(file), "\n")
        for _, s := range line {
            sumLine(s)
        }
    }
}

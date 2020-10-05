package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	input := "roundedbuttons/in"
	file, err := os.Open(input)

	if err != nil {
		fmt.Printf("File not found: '%v'", input)
		return
	}

	io := bufio.NewScanner(file)
	io.Scan()
	cases, _ := strconv.Atoi(io.Text())

	for i := 0; i < cases; i++ {
		io.Scan()
		words := strings.Fields(io.Text())

		rect := words[0:5]
		x, _ := strconv.ParseFloat(rect[0], 64)
		y, _ := strconv.ParseFloat(rect[1], 64)
		w, _ := strconv.ParseFloat(rect[2], 64)
		h, _ := strconv.ParseFloat(rect[3], 64)
		r, _ := strconv.ParseFloat(rect[4], 64)
		var pt Point
		rect1 := Rect{x, y, w, h, r, pt}

		clicks := words[6:]

		var click []Point
		for i := 0; i < len(clicks); i += 2 {
			x, _ := strconv.ParseFloat(clicks[i], 64)
			y, _ := strconv.ParseFloat(clicks[i+1], 64)
			click = append(click, Point{x, y})
		}
		calcInOut(&rect1, &click)
		fmt.Println()
	}
}

func calcInOut(rect *Rect, clicks *[]Point) {
	inWidth  	:= rect.w - (2 * rect.r)
	inHeight	:= rect.h - (2 * rect.r)
	xBegin 		:= rect.x + rect.r
	xEnd 		:= rect.x + rect.r + inWidth
	yBegin  	:= rect.y + rect.r
	yEnd 		:= rect.y + rect.h

	center1 := Point{xBegin, yBegin}
	center2 := Point{xBegin, yBegin + inHeight}
	center3 := Point{xBegin + inWidth, yBegin}
	center4 := Point{xBegin + inWidth, yBegin + inHeight}

	for _, pt := range *clicks {
		if pt.x >= xBegin && pt.x <= xEnd {						// horizontal rect
			if pt.y >= rect.y && pt.y <= yEnd {
				fmt.Println("inside")
				continue
			}
		} else if pt.x >= rect.x && pt.x <= rect.x + rect.w {	// vertical rect
			if pt.y >= yBegin && pt.y <= yBegin + inHeight {
				fmt.Println("inside")
				continue
			}
		}

		mid := rect.midPoint()			// calc the center of the rectangle (x, y)
		if pt.x <= mid.x {
			if pt.y <= mid.y {			// bottom left
				dist := center1.calcDistance(&pt)
				printResult(rect, dist)
			} else {					// top left
				dist := center2.calcDistance(&pt)
				printResult(rect, dist)
			}
		} else if pt.y <= mid.y {		// bottom right
			dist := center3.calcDistance(&pt)
			printResult(rect, dist)
		} else {						// top right
			dist := center4.calcDistance(&pt)
			printResult(rect, dist)
		}
	}
}

func (center *Point) calcDistance(click *Point) float64 {
	xDist := center.x - click.x
	yDist := center.y - click.y
	x := math.Pow(xDist, 2)
	y := math.Pow(yDist, 2)

	return math.Pow(x+y, 0.5)
}

func printResult(rect *Rect, dist float64) {
	if dist <= rect.r {
		fmt.Println("inside")
	} else {
		fmt.Println("outside")
	}
}

type Point struct {
	x, y float64
}

type Rect struct {
	x, y, w, h, r float64
	midpoint      Point
}

func (r *Rect) midPoint() Point {
	x := r.w/2 + r.x
	y := r.h/2 + r.y
	return Point{x, y}
}

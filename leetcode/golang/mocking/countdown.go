package main

import (
	"fmt"
	"io"
	"os"
	"time"
)
const finalWord = "Go!"
const countdownStart = 3

type Sleeper interface {
	Sleep()
}

type ConfigurableSleeper struct {
	duration time.Duration
	sleep func(time.Duration)
}

func (o *ConfigurableSleeper) Sleep() {
	o.sleep(o.duration)
}

func Countdown(writer io.Writer, sleeper Sleeper)  {
	for i := countdownStart; i > 0; i-- {
		sleeper.Sleep()
		fmt.Fprintln(writer, i)
	}
	sleeper.Sleep()
	fmt.Fprintf(writer, finalWord)
}
func main()  {
	configurableSleeper := &ConfigurableSleeper{1 * time.Second, time.Sleep}
	Countdown(os.Stdout, configurableSleeper)
}

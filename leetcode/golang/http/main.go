package main

import (
	"log"
	"net/http"
)

type InmemoryPlayerStore struct {

}

func (i *InmemoryPlayerStore) GetPlayerScore(name string) int {
	return 123
}

func main() {
	server := &PlayerServer{&InmemoryPlayerStore{}}
	if err := http.ListenAndServe(":5100", server); err != nil {
		log.Fatalf("could not listen on port 5000 %v", err)
	}
}
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

typedef struct {
    char nombre[10];    
    int puntos;
} Jugador;

Jugador* nuevoJugadorGenerico();
Jugador* nuevoJugador(char *nombre, int puntos);
void leerJugador(Jugador *j);
char* toStringJugador(Jugador j);
int compararJugador(Jugador a, Jugador b);
/*
Si a es igual a b devuelve 0.
Si a es menor que b devuelve -1.
Si a es mayor que b devuelve 1.
*/
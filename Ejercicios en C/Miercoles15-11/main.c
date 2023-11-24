#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ciclista.c"

#define NUMCICLISTAS 5

int main() {
    float tiempoTotal = 0;
    float tiempoMedio;
    float tiempo;
    int dorsal;
    int vuelta;
    int cambios = 1;
    struct Ciclista ciclista;
    struct Ciclista cListas[NUMCICLISTAS];
    struct Ciclista cListasTemp[NUMCICLISTAS];
    
    for (int i = 0; i < NUMCICLISTAS; i++) {
        scanf("%d", &dorsal);
        scanf("%f", &tiempo);
        cListas[i].dorsal = dorsal;
        cListas[i].tiempo = tiempo;
        tiempoTotal += tiempo;
    }

    tiempoMedio = tiempoTotal/NUMCICLISTAS;

    while (cambios) {
        cambios = 0;
        for (int i=0; i<NUMCICLISTAS-1; i++) {
            if (cListas[i].tiempo > cListas[i+1].tiempo) {
                ciclista = cListas[i];
                cListas[i] = cListas[i+1];
                cListas[i+1] = ciclista;
                cambios = 1;
            }
        }
    }

    for (int i=0; i<3; i++) {
        printf("%d %.2f\n", cListas[i].dorsal,cListas[i].tiempo);
    }
}
#include <string.h>
#include <stdlib.h>
#include "jugador.h"
#define NUM_JUGADORES 5

int main(int argc, char** argv){
    
    Jugador *participantes[NUM_JUGADORES];

    int i=0;
    for(i=0; i<NUM_JUGADORES; i++) 
    {
        //leer jugador
        participantes[i]=nuevoJugadorGenerico();
        leerJugador(participantes[i]);
    }
    
    //ordenar
    int cambios=1;
    Jugador *auxiliar;
    while(cambios>0) {
        //vuelta
        cambios=0;
        for(i=0; i<NUM_JUGADORES-1; i++) {
            if(compararJugador(*participantes[i],*participantes[i+1])<0) {
                //intercambiar
                auxiliar=participantes[i];
                participantes[i]=participantes[i+1];
                participantes[i+1]=auxiliar;
                cambios++;
            }
        }
    }

    for(i=0; i<NUM_JUGADORES; i++) 
    {
        //mostra jugador
        printf("%s",toStringJugador(*participantes[i]));
    }

    
    return (EXIT_SUCCESS);
}
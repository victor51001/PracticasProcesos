#include <string.h>
#include <stdlib.h>
#include "jugador.h"

int main(int argc, char** argv){
    Jugador *uno,*dos;
    uno=nuevoJugadorGenerico();
    dos=nuevoJugador("Javier",100);
    leerJugador(uno);
    leerJugador(dos);
    if (compararJugador(*uno,*dos)>0)
        printf("Ganador %s", toStringJugador(*uno));
        else 
            if (compararJugador(*uno,*dos)<0)
                printf("Ganador %s", toStringJugador(*dos));
            else 
                printf("Empate\n");
    return (EXIT_SUCCESS);
}
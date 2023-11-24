#include "jugador.h"

Jugador* nuevoJugadorGenerico(){
    Jugador *j=malloc(sizeof(Jugador));

    strcpy(j->nombre,"anonimo");
    j->puntos=0;
    return j;
}

Jugador* nuevoJugador(char *nombre, int puntos){
    Jugador *j=malloc(sizeof(Jugador));

    strcpy(j->nombre,nombre);
    j->puntos=puntos;
    return j;
}

void leerJugador(Jugador *j){
    int puntos=0;

    printf("Nombre:");
    scanf("%s",j->nombre);
    printf("Puntos:");
    scanf("%d",&puntos);
    //scanf("%d",&(j->puntos));
    j->puntos=puntos;
}

char* toStringJugador(Jugador j){
    //char cadena[30];
    char* cadena=malloc(30*sizeof(char));
    sprintf(cadena,"Nombre:%s\nPuntos:%d\n",j.nombre,j.puntos);
    /*
    char* cadena2=malloc(5*sizeof(char));
    strcat(cadena, "Nombre:");
    strcat(cadena,j.nombre);
    strcat(cadena,"\n");
    strcat(cadena,"Puntos:");
    sprintf(cadena2,"%d",j.puntos);
    strcat(cadena,cadena2);
    strcat(cadena,"\n");
    */

    return cadena;
}

int compararJugador(Jugador a, Jugador b) {
    if(a.puntos==b.puntos)
        return 0;
    else 
        if (a.puntos<b.puntos)
            return -1;
        else
            return 1;
}
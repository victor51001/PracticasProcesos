/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "coche.h"

Coche* nuevoCoche(char *mat, int tam){
    Coche *c=malloc(sizeof(Coche));
    
    //c->matricula=mat;
    strcpy(c->matricula,mat);
    c->tamagno=tam;
}

char* toStringCoche(Coche c){
    
    char* nombreTamagno;
    nombreTamagno=malloc(20*sizeof(char));
    strcpy(nombreTamagno,c.matricula);
    strcat(nombreTamagno, " tipo ");
    
    switch (c.tamagno) {
        case 1:
            strcat(nombreTamagno, "pequeño");
            break;
        case 2:
            strcat(nombreTamagno, "mediano");
            break;
        case 3:
            strcat(nombreTamagno, "grande");
            break;
        default:
            strcat(nombreTamagno, "no definido");
    }
    
    
    
    return nombreTamagno;
}

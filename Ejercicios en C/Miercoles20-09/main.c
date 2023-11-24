#include <stdio.h>
#include <stdlib.h>
#include "coche.h"
/*
 * 
 */
int main(int argc, char** argv) {

    Coche *c;
    Coche *p;
    
    c=nuevoCoche("1234BMW",3);
    //leerCoche(c);
    p=c;
    p->tamagno=1;
    printf("%s\n",toStringCoche(*c));
    
    Coche otroCoche;
    otroCoche.tamagno=1;
    strcpy(otroCoche.matricula,"1111ZZZ");
    //printf("matricula %s tamaño %d\n",otroCoche.matricula, otroCoche.tamagno);
    printf("%s\n",toStringCoche(otroCoche));   

    return (EXIT_SUCCESS);
}


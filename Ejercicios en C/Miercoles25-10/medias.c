#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main() {
    int numero;
    int contador=-1;
    int suma = 0;
    double media;
    int valor;
    printf("numero:");
    scanf("%d",&numero);

    while (numero!=0) {
        contador++;
        suma += numero;
        printf("numero:");
        valor=scanf("%d",&numero);
        if (!valor) {
            numero = 0;
            fprintf(stderr,"error\n");
        }
    }
    media = (double)suma/contador;
    printf("La nota media es %.2f\n",media);
}
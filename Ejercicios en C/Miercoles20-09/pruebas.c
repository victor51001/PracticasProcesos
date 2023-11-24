#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main(){

	char *nombre;
	char copia[10];
	char *link;
	nombre=malloc(10*sizeof(char));
	strcpy(nombre,"Javier");
    strcpy(copia,nombre);
	link=nombre;
	printf("Nombre:");
	scanf("%s",nombre);
	link[0]='H';
    printf("nombre:%s\n",nombre);
    printf("copia:%s\n",copia);
	printf("link:%s\n",link);


}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <fcntl.h>

int main(void){
 	
	char c;
	int bytesleidos;
	FILE *fd;

	//escritura del fichero

	fd=fopen("texto.txt","w"); //abrimos el fichero para escritura

	if (fd == NULL){
		printf("ERROR DE APERTURA DEL FICHERO ....\n");
		exit(-1);
	}
	printf("Escribo el saludo en el fichero\n");
	fprintf(fd,"hola, soy Javier\n");
	fclose(fd); //cierro el fichero

	//lectura del fichero

	fd=fopen("texto.txt","r"); //abrimos el fichero para escritura

	if (fd == NULL){
		printf("ERROR DE APERTURA DEL FICHERO ....\n");
		exit(-1);
	} //abro el fichero sólo para lectura
	printf("Contenido del fichero:\n");
	
	while(fscanf(fd,"%c",&c)>0)
	{
		printf("%c",c);
	}
/*
	bytesleidos=read(fc,buffer,1); // leo un byte
	while(bytesleidos!=0)
	{
		printf("%1c",buffer[0]); //escribo un byte
		bytesleidos=read(fc,buffer,1); //leo otro byte
	}*/
	fclose(fd);
	
}

#include <stdio.h>
#include <stdlib.h> //Control de procesos
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    FILE *archivo; //objeto capaz de almacenar información
    char caracter;
    int contA = 0;

    pid_t pid, id_hijo;

    archivo=fopen("vocales.txt","r"); //ruta, operación "w","r","a"
    if (archivo==NULL) {
        printf("Error en la apertura del archivo\n");
    }

	pid=fork();
    
	if (pid==-1) //error, no se ha creado el proceso hijo
	{
		printf("No se ha podido crear el proceso hijo...\n");
		exit(-1);
	}
	if (pid==0) // proceso hijo
	{
		printf("Contenido del archivo:\n");
        while(feof(archivo)==0) { //Comprueba el indicador al final del archivo
            caracter =fgetc(archivo);
            printf("%c",caracter);
            if ((("%c",caracter) == 'a') || 
                (("%c",caracter) == 'A')) {
                contA = contA + 1;
            }           
        } 
	}
	else // proceso padre 
	{
        id_hijo=wait(NULL);
        fclose(archivo);
		
	} 
    printf("Cantidad de a: %d\n", contA);
    return 0;
}


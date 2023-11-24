#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM 5
#define LETRAS 3

int main(int argc, char *argv[]) {
    FILE *archivo;
    if (argc != NUM + 1) {
        printf("Debes proporcionar exactamente %d palabras como argumentos.\n", NUM);
        exit(1);
    }
    char *palabras[NUM];
    for (int i=0; i<NUM; i++) {
        if (strlen(argv[i+1]) != LETRAS) {
            printf("Todas las palabras deben tener una longitud de %d caracteres.\n", LETRAS);
            exit(1);
        }
        palabras[i] = argv[i+1];
    }
    int fd[NUM][2];
    pid_t pid;
    int contador[NUM] = {0};
    char caracter;
    archivo = fopen("texto.txt", "r");

    if (archivo == NULL) {
        perror("Error al abrir el archivo");
        exit(1);
    }

    printf("Contenido del archivo:\n");
    while (feof(archivo) == 0) {
        caracter = fgetc(archivo);
	printf("%c", caracter);
    }
    printf("\n");


    for (int i = 0; i < NUM; i++) {
	    pipe(fd[i]);
        pid = fork();
        if (pid == -1) {
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }

        if (pid == 0) { // proceso hijo

            close(fd[i][0]);
	        fclose(archivo);
            archivo = fopen("texto.txt", "r");

            if (archivo == NULL) {
                printf("Error al abrir el archivo");
                exit(1);
            }

            int estado = 1;
            int recuento = 0;

            while (feof(archivo) == 0) {
		        caracter = fgetc(archivo);
                if (caracter == palabras[i][estado-1]) {/*
                                                        estado 1 && encuentra letra1 ||
                                                        estado 2 && encuentra letra2  ||
                                                        estado 3 && encuentra letra3
                                                        */                   
                    if (estado == LETRAS) {//estado 3 && encuentra letra3
                        recuento++;
                        estado = 1;
                    } else if (estado == 1) {
                        estado++;
                    } else {
                        estado++;
                    }
                } else if (palabras[i][0]) {//(estado 3 || estado 2) && encuentra letra1
                    estado = 2;
                } else {/*
                        estado 1 && no encuentra letra1 ||
                        estado 2 && no encuentra letra2 ni letra1 || 
                        estado 3 && no encuentra letra3 ni letra1
                        */
                    estado = 1;
                }
            }
	    
            // Enviar el recuento al proceso padre a traves de la tuberia
            write(fd[i][1], &recuento, sizeof(int));
	        fclose(archivo);
            exit(0);
        }
    }

    // Proceso padre
    int buffer[1];
    int contadores[5] = {0,0,0,0,0};

    for (int i = 0; i < NUM; i++) {
        wait(NULL);
    }

    printf("\nTotal de palabras contadas: \n");

    for (int i = 0; i < NUM; i++) {
	    close(fd[i][1]);
        read(fd[i][0], buffer, sizeof(int));
	    contadores[i] += buffer[0];
        printf("La palabra %s se encontro %d veces \n", palabras[i], contadores[i]);
    }

    fclose(archivo);

    exit(0);
}


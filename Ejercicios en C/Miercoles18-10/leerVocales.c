#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM 5

int main() {
    FILE *archivo;
    char vocales[5] = {'a', 'e', 'i', 'o', 'u'};
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
            while (feof(archivo) == 0) {
		caracter = fgetc(archivo);
                if (caracter == vocales[i] || caracter == vocales[i] - 32) {
                    contador[i]++;
               }
            }
	    
            // Enviar el contador al proceso padre a traves de la tuberia
            write(fd[i][1], &contador[i], sizeof(int));
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

    printf("\nTotal de vocales contadas: \n");

    for (int i = 0; i < NUM; i++) {
	close(fd[i][1]);
        read(fd[i][0], buffer, sizeof(int));
	contadores[i] += buffer[0];
	printf("%c:%d\n",vocales[i], contadores[i]);
    }

    fclose(archivo);

    exit(0);
}

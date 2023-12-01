#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h>

#define NUM 4

int sacarUltimaCifra(char num) {
    int n = num;
    int contador;
    if ((n%10)==0) {
        return 0;
    }
    while ((n%10)!=0) {
        n--;
        contador++;
    }
    return contador;
}

int main (int argc, char *argv[]){
    FILE *archivo;
    int fd[2];
    pid_t pid;   
    char numero; 
    char gordo = argv[1];
    int pasta = 0;
    int buff[1];
    int ultiGordo;
    int ultiNum;
    int numAnterior;
    int numPosterior;
    int i;
    pipe(fd);
                        

    for (i = 0; i < NUM; i++) {
        pid = fork();
        if (pid == -1) {
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }
        if (pid == 0) {
            close(fd[0]);
            archivo = fopen("loteria.txt", "r");
            if (archivo == NULL) {
                perror("Error al abrir el archivo");
                return 1;
            }     
            while (feof(archivo) == 0) {
                numero = fgetc(archivo);
                switch (i) {
                    case 0:
                        if (numero==gordo) {
                            pasta += 200000;
                        }
                        break;
                    case 1:
                        ultiGordo = sacarUltimaCifra(gordo);
                        ultiNum = sacarUltimaCifra(numero);
                        if (ultiGordo==ultiNum) {
                            pasta += 10;
                        }
                        break;
                    case 2:
                        numAnterior = gordo-1;
                        numPosterior = gordo+1;
                        if (numAnterior==numero || numPosterior==numero) {
                            pasta += 1000;
                        }
                        break;
                    case 3:
                        pasta -= 10;
                        break;
                }
            }  
            write(fd[1], &pasta, sizeof(int));
            fclose(archivo);
            return 0;
        }
    }

    for (i=0; i < NUM; i++) {
        close(fd[1]);
        read(fd[0],buff,sizeof(int));
        pasta += buff[0];
        wait(NULL);
    }    
    printf("El total del dinero es: %d \n",pasta);
    return 0;
}
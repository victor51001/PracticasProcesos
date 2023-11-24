#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include "cosillas.h"

void salir() {
    exit(0);
}

void main() {
    int pid;
    
    pid=fork();

    if (pid==-1) {
        printf("No se pudo crear el hijo.");
        exit(-1);
    } else if (pid==0) {
        int anyo;
        while (anyo!=1492) {
            printf("¿En que anyo se descubrio America? ¡Si no aciertas en 30 segundos destruiré todos tus datos!\n");
            scanf("%d", &anyo);
        }
        printf("Por esta vez te has salvado, no te fíes de los extraños\n");
        kill(getppid(),SIGUSR2);
        exit(0);
    }
    signal(SIGUSR2,salir);
    sleep(30);
    kill(pid,SIGKILL);
    destruir();
    exit(0);
}
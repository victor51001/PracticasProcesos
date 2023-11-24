#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){

    int fd[2];
    char buffer[30];
    pid_t pid;

    pipe(fd);
    pid=fork();

    switch(pid){
        case -1: //error
            printf("no se ha podido hacer el fork\n");
            exit(-1);
            break;
        case 0: //hijo
            printf("el hijo escribe en el pipe ...\n");
            write(fd[1],"hola papi",10);
            break;
        default://padre
            wait(NULL);
            printf("el padre lee del pipe...\n");
            read(fd[0],buffer,10);
            printf("\tMensaje leido: %s\n",buffer);
            break;
    }
}
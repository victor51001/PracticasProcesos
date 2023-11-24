#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(){

    int fd[2];
    char buffer[30];
    char saludo[] ="yo soy tu padre\0";
    pid_t pid;

    pipe(fd);
    pid=fork();

    switch(pid){
        case -1: //error
            printf("no se ha podido hacer el fork\n");
            exit(-1);
            break;
        case 0: //hijo
            close(fd[1]); //cierra el descritor no usado
            read(fd[0],buffer,sizeof(buffer));
            printf("el hijo lee del pipe: %s ...\n",buffer);          
            break;
        default://padre
            printf("el padre escribe en el pipe...\n");
            write(fd[1],saludo,strlen(saludo));
            wait(NULL);//espero el final del hijo
            break;
    }
}
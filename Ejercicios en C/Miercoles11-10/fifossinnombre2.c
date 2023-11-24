#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(){

    int fd[2];
    char buffer[30];
    char saludo[] ="345\0";
    int *numero;
    int buff[1];

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
            
            read(fd[0],buff,sizeof(int));
            int leido=buff[0]+100;
            
            //printf("el hijo lee del pipe: %s ...\n",buffer);          
            printf("el numero vale %d \n",leido);
            break;
        default://padre
            //wait(NULL);//espero el final del hijo
            printf("el padre escribe en el pipe...\n");
            close(fd[0]);
            *numero=589;
            write(fd[1],numero,sizeof(int));
            printf("Se ha escrito %d\n",*numero);
            
            break;
    }
}
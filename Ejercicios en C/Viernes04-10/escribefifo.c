#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include <fcntl.h>

int main(){
    int fp;
    int p,bytesleidos;
    char saludo[]="Un saludito!!!\n",buffer[10];

    fp=open("FIFO2",1);

    if (p==-1)
    {
        printf("ERROR AL ABRIR EL FIFO\n");
        exit(0);
    }
    printf("Mando información al FIFO ...\n");
    write(fp,saludo,strlen(saludo));
    close(fp);
    return(0);
}
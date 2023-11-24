#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>

int main(){
    int fp;
    int p,bytesleidos;
    char saludo[]="Un saludito!!!\n",buffer[10];

    p=mkfifo("FIFO2", S_IFIFO | 0666);//Permiso de lectura y escritura

    if (p==-1)
    {
        printf("ERROR EN LA CREACIÓN DEL FIFO\n");
        exit(0);
    }
    while(1){
        fp=open("FIFO2",0);
        bytesleidos=read(fp,buffer,1);
        //bucle de lectura del fifo
        while (bytesleidos!=0){
            printf("%c",buffer[0]);
            bytesleidos=read(fp,buffer,1);
        }
    }
    close(fp);
    return(0);

}

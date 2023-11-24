#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
//#include <sys/wait.h>
#include <string.h>
#include <fcntl.h>

int main(){
    char saludo[]="un saludito!!!\n";
    char buffer[10];
    int fd,bytesleidos;

    fd=open("texto.txt",1);// abre el fichero para escritura
    if (fd==-1)
    {
        printf("ERROR DE APERTURA DEL FICHERO\n");
        exit(-1);
    }
    printf("Escribo en el fichero\n");
    write(fd,saludo,strlen(saludo));
    close(fd);

    fd=open("texto.txt",0);// abre el fichero para escritura
    printf("Contenido del fichero:\n");
    bytesleidos=read(fd,buffer,1);
    while(bytesleidos!=0){
        printf("%c",buffer[0]);
        bytesleidos=read(fd,buffer,1);
    }
    close(fd);
    
}
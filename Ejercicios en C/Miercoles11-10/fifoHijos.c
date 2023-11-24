#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#define NUM_HIJOS 5

int main(){
	pid_t pid, id_hijo;
    int i=0;

    int fd[2];
    pipe(fd);


    for (i=0; i<NUM_HIJOS; i++)
    {
        pid=fork();
        if (pid==-1) //error, no se ha creado el proceso hijo
        {
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        }
        if (pid==0) // proceso hijo 
        {
            printf("Soy el proceso hijo %d\n\t",(i+1));
            printf("Mi PID es %d y el de mi padre es %d\n",getpid(),getppid());
            close(fd[0]);
            int *numero;
            *numero=i+1000;
            write(fd[1],numero,sizeof(int));
            close(fd[1]);
            printf("Fin del hijo %d\n",(i+1));
            exit(0);
        }
    }//final del for
    printf("Soy el proceso padre\n\t");
    printf("mi PID es %d, el de mi padre es %d\n",getpid(),getppid());
    int buffer[1];
    for (i=0; i<NUM_HIJOS; i++)
    {
        read(fd[0],buffer,sizeof(int));
        printf("he leído %d\n",buffer[0]);
    }
    close(fd[0]);
    printf("\nFin del padre\n");
    
    return 0;
}

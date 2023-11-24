#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void main(){
	pid_t pid, id_hijo;
    int i=0;


    for (i=0; i<5; i++)
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
            sleep(10);
            printf("Fin del hijo %d\n",(i+1));
            exit(0);
        }
    }
    if (pid!=-1 && pid!=0) 
    {
        printf("Soy el proceso padre\n\t");
        printf("mi PID es %d, el de mi padre es %d\n",getpid(),getppid());
        sleep(20);
        printf("\nFin del padre\n");
    }
    exit(0);
}
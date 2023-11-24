#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void main(){
	pid_t pid, id_hijo;

	pid=fork();
	if (pid==-1) //error, no se ha creado el proceso hijo
	{
		printf("No se ha podido crear el proceso hijo...\n");
		exit(-1);
	}
	if (pid==0) // proceso hijo
	{
		printf("Soy el proceso hijo\n\t");
		printf("Mi PID es %d y el de mi padre es %d\n",getpid(),getppid());
	}
	else // proceso padre 
	{
             	id_hijo=wait(NULL);
		printf("Soy el proceso padre\n\t");
		printf("mi PID es %d, el de mi padre es %d\n",getpid(),getppid());
		printf("mi hijo  %d terminó\n",id_hijo);
	}

	exit(0);
}


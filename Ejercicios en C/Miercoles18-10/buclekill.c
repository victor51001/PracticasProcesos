#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

void gestion_padre (int segnal)
{
	printf("Padre ha recibido la señal %d\n",segnal);
}
void gestion_hijo (int segnal)
{
    printf("Hijo ha recibido la señal %d\n",segnal);
}

int main(){
	int pid_hijo,pid_padre;

	pid_padre=getpid();
	pid_hijo=fork();
	switch(pid_hijo){
		case -1:
			printf("error al crear el proceso\n");
			exit(-1);
		case 0: //hijo
			signal(SIGUSR1,gestion_hijo);
			while(1){
				sleep(1);
				kill(pid_padre,SIGUSR1);
				pause();
			};
			break;
		default: //padre
			signal(SIGUSR1,gestion_padre);
			while(1){
				pause();
				sleep(1);
				kill(pid_hijo,SIGUSR1);
			};
			break;
	}
	return(0);
}

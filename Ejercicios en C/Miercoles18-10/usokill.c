#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

void manejador (int segnal)
{
	printf("Se ha recibido la señal %d\n",segnal);
}

int main(){
	int pid_hijo;

	pid_hijo=fork();
	switch(pid_hijo){
		case -1:
			printf("error al crear el proceso\n");
			exit(-1);
		case 0:
			signal(SIGUSR1,manejador);
			while(1){
			};
			break;
		default:
			sleep(1);
			kill(pid_hijo,SIGUSR1);
			sleep(1);
			kill(pid_hijo,SIGUSR1);
			sleep(5);
			kill(pid_hijo,SIGKILL);
			break;
	}
	return(0);
}

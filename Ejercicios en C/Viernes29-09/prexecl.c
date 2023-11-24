#include <stdio.h>
#include <unistd.h>

void main(){
	printf("Ejemplo de uso de exec():\n");
	printf("listado del directorio:");
   	execl("/bin/ls", "ls", "-l", (char *)NULL);
	printf("\nFin del programa...\n");
}

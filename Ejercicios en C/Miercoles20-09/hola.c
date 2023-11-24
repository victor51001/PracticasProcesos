#include <stdio.h>

void main(){

	char nombre[10]="Javier";
	int edad=50;
	float estatura=1.78;

	printf("Nombre:");
	scanf("%s",nombre);
	printf("Edad:");
        scanf("%d",&edad);
	printf("Estatura:");
        scanf("%f",&estatura);

	printf("Hola %s, tienes %d años y mides %f metros\n",nombre,edad,estatura);

	if (edad>64)
		printf("Puedes jubilarte\n");
	else
		printf("Estás en lo mejor de la vida");




}

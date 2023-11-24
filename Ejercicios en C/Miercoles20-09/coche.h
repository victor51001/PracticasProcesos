#include <string.h>
#include <stdlib.h>

typedef struct {
    char matricula[10];
    //char *matricula;
    int tamagno;
} Coche;

Coche* nuevoCocheGenerico();
/*crea un coche con matricula vacia y tipo 0 */
Coche* nuevoCoche(char *matricula, int tamagno);
void leerCoche(Coche *c);
/*modifica los datos de un coche que ya existe*/
int compararMatricula(Coche c, char *matricula);
/* devuelve 1 si la matricula es igual a la cadena*/
char* getMatricula(Coche c);
/*devuelve la matricula del coche */
char* toStringCoche(Coche c);



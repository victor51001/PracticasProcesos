#include <string.h>
#include <stdlib.h>
#define VUELTAS 30

void destruir() {
    printf("Borrando disco..");
    for (int i=0; i<10; i++) {
        sleep(1);
        printf(".");
    }
    printf("\n------Disco borrado------\n");
    exit(0);
}
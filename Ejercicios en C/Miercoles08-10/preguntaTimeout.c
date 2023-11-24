#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void main() {
    int anyo;
    while (anyo!=1492) {
        printf("¿En que anyo se descubrio America? ¡Si no aciertas en 30 segundos destruiré todos tus datos!\n");
        scanf("%d", &anyo);
    }
    printf("Por esta vez te has salvado, no te fíes de los extraños\n");
}
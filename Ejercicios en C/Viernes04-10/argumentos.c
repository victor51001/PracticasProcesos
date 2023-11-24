#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv) 
{
    int i;

    for(i=0;i<argc;i++) 
    {
        printf("Argumento %d: vale %s:\n",i,argv[i]);
    }
    for(i=0;i<argv[2];i++) 
    {
        printf("%d\n",argv[1]);
    }
}
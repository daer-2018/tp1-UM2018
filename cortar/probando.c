
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/types.h>
#include <math.h>      



int main(int argc, char const *argv[])
{
  /*
struct stat pesar;

int fd=open(argv[1],O_RDONLY,S_IRUSR);
fstat(fd,&pesar);
float k= (float)pesar.st_size;
printf("TAMANO DE ARCHIVO %lld\n",(long long)pesar.st_size);
float c=ceil(k);
printf("TAMANO DE ARCHIVO %1lf\n",c);*/

       float val1, val2, val3, val4;

   val1 = 1.6;
   val2 = 1.2;
   val3 = 2.8;
   val4 = 2.3;

   printf ("value1 = %.1lf\n", ceil(val1));
   printf ("value2 = %.1lf\n", ceil(val2));
   printf ("value3 = %.1lf\n", ceil(val3));
   printf ("value4 = %.1lf\n", ceil(val4));
   
   return(0);
}
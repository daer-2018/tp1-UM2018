#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
//#include <malloc.h>

#include "parametro_header.h"
#include "archivo_header.h"

char * opcion_o = NULL;	
int opterr=0;
int salida=1;
void ayuda(int n){
  if(!n)
  printf("....OPCIÓN INVALIDA....\n");
  printf("Opciones: \n -h: Ayuda\n -o [archivo_salida]\n");
  //exit(1);
}
//Si no se especifica nada, la salida se envía a stdout.//
int main(int argc, char * const argv[]){
	int c;

	while ((c=getopt(argc, argv, "ho:"))>=0) {
		switch (c) {
			case 'h':	
				ayuda(1);
				return 0;
			case 'o':
				opcion_o=optarg;
				break;
			default:
				ayuda(0);
				return 1;
		}
	}
if(opcion_o!=NULL){//*BLOQUE CON NOMBRE DE ARCHIVO DE ENTRADA*//
    salida = 3;
    return (pegar_leidos(opcion_o,salida));
} 
else{ /*BLOQUE SIN NOMBRE DE ARCHIVO DE ENTRADA*/
     return (pegar_leidos(opcion_o,salida));
}
return 0;
}

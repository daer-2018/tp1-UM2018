
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "parametro_header.h"
#include "archivo_header.h"

int opterr=0;

void ayuda(int n){
  if(!n)
  printf("....OPCIÓN INVALIDA....\n");
  printf("Opciones: \n -h: Ayuda\n -o [archivo_salida]\n"
        " -i [archivo_entrada]\n -s [tamaño de corte] -n [número de cortes] : \"solo una\" \n");
}

int main(int argc, char * const argv[]){
	char * salida = NULL, * entrada = NULL; 
  int tamanio=0,partes=0, c;


	while ((c=getopt(argc, argv, "n:s:i:ho:")) >= 0) {


		switch (c) {
			case 'h':	
				ayuda(1);
				return 0;
			case 'o': // pasa archivo de salida
				salida=optarg;
				break;
      case 'i':// pasa archivo de entrada
        entrada=optarg;
        break;// pasa peso de cada archivo EXCLUYENTE   
      case 's':
        tamanio=atoi(optarg);// 0 1
        break;
      case 'n':// pasa número de cortes EXCLUYENTE 
        partes=atoi(optarg);//0 1
        break;                  
			default:                  //01 10
				ayuda(0);               //10
				return 1;               //11
		}
	}
  if( !(entrada==NULL) ){

    if(!(tamanio != 0 && partes!=0)){  
      
      //Asumo que siempre hay: un -i y un -s ó -n. 
      if( (tamanio == 0 && partes!=0) ){

        //if( !(salida==NULL) ){ 
          // -i, -n, -o Salida escrita en archivo
        /// FALTA GESTIONAR n

        if(cortar_npartesarchivo(entrada,partes,salida)==1)
            return 1;
         // printf("PARTES SALIDA x ARCHIVO \n");
        
       /* }else{
          //-i, n , salida escrita por panthttps://es.wikipedia.org/wiki/Printfalla
          int a = cortar_npartesarchivo(entrada,partes,salida);
          printf("PARTESS SALIDA x PANTALLA \n");*/
       // }

      }else{

        /*if(!(salida==s)){*/
          //-i, -s, -o salida por archivo 
         // printf("TAMAÑO SALIDA x ARCHIVO \n");
         // printf("ientrada-%s tamanio- %d osalida- %s\n", entrada, tamanio, salida);

          if(cortar_stamanio(entrada,tamanio,salida)==1 ) 
              return 1;

      
        /*}else{
      
          //-i, -s, Salida por pantalla 
          printf("TAMAÑO SALIDA x PANTALLA \n");  
      
        } */ 
      }
    return 0;
    }
  }       
ayuda(0);
return 0;
}

/*$ ./cortar -s 400 -i [archivo_entrada] -o [archivos_salida0*]
*cantidad de partes a cortar -n [cantidad] o -s [tamaño] (ambas son excluyentes).
*Soportar la opcion -o [archivo_de_salida] Cortar adicionalmente tiene la opcion -i.
*Reciben los datos de stdin
*Si no se especifica nada, la salida se envía a stdout.
Requerimientos*/

//Excluyentes s o n
/*$ ./cortar (-s 400 | -n 4) (-i [archivo_entrada]) (-o [archivos_salida0*])*/
/*$ ./cortar -s 400 -i [archivo_entrada] stdout */
// m==0?d=2:d=3;
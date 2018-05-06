
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <math.h>      
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/types.h>
#include "archivo_header.h"

  
int cortar_npartesarchivo(char *ientrada,int npartes,char *osalida){
  //printf("ientrada-%s npartes- %d osalida- %s\n", ientrada, npartes, osalida);

 
  int i=0,tam=0;
  struct stat pesar;

  
  archivo_t *a= malloc(sizeof (archivo_t));
  if( a==NULL ) return 1; //si no hay memoría = "NULL" 

  archivo_t *b= malloc(sizeof (archivo_t));
  if( b==NULL ) return 1; //si no hay memoría = "NULL" 

  a->fd=open(ientrada,O_RDONLY,S_IRUSR); // Leo entrada a cosrtar!!!
  if(a->fd==-1)return 1;

  

  fstat(a->fd,&pesar); // Retorna tamaño en bytes

  int res= (int)pesar.st_size;

  printf(" TAMANO%d\n",res);
    tam = pesar.st_size/(npartes)+1 ;







  ///ACÁ PESAR EL ARCHIVO





                                          //((sizeof a->cont)*3)= (buffern * npartes) 
    //while( (a->leid=read(a->fd,a->cont,sizeof a->cont) ) > 0){
          while( (a->leid=read(a->fd,a->cont,tam) ) > 0){


      if( !(osalida==NULL) ){ // PASANDO EL NOMBE DE ARCHIVO CON -o
        snprintf(a->lee,sizeof(a->lee),"%s-%d.txt",osalida,i);

        b->fd=open(a->lee,FLAG_O,MODO_O);
        if(b->fd==-1)return 1;

          write(b->fd,a->cont,a->leid);
      // i++;
      }else{ // SIN PASAR NOMBRE DE ARCHIVO, SALE POR PANTALLA !!!
//       printf("\n################# parte %d / %d \n",(i+1),npartes);

       printf("\n################# parte %d\n",(i+1));

        //write(STDOUT_FILENO,a->cont,tam);
               write(STDOUT_FILENO,a->cont,a->leid);

       // i++;
     }i++;

    }
  



  close(a->fd);
  free(b);
  free(a);
return 0;  

}

int cortar_stamanio(char *ientrada,int spartes,char *osalida){
 // printf("ientrada-%s spartes- %d osalida- %s\n", ientrada, spartes, osalida);
  int i=0;

  archivo_t *a= malloc(sizeof (archivo_t));
  if( a==NULL ) return 1; //si no hay memoría = "NULL" 

  archivo_t *b= malloc(sizeof (archivo_t));
  if( b==NULL ) return 1; //si no hay memoría = "NULL" 

  a->fd=open(ientrada,O_RDONLY,S_IRUSR); // Leo entrada a cortar
  if(a->fd==-1)return 1;
    
    while( (a->leid=read(a->fd,a->cont,spartes) ) > 0){

      //¿ME PASASTE ARCHIVO DE ENTRADA -o ?
    if( !(osalida==NULL) ){ //si
    
      snprintf(a->lee,sizeof(a->lee),"%s-%d.txt",osalida,i);
      
      b->fd=open(a->lee,FLAG_O,MODO_O);
      if(b->fd==-1)return 1;
      
        write(b->fd,a->cont,a->leid); // tiene que ser <= aue spartes
        i++;
    
    }else{//no
        
        printf("\n################# parte %d \n",i);
        write(STDOUT_FILENO,a->cont,a->leid);
        i++;

    }

  }
  close(a->fd);
  free(b);
  free(a);
return 0; 
}

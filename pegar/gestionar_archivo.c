
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "archivo_header.h"

int pegar_leidos(char *nombre, int  salida){

  archivo_t *a= malloc(sizeof (archivo_t));
  if( a==NULL ) return 1; //si no hay memoría = "NULL" 

  archivo_t *b= malloc(sizeof (archivo_t));
  if( b==NULL ) return 1; //si no hay memoría = "NULL" 

  a->fd=open(nombre,FLAG_O,MODO_O); // fata  validar los open if(a->fd)
  if(a->fd==-1)return 1;

  while( (a->leid=read(STDIN_FILENO,a->cont,sizeof (a->cont)) ) > 0){
    
    char *token = strtok(a->cont,"\n");

      while( token != NULL){

        b->fd=open(token,O_RDONLY,S_IRUSR);
        if(b->fd==-1) return 1;

          while( (b->leid = read(b->fd,b->cont,sizeof (b->cont))) > 0){
        
            (salida ==1)? 
            write(STDOUT_FILENO, b->cont,b->leid):          
            write(a->fd,b->cont,b->leid);
          }
        close(b->fd);  
        token=strtok(NULL,"\n");
      }
    }
    close(a->fd);
    free(b);
    free(a);
  
  
return 0;
}
